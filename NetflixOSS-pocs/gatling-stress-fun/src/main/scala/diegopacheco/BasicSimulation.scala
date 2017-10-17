package diegopacheco

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class BasicSimulation extends Simulation {

  val httpConf = http
    .baseURL("http://www.google.com.br") // Here is the root for all relative URLs
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  val scn = scenario("Test Google") 
    .exec(http("request_basic_search_java") // Here's an example of a POST request
      .post("/?gws_rd=ssl#q=java")
      .headers( Map("Content-Type" -> """application/x-www-form-urlencoded""") )
      .formParam("""q""", """java"""))

  setUp(scn.inject(atOnceUsers(1)).protocols(httpConf))
}