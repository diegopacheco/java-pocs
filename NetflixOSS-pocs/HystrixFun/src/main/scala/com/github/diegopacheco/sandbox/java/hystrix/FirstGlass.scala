package com.github.diegopacheco.sandbox.java.hystrix

import java.util.concurrent.Future
import rx.Observable
import com.netflix.config.ConfigurationManager
import rx.functions.Action1
import rx.functions.Action0
import java.util.concurrent.TimeUnit
import rx.Observer
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext
import com.netflix.hystrix.HystrixCommandProperties

object FirstGlass extends App {
  
    //
    // Configs
    //
    
    val context:HystrixRequestContext = HystrixRequestContext.initializeContext()
    HystrixCommandProperties.Setter().withExecutionIsolationThreadTimeoutInMilliseconds(3000)
    
    //
    // Hystrix code
    //
    
    var s:String = new SlowServiceCommand(name = "Bob").execute()
    println(s)
    
    var fut:Future[String] = new SlowServiceCommand(name = "John").queue()
    println(fut.get())
    
    //
    // Hystrix + RX
    //
    
    var ob:Observable[String]= new UltraSlowServiceComand(name = "Martinho").observe()

    val a2:Action1[String] = new Action1[String]{
         def call(t:String){
             println("a2: " + t)
         }
    }
    ob.subscribe(a2)

    println(ob.first())
    
    ob.subscribe(new Observer[String]{
        def onCompleted(){
            println("DONE")
        }
        def onError(t:Throwable){
           println("Error: " + t)
           t.printStackTrace()
        }
        def onNext(v:String){
          println("Next: " + v)
        }
    })
    
    Thread.sleep(5000)
    context.shutdown()
  
}