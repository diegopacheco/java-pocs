package com.github.diegopacheco.sandbox.java.rx.fun.scala

object ObservableScalaFun extends App {

  import rx.lang.scala.Observable

  def hello(names: String*) {
    Observable.from(names) subscribe { n =>
      println(s"Hello $n!")
    }
  }

  hello("Jorge")
  hello("Jorge", "Bem", "Jor")
  hello("Bateria")

}