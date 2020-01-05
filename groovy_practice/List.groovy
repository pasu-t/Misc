def list1 = ['ele1', 'ele2', 'ele3']
println list1[1]
println list1.get(2)

def list2 = [1,2,3, ['A', 'B', 'Groovy'], 4]
println list2[3][2]
println list2.get(3).get(2)
println list2[0..2]
println list2[4..2]
println list2[3].contains("Groovy")
println list2[3].size()

list2.add(10)
println list2

list2<<20
println list2

list2.add(2, 22)
println list2

list2 = list2 + [30,40]
println list2

list2 = list2.plus([50])
println list2

list2 = list2.minus([50])
println list2

list2.pop()
println list2


list2.removeLast()
println list2

println list2.intersect([1,2,3])

list2 = list2.reverse()
println list2

list2 = list2.sort()
println list2

list2.clear()
println list2.isEmpty()
