(ns fleet-wiki.markdown
	(:import (javax.script ScriptEngineManager ScriptEngine))
	(:import (java.io InputStreamReader File FileReader)))
	
(defn load-showdown
	[]
	(let [showdown-file (new File "src/scripts/showdown.js")]
	 (new FileReader showdown-file)))

(def javascript
(let
	[sem (new ScriptEngineManager)
	javascript (. sem getEngineByExtension "js")
	showdown (load-showdown)
	showdown-call "function toHtml(input) { return new Showdown.converter().makeHtml(input); }"
	]
	(. javascript eval showdown-call)
	(. javascript eval showdown)
	javascript))

(defn to-html
	[markdown]
		(. javascript invokeFunction "toHtml" (to-array [markdown])))

;;(println (to-html "*Hello* _World_"))