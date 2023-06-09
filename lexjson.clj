;--------------------------------------------------------------------------------------------------------
; LexJson is a lexical highlighter for JSON files written in Clojure.
;
; Source Github repository: https://www.github.com/Its-Yayo/lexjson
; Date: 06 - 14 - 2023
;
; Authors: Luis Fernando De León Silva - A01754574 (https://www.github.com/Its-Yayo)
;          Joahan Javier García Fernandez - A01748222 (https://www.github.com/joahangf11)
;          Benjamin Alejandro Cruz Cervantes - A01747811 (https://www.github.com/BenjaminCruz-A01747811)
;
; Code under free licence.
;--------------------------------------------------------------------------------------------------------

(ns lexjson
  (:import (instaparse.gll Failure))
  (:require [clojure.string :as str]
            [instaparse.core :refer [parser]]))

;(defn fails? [r] (instance? Failure r))
;(defn succeeds? [r] (not (fails? r)))

;; Issue to check #1
(def json-grammar #"(?xi)
    (\w+)            # Group 1 : String
  | ( [0-9]+ )       # Group 2 : Number
  | ( true )         # Group 3 : True
  | ( false )        # Group 4 : False
  | ( null )         # Group 5 : Null
  | ( [{] )          # Group 6 : Opening Key
  | ( [}] )          # Group 7 : Closing Key
  | ( \[ )           # Group 8 : Opening Value
  | ( \] )           # Group 9 : Closing Value
  | ( : )            # Group 10 : Colon
  | ( , )            # Group 11 : Comma
  | ( \s+ )          # Group 12 : Whitespace
  | ( . )            # Group 13 : Error Character


 ")

(defn tokenize [input]
  "Tokenizes a string into a list of tokens"
  (map (fn [token]
         (cond
           (token 1) [:string (token 0)]
           (token 2) [:number (token 0)]
           (token 3) [:true (token 0)]
           (token 4) [:false (token 0)]
           (token 5) [:null (token 0)]
           (token 6) [:opening-key (token 0)]
           (token 7) [:closing-key (token 0)]
           (token 8) [:opening-value (token 0)]
           (token 9) [:closing-value (token 0)]
           (token 10) [:colon (token 0)]
           (token 11) [:comma (token 0)]
           (token 12) [:whitespace (token 0)]
           (token 13) [:error (token 0)]))
       (remove (fn [v] (v 12)) (re-seq json-grammar input))))

(defn tokenize-file [file]
 "Tokenizes a file into a list of tokens"
  (tokenize (slurp file)))
;
;(def html-template "
;  <!DOCTYPE html>
;  <html lang=\"es\">
;  <head>
;    <meta charset=\"UTF-8\">
;    <title>LexJson</title>
;    <style>
;      body {
;        background-color: #DAF7DC;
;        color: #fff;
;        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
;      }
;    </style>
;  </head>
;  <body>
;     <h1>LexJson</h1>
;  </body>
;  </html>")
;
;(defn htmlize [lst]
;  "Converts a list of tokens into a HTML file")
;
;(defn json->html [in-json out-html]
;  "Converts a JSON file into a HTML file")
;
;
;
