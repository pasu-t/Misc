def emp = [
    'name' : 'pasupathi',
    'age' : 28
    ]
println emp
println emp.name
println emp['name']
println emp.get('age')
println emp.getAt('age')
println emp.size()

emp.put('city', 'hyderabad')
println emp

println emp.containsKey('city')
println emp.containsValue('Paris')

println emp.getClass()

def emp2 = emp.clone()
println emp2

emp.each { key,value -> 
          println "$key : $value"
}

emp.eachWithIndex { key, value, i -> 
          println "$i | $key : $value"
}

emp.eachWithIndex { entry, i ->
         println "$i | $entry.key : $entry.value"
}

def map1 = ['a' : 1, 'b' : 2]
def entries = map1.entrySet()
entries.each { entry ->
         assert entry.key in ['a','b']
         assert entry.value in [1,2,3]
//         assert entry.value in [1,3]
}
emp.clear()
println emp