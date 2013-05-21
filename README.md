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

**Be warned**: it's very early days and this wrapper is still very much incomplete.

For the brave amongst you, add this to your `project.clj`:

```clojure
[com.leonardoborges/rx-cljs "0.0.1-SNAPSHOT"]
```

Or if you're using maven:

```xml
<dependency>
  <groupId>com.leonardoborges</groupId>
  <artifactId>rx-cljs</artifactId>
  <version>0.0.1-SNAPSHOT</version>
</dependency>
```

## What's in the package

### Creating observables

- create
- return-value
- from-array
- interval

### Working with Observables

- take
- map
- reduce
- skip
- zip
- select-many
- subscribe
- start-with
- buffer-with-count

### Working with Connectable observables

- publish
- connect
- ref-count

### Working with Observers

- on-next
- on-completed

### Working with Subscriptions

- dispose

## Running the tests

From the project root:

```bash
$ lein cljsbuild test
```

## TODO

Everything else. (but mainly other arities of functions already in here.)

## Contributing

Bug reports and pull requests are much welcome. If submitting code, please add a test to it.

## License

Copyright (C) 2012 [Leonardo Borges](http://www.leonardoborges.com)

Distributed under the Eclipse Public License, the same as Clojure.