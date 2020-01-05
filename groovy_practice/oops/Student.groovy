class Student {

      String name;
      int sub1Marks;
      int sub2Marks;
      
      def printTotal(){
      println "$name has total marks = " + (sub1Marks+sub2Marks)
      }
      static void main(args) {
      Student student1 = new Student()
      student1.name = "Maha"
      student1.sub1Marks = 80
      student1.sub2Marks = 90
      student1.printTotal()
      
      Student student2 = new Student()
      student2.name = "Balu"
      student2.sub1Marks = 85
      student2.sub2Marks = 90
      student2.printTotal()
      }
      
}