(ns rx-cljs.observable
  (:refer-clojure :exclude [map reduce take]))

(defn return-value [v]
  (.returnValue js/Rx.Observable v))

(defn from-array [coll]
  (.fromArray js/Rx.Observable (clj->js coll)))

(defn interval [ms]
  (.interval js/Rx.Observable ms))

(defn start-with [observable n]
  (.startWith observable n))

(defn take [observable n]
  (.take observable n))

(defn map [observable f]
  (.map observable f))

(defn reduce [observable f]
  (.reduce observable f))

(defn select-many [observable sel]
  (.selectMany observable sel))

(defn subscribe [observable f]
  (.subscribe observable f))

(defn dispose [token]
  (.dispose token))