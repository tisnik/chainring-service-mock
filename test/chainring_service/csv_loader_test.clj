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

(ns chainring-service.csv-loader-test
  (:require [clojure.test :refer :all]
            [chainring-service.csv-loader :refer :all]))

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

(deftest test-csv-data->maps-existence
  "Check that the chainring-service.csv-loader/csv-data->maps definition exists."
  (testing
    "if the chainring-service.csv-loader/csv-data->maps definition exists."
    (is (callable? 'chainring-service.csv-loader/csv-data->maps))))


(deftest test-load-csv-existence
  "Check that the chainring-service.csv-loader/load-csv definition exists."
  (testing "if the chainring-service.csv-loader/load-csv definition exists."
           (is (callable? 'chainring-service.csv-loader/load-csv))))


(deftest test-load-csv-for-all-dates-existence
  "Check that the chainring-service.csv-loader/load-csv-for-all-dates definition exists."
  (testing
    "if the chainring-service.csv-loader/load-csv-for-all-dates definition exists."
    (is (callable? 'chainring-service.csv-loader/load-csv-for-all-dates))))

