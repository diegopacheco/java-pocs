package com.github.diegopacheco.jee6.scala.servlets

import com.github.diegopacheco.jee6.scala.services.WeatherService

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.inject.Inject

@WebServlet(name = "WeatherServlet", value = Array("/WeatherServlet"), asyncSupported = true, loadOnStartup = 1)
class WeatherServlet extends HttpServlet {
	
  @Inject 
  var weatherServiceEjbAsync:WeatherService = _
  
  override def doGet(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
      weatherServiceEjbAsync.retrieve( req.startAsync() )
  }

}