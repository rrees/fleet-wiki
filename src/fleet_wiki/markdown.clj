(ns fleet-wiki.markdown
	(:import (javax.script ScriptEngineManager ScriptEngine))
	(:import (java.io InputStreamReader File FileReader)))
	
(defn load-showdown
	[]
	(let [showdown-file (new File "src/scripts/showdown.js")]
	 (new FileReader showdown-file)))

(defn to-html
	[markdown]
	(let
		[sem (new ScriptEngineManager)
		javascript (. sem getEngineByExtension "js")
		showdown (load-showdown)
		]
		(. javascript eval "function makeHtml(input) { return input; }")
		(. javascript eval showdown)
		(println markdown)
		(println (str "Output: " (. javascript invokeFunction "makeHtml" (to-array [markdown]))))))

(to-html "*Hello* _World_")