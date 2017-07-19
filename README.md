# re-mdl

Yet another library of reusable UI components for Reagent

[![Clojars Project](http://clojars.org/com.yetanalytics/re-mdl/latest-version.svg)](http://clojars.org/com.yetanalytics/re-mdl)
[![Build Status](https://travis-ci.org/yetanalytics/re-mdl.svg?branch=master)](https://travis-ci.org/yetanalytics/re-mdl)

## Overview

Re-mdl gives you reusable components for use with Google's [Material Design Lite](http://www.getmdl.io/) in the style of [re-com](https://github.com/Day8/re-com).

## Dev Setup

To get an interactive development environment run:

    lein figwheel

and open your browser at [localhost:3449](http://localhost:3449/).
This will auto compile and send all changes to the browser without the
need to reload. After the compilation process is complete, you will
get a Browser Connected REPL. An easy way to try it is:

    (js/alert "Am I connected?")

and you should see an alert in the browser window.

To clean all compiled files:

    lein clean

To create a production build run:

    lein cljsbuild once min

And open your browser in `resources/public/index.html`. You will not
get live reloading, nor a REPL.

## Tests

Using [phantomjs](http://phantomjs.org/):

    lein doo phantom test once

Thanks, [gadfly361](https://github.com/gadfly361)!

## License

Copyright © 2017 Yet Analytics Inc

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
