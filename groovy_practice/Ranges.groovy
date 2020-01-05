//ranges used to create list of sequential values
def range1 = 1..10
println range1
println range1.size()
println range1.getFrom()
println range1.getTo()

assert range1.from == 1
assert range1.to == 10
println range1.get(3)
println range1[3]

println range1.contains(6)
println range1.isReverse()

def range2 = range1.subList(3,7)
println range2.getFrom()
println range2.getTo()

//iterate on a range
for(i in 20..25){
    println i
}
(30..35).each { i ->
     println "Value = $i"
}
range1.each { i ->
     println "Value = $i"
}

println range1 instanceof java.util.List