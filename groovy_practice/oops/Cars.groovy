class Cars {
      String name;
      String color;
      int model;
      
      def getCarDetails(){
          println "You are driving $model, $color colored $name"
      }
      def startEngine(){
          println "Starting engine for $name"
      }
      def stopEngine(){
          println "Stopped engine for $name"
      }
       def accelerate(){
          println "Accelerating engine for $name"
      }
}