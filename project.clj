(defproject html-parser "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [yogthos/config "1.1.7"]
                 [org.clojure/tools.cli "0.4.2"]]

  ;; configuration will be read from the dev-config.edn file
  :jvm-opts ["-Dconfig=dev-config.edn"]

  :main ^:skip-aot html-parser.core
  :jar-name "html-parser-library.jar"
  :uberjar-name "html-parser.jar"
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
