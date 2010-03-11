(ns fleet-wiki.handlers
	(:use fleet-wiki.templates))

(defn show-topic
	[topic]
	(topic-page topic topic))

(defn update-topic
	[topic]
	(str "Update " topic))

(defn show-front-page
	[]
	(index-page))
