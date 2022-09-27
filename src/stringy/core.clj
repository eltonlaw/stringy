(ns stringy.core
  (:require [clojure.template :as template]
            [stringy.compare :as compare]))

(template/do-template [x y] (def x y)
  hamming-distance compare/hamming-distance)
