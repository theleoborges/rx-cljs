(ns rx-cljs.observable
  (:refer-clojure :exclude [map reduce]))

(defn return-value [v]
  (.returnValue js/Rx.Observable v))

(defn from-array [coll]
  (.fromArray js/Rx.Observable (clj->js coll)))

(defn subscribe [observable f]
  (.subscribe observable f))

(defn map [observable f]
  (.map observable f))

(defn reduce [observable f]
  (.reduce observable f))

(defn select-many [observable sel]
  (.selectMany observable sel))