(ns fleet-wiki.markdown
	(:import (javax.script ScriptEngineManager ScriptEngine)))
	
(defn to-html
	[markdown]
	(let
		[sem (new ScriptEngineManager)
		javascript (. sem getEngineByExtension "js")
		]
		(. javascript eval "function makeHtml(input) { return input; }")
		(println markdown)
		(println (str "Output: " (. javascript invokeFunction "makeHtml" (to-array [markdown]))))))

(to-html "*Hello* _World_")