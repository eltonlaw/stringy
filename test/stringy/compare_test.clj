(ns stringy.compare-test
  (:require [clojure.test :refer [are deftest is]]
            [stringy.compare :as compare]))

(deftest hamming-distance-test
  (is (thrown? AssertionError
               (compare/hamming-distance "a" "ab")))
  (are [distance s1 s2]
       (= distance
          (compare/hamming-distance s1 s2))
       1 "abcc" "abcd"
       0 "abcd" "abcd"
       4 "lawn" "flaw"))
