(defproject com.leonardoborges/rx-cljs "0.0.1-SNAPSHOT"
  :description "A ClojureScript wrapper for RxJS"
  :url "http://github.com/leonardoborges/rx-cljs"
  :source-paths ["src-clj"]
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :plugins [[lein-cljsbuild "0.3.2"]]
  :profiles {:dev
             {:dependencies [[com.cemerick/clojurescript.test "0.0.4"]
                             [org.bodil/error "0.1.2"]]}}
  :hooks [leiningen.cljsbuild]
  :cljsbuild {
              :builds {:test {:source-paths ["src-cljs" "test-cljs"]
                              :compiler {:output-to "resources/public/js/test.js"
                                         :optimizations :whitespace
                                         :pretty-print true}}}
              :test-commands {"unit-tests" ["runners/phantomjs.js"
                                            "resources/private/js/rx.min.js"
                                            "resources/private/js/rx.modern.min.js"
                                            "resources/private/js/rx.binding.min.js"
                                            "resources/private/js/rx.time.min.js"
                                            "resources/private/js/rx.aggregates.min.js"
                                            "resources/private/js/rx.coincidence.min.js"
                                            "resources/public/js/test.js"]}})
