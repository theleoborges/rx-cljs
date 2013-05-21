#!/usr/bin/env phantomjs

var page = require("webpage").create(),
    sys = require("system");

page.onConsoleMessage = function(msg) {
  console.log(msg);
};

page.onCallback = function(msg) {
  if (msg.cmd === "write") {
    sys.stdout.write(msg.data);
    sys.stdout.flush();
  } else if (msg.cmd === "quit") {
    phantom.exit(msg.data);
  }
};

page.onLoadFinished = function() {

  var scripts = sys.args.slice(1);
  scripts.forEach(function(script){
    console.log("Injecting " + script);
    page.injectJs(script);
  });
  page.evaluate(function() {
    error.environment.in_repl = false;
    cljs.core.string_print = function(s) {
      window.callPhantom({cmd: "write", data: s});
    };
    error.test.run_tests();
  });
};

page.open("about:blank");
