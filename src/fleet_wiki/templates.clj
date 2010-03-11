(ns fleet-wiki.templates
	(:use [compojure :only (html)]))

(defn template
	[content]
	(html [:html
		[:head [:title (:title content)]]
		[:body (:content content)]]))

(defn index-page
	[]
	(template {:title "Hello"
		:content (html [:h1 "Fleet Wiki"]
				[:p "A wiki backed by FleetDb"])}))
