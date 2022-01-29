(ns name-grabber.core
  (:require [clojure.string :as str]
            [clojure.set])
  (:gen-class))

;;(defn refr [] (use 'name-grabber.core :reload-all))

(defn parse
  "returns input string as set split on character"
  [string]
  (set (str/split string #"\n")))

(defn shorten-string
  "returns input string only before first comma and sets case"
  [string]
  (str/upper-case (first (str/split string #","))))

(defn csv-handler
  "expects set of name-data strings, returns set of strings with names only"
  [strings]
  (->> strings (map shorten-string) (into #{})))

;; constants for csv source files
(def surnames (csv-handler (parse (slurp "resources/surnames.csv"))))
(def firstnames (csv-handler (parse (slurp "resources/firstnames.csv"))))

(defn remove-punc
  "strips punctuation from input string"
  [input]
  (str/replace input #"[-_—,.;:'\"/!?@&#$%`~]" " "))

(defn surname-check
  "checks input for match in csv constant"
  [user-input]
  (contains? surnames (str/upper-case user-input)))

(defn firstname-check
  "checks input for match in csv constant"
  [user-input]
  (contains? firstnames (str/upper-case user-input)))

(defn firstname-find
  "returns collection of first names found in input string"
  [string]
  (filter firstname-check (str/split (remove-punc string) #" ")))

(defn surname-find
  "returns collection of surnames found in input string"
  [string]
  (filter surname-check (str/split (remove-punc string) #" ")))

(defn -main
  "checks for first or last name in input-string based on first argument"
  [name string]
  (if name (firstname-find string) (surname-find string)))

