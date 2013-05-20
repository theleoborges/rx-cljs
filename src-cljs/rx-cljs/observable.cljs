(ns rx-cljs.observable
  (:refer-clojure :exclude [map reduce]))

(defprotocol IObservable
  (subscribe [_ f])
  (map       [_ f])
  (reduce    [_ f])
  (select-many [_ sel]))

(defrecord Observable [observable]
  IObservable
  (subscribe [_ f]
    (.subscribe observable f))
  
  (map [_ f]
    (Observable. (.map observable f)))
  
  (reduce [_ f]
    (Observable. (.reduce observable f)))
  
  (select-many [_ sel]
    (Observable. (.selectMany observable
                              (fn [& args]
                                (:observable (apply sel args)))))))

(defn return-value [v]
  (Observable. (.returnValue js/Rx.Observable v)))

(defn from-array [coll]
  (Observable. (.fromArray js/Rx.Observable (clj->js coll))))