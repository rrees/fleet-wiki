(ns fleet-wiki.server
	(:use :reload-all fleet-wiki.routes ring.adapter.jetty))

(run-jetty fleet-wiki.routes/app {:port 9999})