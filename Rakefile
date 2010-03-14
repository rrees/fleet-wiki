
home_dir = ENV['HOME']
code_dirs = ["src"]

task :default => [:run]

jars = [] << Dir.new("lib").entries.select{|f| f =~ /.*.jar/}.map {|jar| File.join('lib', jar)}

task :run do
  run = "java -cp src:#{jars.join(':')} clojure.main src/fleet_wiki/server.clj"
  puts run
  system(run)
end

task :shell do
	system("java -cp src:#{jars.join(':')} clojure.main")
end

task :fleet_client do
	fleet_client = "java -cp src:lib/fleetdb-client-standalone.jar:lib/clojure.jar clojure.main"
	system(fleet_client)
end