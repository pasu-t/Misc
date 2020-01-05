def regex = /(?:[^Groovy]*)/
def match = "This is Groovy" =~ regex

if(match){
   println match[0]
}else {
   println "no match found"
}