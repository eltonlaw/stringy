(ns stringy.compare)

(defn hamming-distance
  "Number of positions at which corresponding symbols are different"
  [s1 s2]
  (assert (= (count s1) (count s2))
          "Hamming distance only applies to strings of equal length. Try levenshtein-distance instead?")
  (apply + (pmap #(if (= %1 %2) 0 1) s1 s2)))
