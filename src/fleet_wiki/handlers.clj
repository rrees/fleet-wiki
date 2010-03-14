(ns fleet-wiki.handlers
	(:use fleet-wiki.templates)
	(:use [fleet-wiki.markdown :only (to-html)]))

(defn show-topic
	[topic]
	(topic-page topic (to-html(str "_" topic "_"))))

(defn update-topic
	[topic]
	(str "Update " topic))

(defn show-front-page
	[]
	(index-page))

(defn edit-topic
	[topic]
	(edit-page))
