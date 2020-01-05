File myFile = new File("data1.txt")
myFile.write("This is Line 1")
myFile << "This is Line 2"
//myFile.text = "This is all"
myFile.withWriter{ writer ->
     writer.writeLine('This is Line 4')
}
myFile.append("This is Line 5")
println myFile.isHidden()

def newFile= new File("data2.txt")
newFile << myFile.text

myFile.bytes = []
myFile.delete()

