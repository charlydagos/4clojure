; Write a function which takes a sequence consisting of items with different
; types and splits them up into a set of homogeneous sub-sequences.
; The internal order of each sub-sequence should be maintained, but the
; sub-sequences themselves can be returned in any order
; (this is why 'set' is used in the test cases).
;
; http://www.4clojure.com/problem/50

(fn split-by-type [xs]
    (set (map #(.val %) (group-by type xs))))

(= (set (split-by-type [1 :a 2 :b 3 :c])) #{[1 2 3]  [:a :b :c]})
(= (set (split-by-type [:a  "foo"  "bar" :b])) #{[:a :b]  ["foo"  "bar"]})
(= (set (split-by-type [[1 2] :a  [3 4] 5 6 :b])) #{[[1 2]  [3 4]]  [:a :b]  [5 6]})

; An alternative solution would be
;
; (fn split-by-type [xs]
;     (set (map second (group-by type xs))))
