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

(ns chainring-service.mocked-sap-interface-test
  (:require [clojure.test :refer :all]
            [chainring-service.mocked-sap-interface :refer :all]))

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

(deftest test-load-all-data-files-existence
  "Check that the chainring-service.mocked-sap-interface/load-all-data-files definition exists."
  (testing "if the chainring-service.mocked-sap-interface/load-all-data-files definition exists."
    (is (callable? 'chainring-service.mocked-sap-interface/load-all-data-files))))


(deftest test-aoids-count-per-date-existence
  "Check that the chainring-service.mocked-sap-interface/aoids-count-per-date definition exists."
  (testing "if the chainring-service.mocked-sap-interface/aoids-count-per-date definition exists."
    (is (callable? 'chainring-service.mocked-sap-interface/aoids-count-per-date))))


(deftest test-reload-mock-data-existence
  "Check that the chainring-service.mocked-sap-interface/reload-mock-data definition exists."
  (testing "if the chainring-service.mocked-sap-interface/reload-mock-data definition exists."
    (is (callable? 'chainring-service.mocked-sap-interface/reload-mock-data))))


(deftest test-get-real-date-from-existence
  "Check that the chainring-service.mocked-sap-interface/get-real-date-from definition exists."
  (testing "if the chainring-service.mocked-sap-interface/get-real-date-from definition exists."
    (is (callable? 'chainring-service.mocked-sap-interface/get-real-date-from))))


(deftest test-read-all-dates-from-existence
  "Check that the chainring-service.mocked-sap-interface/read-all-dates-from definition exists."
  (testing "if the chainring-service.mocked-sap-interface/read-all-dates-from definition exists."
    (is (callable? 'chainring-service.mocked-sap-interface/read-all-dates-from))))


(deftest test-read-buildings-existence
  "Check that the chainring-service.mocked-sap-interface/read-buildings definition exists."
  (testing "if the chainring-service.mocked-sap-interface/read-buildings definition exists."
    (is (callable? 'chainring-service.mocked-sap-interface/read-buildings))))


(deftest test-read-building-info-existence
  "Check that the chainring-service.mocked-sap-interface/read-building-info definition exists."
  (testing "if the chainring-service.mocked-sap-interface/read-building-info definition exists."
    (is (callable? 'chainring-service.mocked-sap-interface/read-building-info))))


(deftest test-read-floors-existence
  "Check that the chainring-service.mocked-sap-interface/read-floors definition exists."
  (testing "if the chainring-service.mocked-sap-interface/read-floors definition exists."
    (is (callable? 'chainring-service.mocked-sap-interface/read-floors))))


(deftest test-read-floor-info-existence
  "Check that the chainring-service.mocked-sap-interface/read-floor-info definition exists."
  (testing "if the chainring-service.mocked-sap-interface/read-floor-info definition exists."
    (is (callable? 'chainring-service.mocked-sap-interface/read-floor-info))))


(deftest test-read-rooms-existence
  "Check that the chainring-service.mocked-sap-interface/read-rooms definition exists."
  (testing "if the chainring-service.mocked-sap-interface/read-rooms definition exists."
    (is (callable? 'chainring-service.mocked-sap-interface/read-rooms))))


(deftest test-read-room-info-existence
  "Check that the chainring-service.mocked-sap-interface/read-room-info definition exists."
  (testing "if the chainring-service.mocked-sap-interface/read-room-info definition exists."
    (is (callable? 'chainring-service.mocked-sap-interface/read-room-info))))


(deftest test-read-room-attribute-types-existence
  "Check that the chainring-service.mocked-sap-interface/read-room-attribute-types definition exists."
  (testing "if the chainring-service.mocked-sap-interface/read-room-attribute-types definition exists."
    (is (callable? 'chainring-service.mocked-sap-interface/read-room-attribute-types))))


(deftest test-read-rooms-attribute-existence
  "Check that the chainring-service.mocked-sap-interface/read-rooms-attribute definition exists."
  (testing "if the chainring-service.mocked-sap-interface/read-rooms-attribute definition exists."
    (is (callable? 'chainring-service.mocked-sap-interface/read-rooms-attribute))))


(deftest test-read-rooms-possible-attributes-existence
  "Check that the chainring-service.mocked-sap-interface/read-rooms-possible-attributes definition exists."
  (testing "if the chainring-service.mocked-sap-interface/read-rooms-possible-attributes definition exists."
    (is (callable? 'chainring-service.mocked-sap-interface/read-rooms-possible-attributes))))

