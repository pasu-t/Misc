//An abstract class is mostly used to provide a base for subclasses to extend and implement the abstract methods and override or use the implemented methods in abstract class.

class AbstractToyota extends abstractCar {
       int topSpeed
       
       @Override
       public Object topSpeed(){
       println "Top speed for $name is $topSpeed"
       }
       
       static void main(args){
       AbstractToyota car1 = new AbstractToyota()
       car1.name = "Toyota"
       car1.color = "Red"
       car1.model = 2019
       car1.topSpeed = 250
       car1.startEngine()
       car1.topSpeed()
       }
       
}