package com.github.diegopacheco.sandbox.java.hystrix

import com.netflix.hystrix.HystrixCommand
import com.netflix.hystrix.HystrixCommandGroupKey

class UltraSlowServiceComand(
    var name:String = "UltraSlowServiceComand", 
    group:HystrixCommandGroupKey = HystrixCommandGroupKey.Factory.asKey("UltraSlowServiceComand")
) extends HystrixCommand[String](group) {
    
    override def run():String = {
        Thread.sleep(3000)
        return "Hello " + name
    }
    
    override def getFallback():String = { 
       "Failed"
    }
    
}