(ns fleet-wiki.handlers
	(:use fleet-wiki.templates)
	(:use [fleet-wiki.markdown :only (to-html)])
	(:require fleet-wiki.pages)
	(:use [ring.util.response :only (redirect)]))

(defn show-topic
	[topic]
	(let [content (get (fleet-wiki.pages/read-page topic) "content")]
	(if content (topic-page topic (to-html content)) (redirect (str "/wiki/" topic "/edit")))))

(defn update-topic
	[topic submitted-content]
	(fleet-wiki.pages/save-page topic submitted-content)
	(redirect (str "/wiki/" topic)))

(defn show-front-page
	[]
	(index-page))

(defn edit-topic
	[topic]
	(let [content (get (fleet-wiki.pages/read-page topic) "content")]
	(if content (edit-page topic content) (edit-page topic))))
