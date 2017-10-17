package com.blogspot.diegopacheco.scala.test

object Classe {
  
  class Pessoa(idade: Int, nome: String){
    def mostrar(){
      println("idade: " + idade + ", Nome:" + nome)
      println("Pessoa no console sem erros!")
    }
  }
  
  def main(args : Array[String]) : Unit = {
    val x: Pessoa = new Pessoa(24,"Diego Pacheco")
    x.mostrar()
    return 0
  }
}
