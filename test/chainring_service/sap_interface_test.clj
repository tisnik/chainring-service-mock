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

(ns chainring-service.sap-interface-test
  (:require [clojure.test :refer :all]
            [chainring-service.sap-interface :refer :all]))

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

(deftest test-get-sap-namespace-existence
  "Check that the chainring-service.sap-interface/get-sap-namespace definition exists."
  (testing
    "if the chainring-service.sap-interface/get-sap-namespace definition exists."
    (is (callable? 'chainring-service.sap-interface/get-sap-namespace))))


(deftest test-call-sap-interface-existence
  "Check that the chainring-service.sap-interface/call-sap-interface definition exists."
  (testing
    "if the chainring-service.sap-interface/call-sap-interface definition exists."
    (is (callable? 'chainring-service.sap-interface/call-sap-interface))))

