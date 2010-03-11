(ns fleet-wiki.handlers
	(:use fleet-wiki.templates))

(defn show-topic
	[topic]
	(str topic))

(defn update-topic
	[topic]
	(str "Update " topic))

(defn show-front-page
	[]
	(index-page))
