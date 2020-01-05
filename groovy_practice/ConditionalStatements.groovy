//def num = -1
//if(num==0){
//println "num is zero"
//}
//else if(num >0){
//println "num is +ve"
//}
//else{
//println "num is -ve"
//}

//switch
def x = 121092342091741037401370347013792095203920358295034257476049375345703475034570
def result = ""
switch(x){
     case 0:
       result = "x is zero"
       break
     case {x>0}:
       result = "x is +ve"
       break
     case {x<0}:
       result = "x is -ve"
       break
     defaul:
       result = "invalid number"
}
println result
