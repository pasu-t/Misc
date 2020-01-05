abstract class abstractCar {
      String name;
      String color;
      int model;
      
      def startEngine() {
          println "Starting engine for $name"
      }
      
      abstract def topSpeed()
}
      