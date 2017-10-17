package com.github.diegopacheco.sandbox.java.hystrix

import com.netflix.hystrix.HystrixCommand
import com.netflix.hystrix.HystrixCommandGroupKey

class SlowServiceCommand(
    var name:String = "SlowServiceCommand", 
    group:HystrixCommandGroupKey = HystrixCommandGroupKey.Factory.asKey("SlowServiceCommand")
) extends HystrixCommand[String](group) {
    
    override def run():String = {
        return "Hello " + name
    }
    
}