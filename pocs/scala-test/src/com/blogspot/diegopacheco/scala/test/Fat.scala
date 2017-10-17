package com.blogspot.diegopacheco.scala.test

object Fat {
  
  def factorial(x: BigInt): BigInt = if (x == 0) 1 else x * factorial(x - 1)
  
  def main(args : Array[String]) : Unit = {
    val fat = Fat.factorial(30)
    Console.print("O Fatorial de 30 eh: " + fat)
    return 0
  }
  
}