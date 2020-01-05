class CarObjects {
      static void main(args){
          Car toyota = new Car()
          Car ford = new Car()
          Car mercedes = new Car()
          
          toyota.name = "Toyota"
          toyota.model = 2019
          toyota.color = "Red"
          
          ford.name = "Ford"
          ford.model = 2018
          ford.color = "White"
          
          mercedes.name = "Mercedes"
          mercedes.model = 2017
          mercedes.color = "Grey"
          
          toyota.getCarDetails()
          toyota.startEngine()
          println("#"*50)
          ford.getCarDetails()
          ford.startEngine()
          println("#"*50)
          mercedes.getCarDetails()
          mercedes.startEngine()
          println("#"*50)
      }
}