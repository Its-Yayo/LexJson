;--------------------------------------------------------------------------------------------------------
; LexJson is a lexical highlighter for JSON files written in Clojure.
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
            [instaparse.core :refer [parser]]))

(defn fails? [r] (instance? Failure r))
(defn succeeds? [r] (not (fails? r)))

;; Issue to check #1
(def json-grammar #"(?xi)
    (\s+)  # Ws
  | ([^\\]*(?:\\.[^\\]*)*)  # String
  | (\-?(?:0|[1-9]\\d*)(?:\\.\\d+)?(?:[eE][+-]?\\d+)?\)  # Number
  | ((?i)true)  # True
  | ((?i)false)  # False
  | ((?i)null)  # Null
  | ((?x)\\{)  # Opening Key
  | ((?x)\\})  # Closing Key
  | ((?x)\\[)  # Opening Value
  | ((?x)\\])  # Closing Value
  | (:)  # Colon
  | (,)  # Comma")

(defn tokenize [s]
  "Tokenizes a string into a list of tokens")

(defn tokenize-file [file]
  "Tokenizes a file into a list of tokens")

(def html-template "
  <!DOCTYPE html>
  <html lang=\"es\">
  <head>
    <meta charset=\"UTF-8\">
    <title>LexJson</title>
    <style>
      body {
        background-color: #DAF7DC;
        color: #fff;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      }
    </style>
  </head>
  <body>
     <h1>LexJson</h1>
  </body>
  </html>")

(defn htmlize [lst]
  "Converts a list of tokens into a HTML file")

(defn json->html [in-json out-html]
  "Converts a JSON file into a HTML file")



