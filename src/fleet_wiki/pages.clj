(ns fleet-wiki.pages
	(:use fleetdb.client ))

(def client (connect {:host "localhost" :port 3400}))

(defn page-exists
	[topic]
	 (> (client ["count" "wiki" {"where" ["=" "id" topic]}]) 0))
	
(defn save-page
	[topic content]
	(dosync
		( if (page-exists)
			(client ["update" "wiki" {"content" content} {"where" ["=" "id" topic]}])
			(client ["insert" "wiki" {"id" topic "content" content}]))))

(defn read-page
	[topic]
	(if (page-exists topic)
		(client ["select" "wiki" {"where" ["=" "id" topic]}])))