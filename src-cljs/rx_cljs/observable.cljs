(ns rx-cljs.observable
  (:refer-clojure :exclude [map reduce take]))


;; creating
(defn create [f]
  (.create js/Rx.Observable f))

(defn return-value [v]
  (.returnValue js/Rx.Observable v))

(defn from-array [coll]
  (.fromArray js/Rx.Observable (clj->js coll)))

(defn interval [ms]
  (.interval js/Rx.Observable ms))


;; observables
(defn start-with [observable n]
  (.startWith observable n))

(defn take [observable n]
  (.take observable n))

(defn map [observable f]
  (.map observable f))

(defn reduce [observable f]
  (.reduce observable f))

(defn skip [observable n]
  (.skip observable n))

(defn zip [observable other f]
  (.zip observable other f))

(defn select-many [observable sel]
  (.selectMany observable sel))

(defn subscribe [observable f]
  (.subscribe observable f))

(defn buffer-with-count [observable n]
  (.bufferWithCount observable n))

;; connectables
(defn publish [observable]
  (.publish observable))

(defn connect [observable]
  (.connect observable))

(defn ref-count [observable]
  (.refCount observable))

;; subscriptions
(defn dispose [token]
  (.dispose token))

;; observers
(defn on-next [observer v]
  (.onNext observer v))

(defn on-completed [observer]
  (.onCompleted observer))