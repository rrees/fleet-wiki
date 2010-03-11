(ns fleet-wiki.server
	(:use :reload-all compojure fleet-wiki.handlers ))

	

(defroutes fleet-wiki
	(GET "/"
		(show-front-page))
	(GET "/wiki/:topic"
		(show-topic (:route-params :topic)))
	(POST "/wiki/:topic"
		(update-topic :topic)))

(run-server {:port 9999}
	"/*" (servlet fleet-wiki))