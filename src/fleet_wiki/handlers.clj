(ns fleet-wiki.handlers
	(:use fleet-wiki.templates)
	(:use [fleet-wiki.markdown :only (to-html)])
	(:require fleet-wiki.pages))

(defn show-topic
	[topic]
	(topic-page topic (to-html (get (fleet-wiki.pages/read-page topic) "content"))))

(defn update-topic
	[topic submitted-content]
	(str "Update " topic submitted-content))

(defn show-front-page
	[]
	(index-page))

(defn edit-topic
	[topic]
	(let [content (get (fleet-wiki.pages/read-page topic) "content")]
	(if content (edit-page topic content) (edit-page topic))))
