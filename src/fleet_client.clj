(use 'fleetdb.client)

(def client (connect {:host "127.0.0.1" :port 3400}))

(if (nil? (client ["select" "wiki" {"where" ["=" "id" "pixies"]}]))
	(client ["insert" "wiki" {"id" "pixies" "content" "*Pixies!*"}])
	)

(println (client ["select" "wiki" {"where" ["=" "id" "pixies"]}]))