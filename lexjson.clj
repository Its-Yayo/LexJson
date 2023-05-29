;--------------------------------------------------------------------------------------------------------
; LexJson is a Clojure project for parsing JSON
; into a sequence of tokens.
;
; Source Github repository: https://www.github.com/Its-Yayo/lexjson
; Date: 06 - 14 - 2023
;
; Authors: Luis Fernando De León Silva - A01754574 (https://www.github.com/Its-Yayo)
;          Joahan Joahan Javier García Fernandez - A01748222 (https://www.github.com/joahangf11)
;          Benjamin Alejandro Cruz Cervantes - A01747811 (https://www.github.com/BenjaminCruz-A01747811)
;
; Code under free licence.
;--------------------------------------------------------------------------------------------------------

(ns lexjson
  (:import (instaparse.gll Failure))
  (:require [clojure.string :as str]
            [instaparse.core :refer [parser]]
            [clojure.test :refer [deftest is run-tests]]))

(defn fails? [r] (instance? Failure r))
(defn succeeds? [r] (not (fails? r)))

