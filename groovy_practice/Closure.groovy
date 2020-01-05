def myClosure1 = {name -> println "Hello $name" }
myClosure1.call('Pasupathi')

//we can pass closures to a method
def myMethod(clos) {
     clos.call("Groovy")
}
myMethod(myClosure1)

def myClosure2 = {
    a,b,c ->
    return(a+b+c)
}

def res = myClosure2(10,20,30)
println res 

def myList1 = ["ele1", "ele2", "ele3"]
println myList1.each { it }

def myMap1 = [
 'subject' : 'groovy',
 'topic'   : 'closure'
]
println myMap1.each { it }

def myList2 = [1,2,3,4,5,6,7]
println myList2.find { item -> item == 6 }
println myList2.find { item -> item == 9 }
println myList2.findAll { item -> item > 4 }
println myList2.any { item -> item > 4 }
println myList2.every { item -> item > 4 }
println myList2.collect { item -> item*2 }
