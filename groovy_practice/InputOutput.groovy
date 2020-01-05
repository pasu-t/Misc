print "Enter your name : "
def name = System.console().readLine()
print "Enter your age: "
def age = System.console().readLine().toInteger()
println "Hello $name"
println "age is $age years"

print "Enter 1st number: "
def num1 = System.console().readLine().toInteger()
print "Enter 2nd number: "
def num2 = System.console().readLine().toInteger()
println "$num1 + $num2 = " + (num1+num2)

printf "My name is %s \n", name
printf "%s | %s | %d | %.2f \n", ['pasupathi', 'groovy', 10, 20.201]
printf "%-10s | %10s | %d | %.2f \n", ['pasupathi', 'groovy', 10, 20.201]


