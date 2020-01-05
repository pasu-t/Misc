def name = "pasupathi"
println "My name is " + name
println "My name is ".concat(name)
println "My name is $name"
println 'My name is $name'
println name.length()
println name.indexOf('t')
println name[0..3]
println name[6..3]
println name[0,4,6]
println name.substring(2)
println name.subSequence(1,4)

def str = "This is groovy course"
println str.split(" ")
println str-("groovy")
println str.replace("course", "session")
println str.toUpperCase()
println str.toList()
println "Abc".equals("Abc")
println "Abc".equalsIgnoreCase("Abc")

def s1 = /a green sky/
def s2 = $/a blue tree/$
def s3 = /a green sky $name/
def s4 = $/a blue tree
$name/$
println s1
println s2
println s3
println s4