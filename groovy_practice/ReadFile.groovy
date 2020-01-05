/**reading files**/
def filePath = "data1.txt"
File myFile = new File(filePath)
//reading entire content as a String
println myFile.text

//collect lines into a list
def list = myFile.collect { it }
println "list : $list"

//read file into a list of string
def lines  = myFile.readLines()
println "lines : $lines"

myFile.each { line ->
       println line
}

myFile.eachLine { line, lineNo ->
       println "$lineNo : $line"
}

//read with reader
myFile.withReader { reader ->
        while((line = reader.readLine()) != null){
        println "$line"
        }
}

//reading with newReader(if you want to keep the file open for doing some operations)
def outputFile = "data2.txt"
def reader = myFile.newReader()
new File(outputFile).append(reader)
reader.close()

//when working with binary files. read content as bytes
byte[] contents = myFile.bytes
println contents

//size in bytes
println myFile.length()

//check if it a file or directory
println myFile.isFile()
println myFile.isDirectory()

//get list of files from directory
new File("C:/Users/Home/Desktop/pasi/MyGroovy").eachFile {
       file -> println file.getAbsolutePath()
}

//recursively display all files in a dir & its sub-dir
new File("C:/Users/Home/Desktop/pasi/MyGroovy").eachFileRecurse {
       file -> println file.getAbsolutePath()
}
//copy file data to another file
def newFile = new File("data3.txt")
 newFile << myFile.text

//delete a file
newFile.delete()