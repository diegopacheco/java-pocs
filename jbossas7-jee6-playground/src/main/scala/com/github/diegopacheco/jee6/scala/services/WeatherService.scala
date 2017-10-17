package com.github.diegopacheco.jee6.scala.services

import javax.ejb.Stateless
import javax.ejb.Asynchronous
import javax.servlet.AsyncContext
import java.io.PrintWriter
import java.text.SimpleDateFormat
import java.util.Date

@Stateless
class WeatherService {

  @Asynchronous
  def retrieve(ac:AsyncContext): Unit = {
    Thread.sleep(5000)
    
    val writer = ac.getResponse().getWriter()
    writer.println(new SimpleDateFormat("HH:mm:ss").format(new Date()) + " Faz Muito Friu em POA Tche!")
    writer.close()

    ac.complete()    
  }

}