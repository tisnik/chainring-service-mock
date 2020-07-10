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

(ns chainring-service.rest-api-impl-test
  (:require [clojure.test :refer :all]
            [chainring-service.rest-api-impl :refer :all]))

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

(deftest test-all-aoids-existence
  "Check that the chainring-service.rest-api-impl/all-aoids definition exists."
  (testing "if the chainring-service.rest-api-impl/all-aoids definition exists."
           (is (callable? 'chainring-service.rest-api-impl/all-aoids))))


(deftest test-all-objects-existence
  "Check that the chainring-service.rest-api-impl/all-objects definition exists."
  (testing
    "if the chainring-service.rest-api-impl/all-objects definition exists."
    (is (callable? 'chainring-service.rest-api-impl/all-objects))))


(deftest test-buildings-existence
  "Check that the chainring-service.rest-api-impl/buildings definition exists."
  (testing "if the chainring-service.rest-api-impl/buildings definition exists."
           (is (callable? 'chainring-service.rest-api-impl/buildings))))


(deftest test-floors-existence
  "Check that the chainring-service.rest-api-impl/floors definition exists."
  (testing "if the chainring-service.rest-api-impl/floors definition exists."
           (is (callable? 'chainring-service.rest-api-impl/floors))))


(deftest test-rooms-existence
  "Check that the chainring-service.rest-api-impl/rooms definition exists."
  (testing "if the chainring-service.rest-api-impl/rooms definition exists."
           (is (callable? 'chainring-service.rest-api-impl/rooms))))


(deftest test-building-existence
  "Check that the chainring-service.rest-api-impl/building definition exists."
  (testing "if the chainring-service.rest-api-impl/building definition exists."
           (is (callable? 'chainring-service.rest-api-impl/building))))


(deftest test-floor-existence
  "Check that the chainring-service.rest-api-impl/floor definition exists."
  (testing "if the chainring-service.rest-api-impl/floor definition exists."
           (is (callable? 'chainring-service.rest-api-impl/floor))))


(deftest test-room-existence
  "Check that the chainring-service.rest-api-impl/room definition exists."
  (testing "if the chainring-service.rest-api-impl/room definition exists."
           (is (callable? 'chainring-service.rest-api-impl/room))))

