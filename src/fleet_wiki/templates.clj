(ns fleet-wiki.templates
	(:use hiccup.core hiccup.form-helpers))

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

(defn topic-page
	[topic content]
	(template
		{:title topic
		:content (html [:h1 topic] [:div content] [:p [:a {:href (str "/wiki/" topic "/edit")} "Edit this page"]])}))

(defn edit-template
	[topic form]
	(template
		{:title (str "Edit: " topic)
		:content (html
			[:h1 "Edit " topic]
			[:div [:p "Edit the content "] form])}))

(defn edit-page
	([topic]
	(edit-template topic (form-to [:post (str "/wiki/" topic)]
					(text-area "content")
					(submit-button "Contribute knowledge"))))
	([topic content] (edit-template topic (form-to [:post (str "/wiki/" topic)] (text-area "content" content) (submit-button "Contribute knowledge")))))
