# rx-cljs

A ClojureScript wrapper for [Reactive Extensions (Rx) for Javascript](https://github.com/Reactive-Extensions/RxJS).


## Motivation

The aim of this wrapper is to let developers write this:

```clojure
(defn project-range [n]
    (return-value (range n)))
    
(-> (from-array [4 6 8])
    (select-many project-range)
    (subscribe #(.log js/console (clj->js %))))
```

Instead of:

```clojure
(defn project-range [n]  (.returnValue js/Rx.Observable (range n)))(-> (.fromArray js/Rx.Observable                (clj->js [1 2 3]))    (.selectMany project-range)    (.subscribe #(.log js/console (clj->js %))))
```

## Usage

Be warned: it's very early days and this wrapper is still very much incomplete.

For the brave amongst you, keep reading.

## What's in the package

### Creating observables


- return-value
- from-array

### Working with Observables

- take
- map
- reduce
- select-many
- subscribe

## TODO

Everything else.

## Contributing

Bug reports and pull requests are much welcome. If submitting code, please add a test to it.

## License

Copyright (C) 2012 [Leonardo Borges](http://www.leonardoborges.com)

Distributed under the Eclipse Public License, the same as Clojure.