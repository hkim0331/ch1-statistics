(ns cljds.ch1.patch
  (:require [incanter.excel]))

;; thanks
;; https://github.com/incanter/incanter/issues/393
;;

(in-ns 'incanter.excel)

(defn- read-sheet [rows-it header-keywords]
  (let [colnames  (read-line-values (first rows-it))
        rows (->> (rest rows-it)
                  (map read-line-values)
                  (filter (complement empty?))
                  (drop-last 1))] ; NOTE: This line was my change, just to test my theory
    (dataset
      (if header-keywords
        (map keyword colnames)
        colnames)
      rows)))
