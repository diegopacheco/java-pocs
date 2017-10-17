package com.blogspot.diegopacheco.scala.test

object Imprime extends Application {
  
  val nome  = "Diego Pacheco": String
  val idade = 24
  
  override def main(args: Array[String]) {
    Console.println("Ola mundo: " + idade + " - Nome:" + nome)
  }

}
