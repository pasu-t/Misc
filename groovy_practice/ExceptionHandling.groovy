try {
   int i = 10/0
}catch(Exception exp){
   println "I am inside exception block"
   println exp.getCause()
   println exp.getMessage()
   exp.printStackTrace()
}finally{
println "I am inside finally  block"
}