;
;  (C) Copyright 2017, 2018, 2019  Pavel Tisnovsky
;
;  All rights reserved. This program and the accompanying materials
;  are made available under the terms of the Eclipse Public License v1.0
;  which accompanies this distribution, and is available at
;  http://www.eclipse.org/legal/epl-v10.html
;
;  Contributors:
;      Pavel Tisnovsky
;

(ns chainring-service.server
    "Server module with functions to accept requests and send response back to users via HTTP.

    Author: Pavel Tisnovsky")

(require '[ring.util.response      :as http-response])
(require '[clojure.tools.logging   :as log])
(require '[clojure.pprint          :as pprint])

(require '[clj-fileutils.fileutils :as fileutils])

(require '[chainring-service.rest-api      :as rest-api])
(require '[chainring-service.config        :as config])
(require '[clj-http-utils.http-utils       :as http-utils])
(require '[chainring-service.sap-interface :as sap-interface])

(use     '[clj-utils.utils])


(defn floor-id->str
    "Converts floor-id into string."
    [floor-id]
    (-> floor-id
        (clojure.string/replace \. \_)
        (clojure.string/replace \\ \_)
        (clojure.string/replace \/ \_)))


(defn all-drawings-for-floor
    "Prepares list of all drawings for specified floor."
    [floor-id]
    (let [files     (fileutils/file-list "drawings/" ".json")
          filenames (for [file files] (.getName file))
          floor-id  (floor-id->str floor-id)
          drawings  (filter #(startsWith % floor-id) filenames)]
          (sort drawings)))


(defn entity-count
    "Count number of entities with specified entity type."
    [entities entity-type]
    (count (filter #(= entity-type (:T %)) entities)))


(defn prepare-drawing-info
    "Prepare statistic information about drawing."
    [drawing-id drawing-data]
    (let [entities (:entities drawing-data)]
        {:entities-count {:all       (:entities_count drawing-data)
                          :lines     (entity-count entities "L")
                          :circles   (entity-count entities "C")
                          :arcs      (entity-count entities "A")
                          :texts     (entity-count entities "T")
                          :polylines (entity-count entities "P")}
         :rooms-count    (:rooms_count drawing-data)
         :created        (:created drawing-data)
         :format-version (:version drawing-data)}))


(defn select-nearest-date
    "Select nearest date from the sorted list of input dates."
    [today dates]
    (let [nearest (->> dates
                  (filter #(not (neg? (compare today %))))
                  last)]
         (or nearest (first dates))))


(defn log-process-drawing-info
    "Log all relevant information about selected drawing."
    [project-id project-info building-id building-info floor-id floor-info drawing-id drawing-info rooms]
    (log/info "Project ID:" project-id)
    (log/info "Project info" project-info)
    (log/info "Building ID:" building-id)
    (log/info "Building info" building-info)
    (log/info "Floor ID:" floor-id)
    (log/info "Floor info" floor-info)
    (log/info "Drawing ID:" drawing-id)
    (log/info "Drawing info" drawing-info)
    (log/info "Rooms" rooms))


(defn get-api-part-from-uri
    "Get API part (string) from the full URI. The API part string should not starts with /"
    [uri prefix]
    (let [api-part (re-find #"/[^/]*" (subs uri (count prefix)))]
       (if (and api-part (startsWith api-part "/"))
           (subs api-part 1)
           api-part)))


(defn get-api-command
    "Retrieve the actual command from the API call."
    [uri prefix]
    (if uri
        (if (startsWith uri prefix)
            (let [uri-without-prefix (subs uri (count prefix))]
                (if (empty? uri-without-prefix) ; special handler for a call with / only
                    ""
                    (get-api-part-from-uri uri prefix))))))


(defn api-call-handler
    "This function is used to handle all API calls. Three parameters are expected:
     data structure containing HTTP request, string with URI, and the HTTP method."
    [request uri method prefix]
    (if (= uri prefix)
        (rest-api/api-info-handler request prefix)
        (condp = [method (get-api-command uri prefix)]
            ; toplevel
            [:get  ""]                       (rest-api/api-info-handler request prefix)

            ; common endpoints
            [:get  "info"]                   (rest-api/info-handler request)
            [:get  "liveness"]               (rest-api/liveness-handler request)
            [:get  "readiness"]              (rest-api/readiness-handler request)
            [:get  "config"]                 (rest-api/config-handler request)

            ; endpoints to return list of AOIDs
            [:get  "aoids"]                  (rest-api/list-all-aoids request uri)
            [:get  "objects"]                (rest-api/list-all-objects request uri)
            [:get  "buildings"]              (rest-api/list-of-buildings-handler request uri)
            [:get  "floors"]                 (rest-api/list-of-floors-handler request uri)
            [:get  "rooms"]                  (rest-api/list-of-rooms-handler request uri)

            ; endpoints to return information about selected AOID
            [:get  "building"]               (rest-api/info-about-building-handler request uri)
            [:get  "floor"]                  (rest-api/info-about-floor-handler request uri)
            [:get  "room"]                   (rest-api/info-about-room-handler request uri)

            ; endpoints to work with dates
            [:get  "dates-from"]             (rest-api/list-all-dates-from request uri)
            [:get  "nearest-date-from"]      (rest-api/nearest-date-from request uri)

            [:get  "rooms-attribute"]        (rest-api/rooms-attribute request uri)
            [:get  "possible-attributes"]    (rest-api/possible-attributes request uri)

            [:get  "drawing-data"]           (rest-api/deserialize-drawing request)
            [:put  "drawing-data"]           (rest-api/serialize-drawing request)
            [:post "drawing-data"]           (rest-api/serialize-drawing request)
            [:get  "drawings-cache"]         (rest-api/drawings-cache-info-handler request)
            [:post "sap-reload-mock-data"]   (rest-api/sap-reload-mock-data request uri)
            [:get  "sap-href"]               (rest-api/sap-href-handler request uri)
            [:get  "sap-debug"]              (rest-api/sap-debug-handler request uri)
                                             (rest-api/unknown-endpoint-handler request uri)
        )))


(defn handler
    "Handler that is called by Ring for all requests received from user(s)."
    [request]
    (log/info "request URI:   " (:uri request))
    ;(log/info "configuration: " (:configuration request))
    (let [uri             (:uri request)
          method          (:request-method request)
          api-prefix      (config/get-api-prefix request)
          api-full-prefix (config/get-api-full-prefix request)]
          ;(println uri)
        (cond (= uri api-prefix)            (rest-api/toplevel-handler request api-full-prefix)
              (= uri (str api-prefix "/"))  (rest-api/toplevel-handler request api-full-prefix)
              (startsWith uri api-prefix)   (api-call-handler request uri method api-full-prefix))))
