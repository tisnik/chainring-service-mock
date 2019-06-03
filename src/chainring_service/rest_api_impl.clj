
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

(ns chainring-service.rest-api-impl
    "Rest API endpoints implementations.

    Author: Pavel Tisnovsky")


(require '[clojure.tools.logging                   :as log])
(require '[chainring-service.rest-api-utils        :as rest-api-utils])
(require '[chainring-service.sap-interface         :as sap-interface])
(require '[chainring-service.mocked-sap-interface  :as mocked-sap-interface])


(defn all-aoids
    "Generate response with all AOIDs for the date-from with possible filtering."
    [request date-from]
    (let [start-time (rest-api-utils/current-time)
          buildings  (sap-interface/call-sap-interface request "read-buildings" nil date-from)
          floors     (sap-interface/call-sap-interface request "read-floors" nil nil date-from)
          end-time   (rest-api-utils/current-time)
          timestamp  (rest-api-utils/get-timestamp)
          response   {:status     :ok
                      :duration   (- end-time start-time)
                      :valid-from date-from
                      :timestamp  timestamp
                      :aoids      (concat buildings floors)}]
        response))


(defn all-objects
    "Generate response with all objects for the date-from with possible filtering."
    [request date-from]
    (let [start-time (rest-api-utils/current-time)
          buildings  (sap-interface/call-sap-interface request "read-buildings" nil date-from)
          floors     (sap-interface/call-sap-interface request "read-floors" nil nil date-from)
          end-time   (rest-api-utils/current-time)
          timestamp  (rest-api-utils/get-timestamp)
          response   {:status    :ok
                      :duration  (- end-time start-time)
                      :timestamp timestamp
                      :buildings buildings
                      :floors    floors}]
        response))


(defn buildings
    "Generate response with list of buildings with possible filtering."
    [request date-from]
    (let [start-time (rest-api-utils/current-time)
          buildings  (sap-interface/call-sap-interface request "read-buildings" date-from)
          end-time   (rest-api-utils/current-time)
          timestamp  (rest-api-utils/get-timestamp)
          response   {:status    :ok
                      :duration  (- end-time start-time)
                      :timestamp timestamp
                      :buildings buildings}]
        response))


(defn floors
    "Generate response with list of floors with possible filtering."
    [request building-id date-from]
    (let [start-time (rest-api-utils/current-time)
          floors     (sap-interface/call-sap-interface request "read-floors" building-id date-from)
          end-time   (rest-api-utils/current-time)
          timestamp  (rest-api-utils/get-timestamp)
          response   {:status       :ok
                      :duration     (- end-time start-time)
                      :timestamp    timestamp
                      :building-id  building-id
                      :floors       floors}]
        response))


(defn rooms
    "Generate response with list of rooms with possible filtering."
    [request building-id floor-id date-from]
    (let [start-time (rest-api-utils/current-time)
          rooms      (sap-interface/call-sap-interface request "read-rooms" floor-id date-from)
          end-time   (rest-api-utils/current-time)
          timestamp  (rest-api-utils/get-timestamp)
          response   {:status       :ok
                      :duration     (- end-time start-time)
                      :timestamp    timestamp
                      :building-id  building-id
                      :floor-id     floor-id
                      :rooms        rooms}]
        response))


(defn building
    "Generate response with information about selected building."
    [request building-id date-from]
    (let [start-time    (rest-api-utils/current-time)
          building-info (sap-interface/call-sap-interface request "read-building-info" building-id date-from)
          end-time   (rest-api-utils/current-time)
          timestamp  (rest-api-utils/get-timestamp)
          response   {:status         :ok
                      :building-id    building-id
                      :duration       (- end-time start-time)
                      :timestamp      timestamp
                      :date-from      date-from
                      :building-info  building-info}]
        response))


(defn floor
    "Generate response with information about selected floor."
    [request floor-id date-from]
    (let [start-time (rest-api-utils/current-time)
          floor-info (sap-interface/call-sap-interface request "read-floor-info" floor-id date-from)
          end-time   (rest-api-utils/current-time)
          timestamp  (rest-api-utils/get-timestamp)
          response   {:status         :ok
                      :floor-id       floor-id
                      :duration       (- end-time start-time)
                      :timestamp      timestamp
                      :date-from      date-from
                      :floor-info     floor-info}]
        response))


(defn room
    "Generate response with information about selected room."
    [request room-id date-from]
    (let [start-time (rest-api-utils/current-time)
          room-info  (sap-interface/call-sap-interface request "read-room-info" room-id date-from)
          end-time   (rest-api-utils/current-time)
          timestamp  (rest-api-utils/get-timestamp)
          response   {:status         :ok
                      :room-id       room-id
                      :duration       (- end-time start-time)
                      :timestamp      timestamp
                      :date-from      date-from
                      :room-info     room-info}]
        response))
