(defproject pumkin "0.1.0-SNAPSHOT"
  :description "Internet File Store"

  :license {:name "Apache License, Version 2.0"
	    :url "http://www.apache.org/licenses/LICENSE-2.0.html"
	     ;; :repo means it is OK for public repositories to host this project's
	    :distribution :repo
	    }

  :url "http://pumkin.org"

  ;; Minimum lein version. 2.0 has nice REPL integration.
  :min-lein-version "2.0.0"

  ;; Plugins are code that runs in Leiningen itself and usually
  ;; provide new tasks or hooks.
  :plugins [[lein-pprint "1.1.1"]]

  :dependencies [[org.clojure/clojure "1.5.0"]]

  :repl-options {;; Specify the string to print when prompting for input.
		 :prompt (fn [ns] "(pumkin) ")
		 ;; This expression will run when first opening a REPL, in the
		 ;; namespace from :init-ns or :main if specified.
		 :init (println "\n  -- Clojure REPL for pumkin hackers --\n")
		 }

  )
