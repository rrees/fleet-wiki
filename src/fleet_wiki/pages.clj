(ns fleet-wiki.pages
	(:use fleetdb.client ))

(def client (connect {:host "localhost" :port 3400}))

(defn page-exists
	[topic]
	 (> (client ["count" "wiki" {"where" ["=" "id" topic]}]) 0))

(defn read-page
	[topic]
	(if (page-exists topic)
		(first(client ["select" "wiki" {"where" ["=" "id" topic]}]))))

(defn create-new-page
	[topic content]
	(client ["checked-write"
		["select" "wiki" {"where" ["=" "id" topic], "only" "id"}]
		[]
		["insert" "wiki" {:id topic :content content}]]))

(defn save-page
	[topic content]
	(let [insert-result (create-new-page topic content)]
	(println insert-result)
	(if (not (first insert-result))
	(client ["update" "wiki" {"content" content} {"where" ["=" "id" topic]}]))
	(read-page topic)))

