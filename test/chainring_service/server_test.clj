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

(ns chainring-service.server-test
  (:require [clojure.test :refer :all]
            [chainring-service.server :refer :all]))

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

(deftest test-floor-id->str-existence
  "Check that the chainring-service.server/floor-id->str definition exists."
  (testing "if the chainring-service.server/floor-id->str definition exists."
           (is (callable? 'chainring-service.server/floor-id->str))))


(deftest test-all-drawings-for-floor-existence
  "Check that the chainring-service.server/all-drawings-for-floor definition exists."
  (testing
    "if the chainring-service.server/all-drawings-for-floor definition exists."
    (is (callable? 'chainring-service.server/all-drawings-for-floor))))


(deftest test-entity-count-existence
  "Check that the chainring-service.server/entity-count definition exists."
  (testing "if the chainring-service.server/entity-count definition exists."
           (is (callable? 'chainring-service.server/entity-count))))


(deftest test-prepare-drawing-info-existence
  "Check that the chainring-service.server/prepare-drawing-info definition exists."
  (testing
    "if the chainring-service.server/prepare-drawing-info definition exists."
    (is (callable? 'chainring-service.server/prepare-drawing-info))))


(deftest test-select-nearest-date-existence
  "Check that the chainring-service.server/select-nearest-date definition exists."
  (testing
    "if the chainring-service.server/select-nearest-date definition exists."
    (is (callable? 'chainring-service.server/select-nearest-date))))


(deftest test-log-process-drawing-info-existence
  "Check that the chainring-service.server/log-process-drawing-info definition exists."
  (testing
    "if the chainring-service.server/log-process-drawing-info definition exists."
    (is (callable? 'chainring-service.server/log-process-drawing-info))))


(deftest test-get-api-part-from-uri-existence
  "Check that the chainring-service.server/get-api-part-from-uri definition exists."
  (testing
    "if the chainring-service.server/get-api-part-from-uri definition exists."
    (is (callable? 'chainring-service.server/get-api-part-from-uri))))


(deftest test-get-api-command-existence
  "Check that the chainring-service.server/get-api-command definition exists."
  (testing "if the chainring-service.server/get-api-command definition exists."
           (is (callable? 'chainring-service.server/get-api-command))))


(deftest test-api-call-handler-existence
  "Check that the chainring-service.server/api-call-handler definition exists."
  (testing "if the chainring-service.server/api-call-handler definition exists."
           (is (callable? 'chainring-service.server/api-call-handler))))


(deftest test-handler-existence
  "Check that the chainring-service.server/handler definition exists."
  (testing "if the chainring-service.server/handler definition exists."
           (is (callable? 'chainring-service.server/handler))))

