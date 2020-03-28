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
(def site-map-data (atom []))

;; iterated data stored in atom
(defn site-map-val-generation [file-path]
  (let [url (:site-map-url env)
        trim-path (str "/dandydialer-doc" (apply str
                                            (rest
                                              (str/split file-path #"dandydialer-doc"))))
        mod-file-path (str url trim-path)
        site-map-data-val (format (:site-map-form env) mod-file-path)]
    (swap! site-map-data conj site-map-data-val)))


;; sitemap generation
(defn site-map-generation [site-map-mod-val]
  (let [site-map-val (slurp (:site-map-file-path env))
        search-site-map (format (:site-map-search env) (:site-map-url env))
        mod-site-map-body (str/replace site-map-val search-site-map (str search-site-map site-map-mod-val))]

    (io/delete-file (:site-map-file-path env))
    (spit (:site-map-file-path env) mod-site-map-body)))


;; html file generation
(defn html-insertion [file-path]
  (let [html-val (slurp file-path)
        mod-html-body (str/replace html-val data-search data-to-be-replaced)
        mod-html-include-css (str/replace mod-html-body data-css-search data-replaced-css)]
    (io/delete-file file-path)
    (spit file-path mod-html-include-css)))


(defn directory-parsing [directory-lists]
  (loop [lists directory-lists]
    (let [single-list (first lists)]
      (if-not (seq lists)
        ()
        (do
          ;(prn single-list)
          (site-map-val-generation single-list)
          (recur (rest lists)))))))


(defn html-parsing [html-lists]
  (loop [lists html-lists]
    (let [single-list (first lists)]
      (if-not (seq lists)
        ()
        (do
          ;(prn single-list)
          (html-insertion single-list)
          (recur (rest lists)))))))

(defn folder-traversing []
  (let [file-path directory-path
        folders folder-name]
    (loop [folder-names folders]
      (let [single-folder (first folder-names)
            file-path (str file-path single-folder)
            file-seqs (file-seq (io/file file-path))
            file-directories (mapv str (filter #(.isDirectory %) file-seqs))
            htmls-by-folder (mapv str (filter #(.isFile %) file-seqs))]


        (if-not (seq folder-names)
          (do
            (site-map-generation (apply str @site-map-data))
            (reset! site-map-data []))
          (do
            (directory-parsing file-directories)
            (html-parsing htmls-by-folder)
            (recur (rest folder-names))))))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (folder-traversing))
