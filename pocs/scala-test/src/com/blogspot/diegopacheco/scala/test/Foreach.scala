package com.blogspot.diegopacheco.scala.test

object Foreach {
  def main(args : Array[String]) : Unit = {
    
    var as = Array("a","b") 
    
    as.foreach(
       (arg: String) => {
    	   print("|")
    	   print(arg)
    	   print("|\n")
       }
    )
    
    for (i <- 1.to(10))
    	println("7 X " + i + " = " + (i * 7) )
    
    return 0
  }
}
