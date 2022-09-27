(ns stringy.compare)

(defn hamming-distance
  "Number of positions at which corresponding symbols are different"
  [s1 s2]
  (assert (= (count s1) (count s2))
          "Hamming distance only applies to strings of equal length. Try levenshtein-distance instead?")
  (apply + (pmap #(if (= %1 %2) 0 1) s1 s2)))

(defn levenshtein-distance
  "Minimum edit (replace/insert/delete) distance

  The grid (of edit distances) is aligned as s2
  on the top and s1 on the left"
  [s1 s2]
  (->> (reduce
         (fn [matrix i]
           (conj matrix
                 (reduce
                   (fn [new-row [j [top-left top]]]
                     (conj new-row
                           (cond-> (min (last new-row)
                                        top-left
                                        top)
                             (not= (nth s1 i) (nth s2 j)) inc)))
                   [(inc i)]
                   (->> (last matrix)
                        (partition 2 1)
                        (map-indexed vector)))))
         [(range (inc (count s2)))]
         (range (count s1)))
       last
       last))
