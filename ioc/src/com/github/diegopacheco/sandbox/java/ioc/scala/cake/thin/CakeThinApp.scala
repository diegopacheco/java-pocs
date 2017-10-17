package com.github.diegopacheco.sandbox.java.ioc.scala.cake.thin

object CakeThinApp extends App {
  
    case class Car(var model:String)
    
    trait TaxService{
       def tollOneWay:Double = 0      
    }
  
    trait BrazillianTollService extends TaxService {
        lazy val aditional:String = "Scala Rocks"
        
        override lazy val tollOneWay:Double = {
          // goto database retrieve this value bla bla bla... 
          6.95D 
        }
    }
    
    trait ArgentinianTollService extends TaxService {
        lazy val aditional:String = "Scala Rocks"
        
        override lazy val tollOneWay:Double = {
          // goto database retrieve this value bla bla bla... 
          16.95D 
        }
    }
    
    class LocalApp extends TaxService with BrazillianTollService{
         // override lazy val tollOneWay:Double = 7.95D
         //override lazy val tollOneWay:Double = -1;
        
       val doit = new TaxService with ArgentinianTollService 
      
       println( aditional )
    }
    
    val c:Car = Car("Gol")
    println( new LocalApp().tollOneWay )
    println( new LocalApp().doit.tollOneWay )
    
    println( new TaxService with BrazillianTollService  ().tollOneWay )
    println( new TaxService with ArgentinianTollService ().tollOneWay )
    
    
  
}