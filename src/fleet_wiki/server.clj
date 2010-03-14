(ns fleet-wiki.server
	(:use :reload-all compojure fleet-wiki.handlers ))

	

(defroutes fleet-wiki
	(GET "/"
		(show-front-page))
	(GET "/wiki/:topic"
		(let [topic (-> request :route-params :topic)]
			(show-topic topic)))
	(POST "/wiki/:topic"
		(update-topic :topic))
	(GET "/wiki/:topic/edit"
		(edit-topic (-> request :route-params :topic))))

(run-server {:port 9999}
	"/*" (servlet fleet-wiki))