(ns html-parser.core
  (:require [config.core :refer [env]]
            [clojure.string :as str]
            [clojure.inspector :as inspect_data]
            [clojure.java.io :as io]
            [clojure.tools.cli :refer [parse-opts]])
  (:gen-class)
  (:use clojure.pprint))

(def data-to-be-replaced (:data-to-be-replaced env))
(def data-search (:data-search env))
(def data-replaced-css (:data-replaced-css env))
(def data-css-search (:data-css-search env))
(def directory-path (:directory-path-doc env))
(def folder-name (:folder-name env))


(defn html-insertion [file-path]
  (let [html-val (slurp file-path)
        mod-html-body (str/replace html-val data-search data-to-be-replaced)
        mod-html-include-css (str/replace mod-html-body data-css-search data-replaced-css)]
    (io/delete-file file-path)
    (spit file-path mod-html-include-css)))

(defn html-parsing [html-lists]
  (loop [lists html-lists]
    (let [single-list (first lists)]
      (if-not (seq lists)
        (prn "task complete")
        (do
          (html-insertion single-list)
          (recur (rest lists)))))))

(defn folder-traversing []
  (let [file-path directory-path
        folders folder-name]
    (loop [folder-names folders]
      (let [single-folder (first folder-names)
            file-path (str file-path single-folder)
            file-seqs (file-seq (io/file file-path))
            htmls-by-folder (mapv str (filter #(.isFile %) file-seqs))]
        ;(prn folder-names)

        (if-not (seq folder-names)
          (prn "complete")
          (do
            ;(prn htmls-by-folder)
            (html-parsing htmls-by-folder)
            (recur (rest folder-names))))))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (folder-traversing))
