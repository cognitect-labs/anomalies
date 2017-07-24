;; Copyright (c) Cognitect, Inc.
;; All rights reserved.

;; Licensed under the Apache License, Version 2.0 (the "License");
;; you may not use this file except in compliance with the License.
;; You may obtain a copy of the License at
;;
;;      http://www.apache.org/licenses/LICENSE-2.0
;;
;; Unless required by applicable law or agreed to in writing, software
;; distributed under the License is distributed on an "AS-IS" BASIS,
;; WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
;; See the License for the specific language governing permissions and
;; limitations under the License.

(ns cognitect.anomalies
  (:require [clojure.spec.alpha :as s]))

(s/def ::category #{::unavailable
                    ::interrupted
                    ::incorrect
                    ::forbidden
                    ::unsupported
                    ::not-found
                    ::conflict
                    ::fault
                    ::busy})
(s/def ::message string?)
(s/def ::anomaly (s/keys :req [::category]
                         :opt [::message]))


