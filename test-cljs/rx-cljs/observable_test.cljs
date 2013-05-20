(ns rx-cljs.observable-test
  (:require-macros [cemerick.cljs.test :refer (is deftest with-test run-tests testing)])
  (:require [cemerick.cljs.test :as t]
            [rx-cljs.observable :as o]))

(deftest rx-integration
  (testing "creating observables from single values"
    (-> (o/return-value 50)
        (o/subscribe (fn [v]
                     (is (= 50 v)))))

    (let [result (atom [])]
      (-> (o/from-array [4 6 8])
          (o/subscribe (fn [v]
                       (swap! result #(conj % v)))))
      (is (= [4 6 8] @result))))

  (testing "taking"
    (let [result (atom [])]
      (-> (o/from-array [4 6 8])
          (o/take 2)
          (o/subscribe (fn [v]
                         (swap! result #(conj % v)))))
      (is (= [4 6] @result))))
  
  (testing "mapping"
    (-> (o/return-value 50)
        (o/map (fn [v] (* 2 v)))
        (o/subscribe (fn [v]
                     (is (= 100 v))))))

  (testing "reducing"
    (-> (o/from-array [4 6 8])
        (o/map (fn [v] (* 2 v)))
        (o/reduce +)
        (o/subscribe (fn [v]
                     (is (= 36 v))))))
  
  (testing "composing"
    (let [project-range (fn [n]
                          (o/return-value (range n)))
          result (atom [])]

      (-> (o/from-array [4 6 8])
          (o/select-many project-range)
          (o/subscribe (fn [v]
                       (swap! result #(conj % v)))))
      (is (= ['(0 1 2 3) '(0 1 2 3 4 5) '(0 1 2 3 4 5 6 7)]
             @result)))))