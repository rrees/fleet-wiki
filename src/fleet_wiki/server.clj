(ns fleet-wiki.server
	(:use :reload-all compojure.core fleet-wiki.handlers ring.adapter.jetty ))

(defroutes fleet-wiki
	(GET "/" request
		(show-front-page))
	(GET "/wiki/:topic" [topic] (show-topic topic))
	(POST "/wiki/:topic" [topic content] (update-topic topic content))
	(GET "/wiki/:topic/edit" [topic] (edit-topic topic)))

(run-jetty fleet-wiki {:port 9999})