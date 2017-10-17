package com.blogspot.diegopacheco.scala.test

object Mapas {
  
  def main(args : Array[String]) : Unit = {
	  
	  var capital = Map("US" -> "Washington", "France" -> "Paris")
   
	  capital += ("Japan" -> "Tokyo")
	     
	  println("A Capital de US eh: " + capital("US"))
	  println("A Capital de JP eh: " + capital("Japan"))
      println("A Capital de FR eh: " + capital("France"))
   
	  try{
		  capital -= ("France")
	      println("A Capital de FR eh: " + capital("France"))
	  }catch{
		 case e:Exception => println("Tchau FR! " + e)
	  }
	  
	  return 0
  }
}
