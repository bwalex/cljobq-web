(defproject cljobq-web "0.1.3"
  :description "A web frontend for cljobq"
  :url "https://github.com/bwalex/cljobq-web"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[cljobq "0.1.3"]
                 [clojure.java-time "0.3.2"]
                 [compojure "1.6.1"]
                 [hiccup "1.0.5"]
                 [org.clojure/tools.logging "0.4.0"]
                 [ring/ring-codec "1.1.1"]
                 [ring/ring-defaults "0.3.2"]]

  :plugins [[lein-eftest "0.5.1"]
            [jonase/eastwood "0.2.6-beta2"]
            [lein-codox "0.10.4"]
            [lein-kibit "0.1.6"]]
  :codox {:metadata {:doc/format :markdown}}
  :profiles
  {:dev {:dependencies [[org.clojure/clojure "1.9.0"]
                        [org.slf4j/slf4j-log4j12 "1.7.9"]
                        [org.postgresql/postgresql "42.1.4"]
                        [ring-server "0.5.0"]]}})
