(ns cljds.ch1.my
  (:require [cljds.ch1.data :refer :all]
            [cljds.ch1.stats :refer :all]
            [clojure.string :as str]
            [incanter.charts :as c]
            [incanter.core :as i]
            [incanter.distributions :as d]
            [incanter.stats :as s]
            [incanter.svg :as svg]
            [me.raynes.fs :as fs]))

(i/view (c/histogram (s/sample-normal 1000)))

;; the reason sin is undef.
(def my-plot (c/function-plot #(+ (i/sin %) (i/cos (* 2 %))) 10 -10))
(i/view my-plot)

(defn f [x]
 (+ (* x x) (* -3 x) 5))

(let [f #(+ (* % %) (- 2 %) 3)]
  (i/view (c/function-plot f -4 4)))

(let [f (partial * 2)]
  (i/view (c/function-plot f -4 4)))