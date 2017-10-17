package com.blogspot.diegopacheco.scala.test

import com.blogspot.diegopacheco.scala.test.Classe.Pessoa

object Importe {
  
  def inicio = println ("Inicio da aplicação...")
  def fim    = println ("Fim da aplicação...")
  
  def main(args : Array[String]) : Unit = {
    
    inicio
    
    var p: Pessoa = new Pessoa(24,"Diego")
    p.mostrar()
   
    p = new Pessoa(20,"Bruna")
    p.mostrar()
    
    fim
    
    return 0
  }
  
}
