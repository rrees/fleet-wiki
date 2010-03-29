(ns fleet-wiki.handlers
	(:use fleet-wiki.templates)
	(:use [fleet-wiki.markdown :only (to-html)])
	(:require fleet-wiki.pages)
	(:use [compojure.http.helpers :only (redirect-to)]))

(defn show-topic
	[topic]
	(let [content (get (fleet-wiki.pages/read-page topic) "content")]
	(if content (topic-page topic (to-html content)) (redirect-to (str "/wiki/" topic "/edit")))))

(defn update-topic
	[topic submitted-content]
	(fleet-wiki.pages/save-page topic submitted-content)
	(redirect-to (str "/wiki/" topic)))

(defn show-front-page
	[]
	(index-page))

(defn edit-topic
	[topic]
	(let [content (get (fleet-wiki.pages/read-page topic) "content")]
	(if content (edit-page topic content) (edit-page topic))))
