
home_dir = ENV['HOME']
code_dirs = ["src"]

task :default => [:run]

puts home_dir
compojure_home= File.join(home_dir, 'code', 'java', 'clojure', 'compojure')
puts "#{compojure_home}"

jars = [] << File.join(compojure_home, 'compojure.jar')

jars << Dir.new("#{compojure_home}/deps").entries.select{|f| f =~ /.*.jar/}.map {|jar| File.join(compojure_home, 'deps', jar)}

task :run do
  run = "java -cp src:#{jars.join(':')} clojure.main src/fleet_wiki/server.clj"
  puts run
  system(run)
end

