(ns user
  (:require [figwheel.main.api :as fig]
            [cljs.repl]
            [clojure.core.server :as server]))


(defn io-repl
  [& {:keys [repl-env]}]
  (cljs.repl/repl repl-env))


(defn start-prepl
  "This cannot be used by Cursive - yet. When it does, we can let nREPL go"
  [repl-env port]
  (println "Starting a prepl on port" port)
  (server/start-server {:accept  'user/io-repl
                        :address "127.0.0.1"
                        :port    port
                        :name    "test-repl"
                        :args    [:repl-env repl-env]}))


(defn run-cljs-repl []
  (let [build-id "dev"]
   (try
     (figwheel.main.api/start {:id      build-id
                               :options {:main 'repl.chlorine-socket-figwheel}
                               :config  {:watch-dirs ["src"]
                                         :mode       :serve}})

     (start-prepl (figwheel.main.api/repl-env build-id) 9002)

     (figwheel.main.api/cljs-repl build-id)

     (catch RuntimeException _e
       (println "The build is already running, connection to the REPL only")
       (figwheel.main.api/cljs-repl build-id)))))
