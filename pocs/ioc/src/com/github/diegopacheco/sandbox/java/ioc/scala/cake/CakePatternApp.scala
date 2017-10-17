package com.github.diegopacheco.sandbox.java.ioc.scala.cake

object CakePatternApp extends App {
  
    case class Car(var model:String)
    
    trait TaxRepository{
       def tollOneWay():Double
    }
    
    trait TaxRepositoryComponent {
        def getRepo():TaxRepository
    }
    
    class TaxService(var repo:TaxRepository){
       def tollOneWay():Double = repo.tollOneWay()      
    }
    
    trait TaxServiceComponent extends TaxRepositoryComponent {
       def get():TaxService = new TaxService(repo = getRepo)
    }
    
    trait BrazillianTollService extends TaxRepositoryComponent {
        def getRepo():TaxRepository = new TaxRepository(){
            def tollOneWay():Double = 6.95D
        }
    }
    
    class LocalApp extends TaxServiceComponent with BrazillianTollService
    
    val c:Car = Car("Gol")
    println( new LocalApp().getRepo().tollOneWay())
    
  
}