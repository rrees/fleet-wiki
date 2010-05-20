(ns fleet-wiki.templates
	(:use hiccup.core hiccup.form-helpers)
	(:use [clojure.contrib.str-utils2 :only (capitalize)]))

(defn template
	[content]
	(html [:html
		[:head [:title (:title content)] [:link {:type "text/css" :rel "StyleSheet" :href "/css/std.css"}]]
		[:body (:content content)]]))

(defn index-page
	[]
	(template {:title "Hello"
		:content (html [:h1 "Fleet Wiki"]
				[:p "A wiki backed by FleetDb"])}))

(defn topic-page
	[topic content]
	(let [display-topic (capitalize topic)]
	(template
		{:title display-topic
		:content (html [:h1 display-topic]
				[:div content]
					[:p [:a {:href (str "/wiki/" topic "/edit")} "Edit this page"]])})))

(defn edit-template
	[topic form]
	(template
		{:title (str "Edit: " topic)
		:content (html
			[:h1 "Edit " topic]
			[:div [:p "Edit the content "] form])}))

(defn edit-page
	([topic]
	(edit-page topic ""))
	([topic content] (edit-template topic (form-to [:post (str "/wiki/" topic)]
		[:div {:class "content"} (text-area {:class "content-editor"} "content" content)]
		[:div {:class "submit"} (submit-button "Contribute knowledge")]))))
