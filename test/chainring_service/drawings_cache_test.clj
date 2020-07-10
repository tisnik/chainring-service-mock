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

(ns chainring-service.drawings-cache-test
  (:require [clojure.test :refer :all]
            [chainring-service.drawings-cache :refer :all]))

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

(deftest test-inc-hit-counter-existence
  "Check that the chainring-service.drawings-cache/inc-hit-counter definition exists."
  (testing
    "if the chainring-service.drawings-cache/inc-hit-counter definition exists."
    (is (callable? 'chainring-service.drawings-cache/inc-hit-counter))))


(deftest test-cleanup-least-used-item-existence
  "Check that the chainring-service.drawings-cache/cleanup-least-used-item definition exists."
  (testing
    "if the chainring-service.drawings-cache/cleanup-least-used-item definition exists."
    (is (callable? 'chainring-service.drawings-cache/cleanup-least-used-item))))


(deftest test-write-existence
  "Check that the chainring-service.drawings-cache/write definition exists."
  (testing "if the chainring-service.drawings-cache/write definition exists."
           (is (callable? 'chainring-service.drawings-cache/write))))


(deftest test-delete-existence
  "Check that the chainring-service.drawings-cache/delete definition exists."
  (testing "if the chainring-service.drawings-cache/delete definition exists."
           (is (callable? 'chainring-service.drawings-cache/delete))))


(deftest test-fetch-existence
  "Check that the chainring-service.drawings-cache/fetch definition exists."
  (testing "if the chainring-service.drawings-cache/fetch definition exists."
           (is (callable? 'chainring-service.drawings-cache/fetch))))


(deftest test-store-existence
  "Check that the chainring-service.drawings-cache/store definition exists."
  (testing "if the chainring-service.drawings-cache/store definition exists."
           (is (callable? 'chainring-service.drawings-cache/store))))


(deftest test-cache-size-existence
  "Check that the chainring-service.drawings-cache/cache-size definition exists."
  (testing
    "if the chainring-service.drawings-cache/cache-size definition exists."
    (is (callable? 'chainring-service.drawings-cache/cache-size))))


(deftest test-get-access-times-existence
  "Check that the chainring-service.drawings-cache/get-access-times definition exists."
  (testing
    "if the chainring-service.drawings-cache/get-access-times definition exists."
    (is (callable? 'chainring-service.drawings-cache/get-access-times))))


(deftest test-get-counters-existence
  "Check that the chainring-service.drawings-cache/get-counters definition exists."
  (testing
    "if the chainring-service.drawings-cache/get-counters definition exists."
    (is (callable? 'chainring-service.drawings-cache/get-counters))))

