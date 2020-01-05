for(def i = 100; i<105; i++){ println i }
//for in
for(a in 10..15){ println a }

for(i in ['a','b','c','d']){ println i }
//iterate over a map
def map = ["name" : "groovy", "subject" : "automation" ]
for(e in map) { 
//    println e
    print e.key + ":"
    println e.value
}

20.upto(25) { println "$it"}

4.times { println "$it"}

1.step(10, 2) { println "$it"}

int i = 200
while (i <= 204){
    println i
    i = i+1
}
