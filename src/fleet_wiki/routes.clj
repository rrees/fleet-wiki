(ns fleet-wiki.routes
	(:use compojure.core compojure.route fleet-wiki.handlers ))	
	
	(defroutes app
		(GET "/" request
			(show-front-page))
		(GET "/wiki/:topic" [topic] (show-topic topic))
		(POST "/wiki/:topic" [topic content] (update-topic topic content))
		(GET "/wiki/:topic/edit" [topic] (edit-topic topic))
		(compojure.route/files "/css" {:root "css"}))
	