(ns fleet-wiki.handlers
	(:use fleet-wiki.templates)
	(:use [fleet-wiki.markdown :only (to-html)])
	(:require fleet-wiki.pages))

(defn show-topic
	[topic]
	(topic-page topic (to-html (get (fleet-wiki.pages/read-page topic) "content"))))

(defn update-topic
	[topic]
	(str "Update " topic))

(defn show-front-page
	[]
	(index-page))

(defn edit-topic
	[topic]
	(edit-page))
