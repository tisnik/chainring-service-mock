;
;  (C) Copyright 2020  Pavel Tisnovsky
;
;  All rights reserved. This program and the accompanying materials
;  are made available under the terms of the Eclipse Public License v1.0
;  which accompanies this distribution, and is available at
;  http://www.eclipse.org/legal/epl-v10.html
;
;  Contributors:
;      Pavel Tisnovsky
;

(ns chainring-service.rest-api-test
  (:require [clojure.test :refer :all]
            [chainring-service.rest-api :refer :all]))

;
; Common functions used by tests.
;

(defn callable?
    "Test if given function-name is bound to the real function."
    [function-name]
    (clojure.test/function? function-name))

;
; Tests for functions existence
;

(deftest test-unknown-endpoint-handler-existence
  "Check that the chainring-service.rest-api/unknown-endpoint-handler definition exists."
  (testing "if the chainring-service.rest-api/unknown-endpoint-handler definition exists."
    (is (callable? 'chainring-service.rest-api/unknown-endpoint-handler))))


(deftest test-toplevel-handler-existence
  "Check that the chainring-service.rest-api/toplevel-handler definition exists."
  (testing "if the chainring-service.rest-api/toplevel-handler definition exists."
    (is (callable? 'chainring-service.rest-api/toplevel-handler))))


(deftest test-api-info-handler-existence
  "Check that the chainring-service.rest-api/api-info-handler definition exists."
  (testing "if the chainring-service.rest-api/api-info-handler definition exists."
    (is (callable? 'chainring-service.rest-api/api-info-handler))))


(deftest test-info-handler-existence
  "Check that the chainring-service.rest-api/info-handler definition exists."
  (testing "if the chainring-service.rest-api/info-handler definition exists."
    (is (callable? 'chainring-service.rest-api/info-handler))))


(deftest test-liveness-handler-existence
  "Check that the chainring-service.rest-api/liveness-handler definition exists."
  (testing "if the chainring-service.rest-api/liveness-handler definition exists."
    (is (callable? 'chainring-service.rest-api/liveness-handler))))


(deftest test-readiness-handler-existence
  "Check that the chainring-service.rest-api/readiness-handler definition exists."
  (testing "if the chainring-service.rest-api/readiness-handler definition exists."
    (is (callable? 'chainring-service.rest-api/readiness-handler))))


(deftest test-config-handler-existence
  "Check that the chainring-service.rest-api/config-handler definition exists."
  (testing "if the chainring-service.rest-api/config-handler definition exists."
    (is (callable? 'chainring-service.rest-api/config-handler))))


(deftest test-list-all-aoids-existence
  "Check that the chainring-service.rest-api/list-all-aoids definition exists."
  (testing "if the chainring-service.rest-api/list-all-aoids definition exists."
    (is (callable? 'chainring-service.rest-api/list-all-aoids))))


(deftest test-list-all-objects-existence
  "Check that the chainring-service.rest-api/list-all-objects definition exists."
  (testing "if the chainring-service.rest-api/list-all-objects definition exists."
    (is (callable? 'chainring-service.rest-api/list-all-objects))))


(deftest test-list-of-buildings-handler-existence
  "Check that the chainring-service.rest-api/list-of-buildings-handler definition exists."
  (testing "if the chainring-service.rest-api/list-of-buildings-handler definition exists."
    (is (callable? 'chainring-service.rest-api/list-of-buildings-handler))))


(deftest test-list-of-floors-handler-existence
  "Check that the chainring-service.rest-api/list-of-floors-handler definition exists."
  (testing "if the chainring-service.rest-api/list-of-floors-handler definition exists."
    (is (callable? 'chainring-service.rest-api/list-of-floors-handler))))


(deftest test-list-of-rooms-handler-existence
  "Check that the chainring-service.rest-api/list-of-rooms-handler definition exists."
  (testing "if the chainring-service.rest-api/list-of-rooms-handler definition exists."
    (is (callable? 'chainring-service.rest-api/list-of-rooms-handler))))


(deftest test-info-about-building-handler-existence
  "Check that the chainring-service.rest-api/info-about-building-handler definition exists."
  (testing "if the chainring-service.rest-api/info-about-building-handler definition exists."
    (is (callable? 'chainring-service.rest-api/info-about-building-handler))))


(deftest test-info-about-floor-handler-existence
  "Check that the chainring-service.rest-api/info-about-floor-handler definition exists."
  (testing "if the chainring-service.rest-api/info-about-floor-handler definition exists."
    (is (callable? 'chainring-service.rest-api/info-about-floor-handler))))


(deftest test-info-about-room-handler-existence
  "Check that the chainring-service.rest-api/info-about-room-handler definition exists."
  (testing "if the chainring-service.rest-api/info-about-room-handler definition exists."
    (is (callable? 'chainring-service.rest-api/info-about-room-handler))))


(deftest test-list-all-dates-from-existence
  "Check that the chainring-service.rest-api/list-all-dates-from definition exists."
  (testing "if the chainring-service.rest-api/list-all-dates-from definition exists."
    (is (callable? 'chainring-service.rest-api/list-all-dates-from))))


(deftest test-nearest-date-from-existence
  "Check that the chainring-service.rest-api/nearest-date-from definition exists."
  (testing "if the chainring-service.rest-api/nearest-date-from definition exists."
    (is (callable? 'chainring-service.rest-api/nearest-date-from))))


(deftest test-sap-reload-mock-data-existence
  "Check that the chainring-service.rest-api/sap-reload-mock-data definition exists."
  (testing "if the chainring-service.rest-api/sap-reload-mock-data definition exists."
    (is (callable? 'chainring-service.rest-api/sap-reload-mock-data))))


(deftest test-get-sap-href-existence
  "Check that the chainring-service.rest-api/get-sap-href definition exists."
  (testing "if the chainring-service.rest-api/get-sap-href definition exists."
    (is (callable? 'chainring-service.rest-api/get-sap-href))))


(deftest test-get-sap-selector-existence
  "Check that the chainring-service.rest-api/get-sap-selector definition exists."
  (testing "if the chainring-service.rest-api/get-sap-selector definition exists."
    (is (callable? 'chainring-service.rest-api/get-sap-selector))))


(deftest test-sap-href-handler-existence
  "Check that the chainring-service.rest-api/sap-href-handler definition exists."
  (testing "if the chainring-service.rest-api/sap-href-handler definition exists."
    (is (callable? 'chainring-service.rest-api/sap-href-handler))))


(deftest test-sap-debug-handler-existence
  "Check that the chainring-service.rest-api/sap-debug-handler definition exists."
  (testing "if the chainring-service.rest-api/sap-debug-handler definition exists."
    (is (callable? 'chainring-service.rest-api/sap-debug-handler))))


(deftest test-rooms-attribute-existence
  "Check that the chainring-service.rest-api/rooms-attribute definition exists."
  (testing "if the chainring-service.rest-api/rooms-attribute definition exists."
    (is (callable? 'chainring-service.rest-api/rooms-attribute))))


(deftest test-possible-attributes-existence
  "Check that the chainring-service.rest-api/possible-attributes definition exists."
  (testing "if the chainring-service.rest-api/possible-attributes definition exists."
    (is (callable? 'chainring-service.rest-api/possible-attributes))))


(deftest test-drawings-cache-info-handler-existence
  "Check that the chainring-service.rest-api/drawings-cache-info-handler definition exists."
  (testing "if the chainring-service.rest-api/drawings-cache-info-handler definition exists."
    (is (callable? 'chainring-service.rest-api/drawings-cache-info-handler))))


(deftest test-missing-parameter-existence
  "Check that the chainring-service.rest-api/missing-parameter definition exists."
  (testing "if the chainring-service.rest-api/missing-parameter definition exists."
    (is (callable? 'chainring-service.rest-api/missing-parameter))))


(deftest test-try-to-load-drawing-existence
  "Check that the chainring-service.rest-api/try-to-load-drawing definition exists."
  (testing "if the chainring-service.rest-api/try-to-load-drawing definition exists."
    (is (callable? 'chainring-service.rest-api/try-to-load-drawing))))


(deftest test-deserialize-drawing-existence
  "Check that the chainring-service.rest-api/deserialize-drawing definition exists."
  (testing "if the chainring-service.rest-api/deserialize-drawing definition exists."
    (is (callable? 'chainring-service.rest-api/deserialize-drawing))))


(deftest test-try-to-store-drawing-existence
  "Check that the chainring-service.rest-api/try-to-store-drawing definition exists."
  (testing "if the chainring-service.rest-api/try-to-store-drawing definition exists."
    (is (callable? 'chainring-service.rest-api/try-to-store-drawing))))


(deftest test-serialize-drawing-existence
  "Check that the chainring-service.rest-api/serialize-drawing definition exists."
  (testing "if the chainring-service.rest-api/serialize-drawing definition exists."
    (is (callable? 'chainring-service.rest-api/serialize-drawing))))

