(defproject rx-cljs "0.0.1"
  :description "A ClojureScript wrapper for RxJS"
  :source-paths ["src-clj"]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.0.4"]
                 [hiccup "1.0.0"]]
  :plugins [[lein-cljsbuild "0.3.2"]
            [lein-ring "0.7.0"]]
  :profiles {:dev
             {:dependencies [[com.cemerick/clojurescript.test "0.0.4"]]}}
  :source-paths ["src-cljs"]
  :cljsbuild {
              :builds [{:source-paths ["src-cljs" "test-cljs"]
                        :compiler {:output-to "resources/public/js/main.js"
                                   :optimizations :whitespace
                                   :pretty-print true}}]
              :test-commands {"unit-tests" ["runners/phantomjs.js"
                                            "resources/private/js/rx.min.js"
                                            "resources/private/js/rx.modern.min.js"
                                            "resources/private/js/rx.binding.min.js"
                                            "resources/private/js/rx.time.min.js"
                                            "resources/private/js/rx.aggregates.min.js"
                                            "resources/private/js/rx.coincidence.min.js"
                                            "resources/public/js/main.js"]}})
