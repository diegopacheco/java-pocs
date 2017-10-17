package com.blogspot.diegopacheco.scala.test

object Listas {
  
  def main(args : Array[String]) : Unit = {
    
    val umEDois = List(2, 3)
    val umEDoisETres = 1 :: umEDois
    println(umEDoisETres)
    
    var lista = 1 :: 2 :: 3 :: 4 :: Nil
    println(lista)
    
    lista += 5
    println(lista)
    
    return 0
  }
}
