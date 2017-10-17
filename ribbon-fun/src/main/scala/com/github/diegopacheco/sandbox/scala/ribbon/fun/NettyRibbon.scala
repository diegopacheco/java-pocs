package com.github.diegopacheco.sandbox.scala.ribbon.fun

import io.netty.buffer.ByteBuf
import io.reactivex.netty.protocol.http.client.HttpClientRequest
import io.reactivex.netty.protocol.http.client.HttpClientResponse
import java.util.List
import java.util.concurrent.CountDownLatch
import rx.Observer
import com.google.common.collect.Lists
import com.netflix.ribbon.transport.netty.RibbonTransport
import com.netflix.ribbon.transport.netty.http.LoadBalancingHttpClient
import com.netflix.loadbalancer.BaseLoadBalancer
import com.netflix.loadbalancer.LoadBalancerBuilder
import com.netflix.loadbalancer.Server
import java.util.concurrent.TimeUnit
import rx.functions.Action1
import java.nio.charset.Charset

object NettyRibbon extends App {
  
   val client:LoadBalancingHttpClient[ByteBuf, ByteBuf] = RibbonTransport.newHttpClient()
   
   val request:HttpClientRequest[ByteBuf] = HttpClientRequest.createGet("http://www.google.com/")
   
   val latch:CountDownLatch = new CountDownLatch(1)
   
   client.submit(request)
            .toBlockingObservable()
            .forEach(new Action1[HttpClientResponse[ByteBuf]]() {
                
                override def call(t1:HttpClientResponse[ByteBuf]):Unit = {
                    
                     System.out.println("Status code: " + t1.getStatus());
                     t1.getContent().subscribe(new Action1[ByteBuf]() {
                        
                        override def call(content:ByteBuf):Unit =  {
                            System.out.println("Response content: " + content.toString(Charset.defaultCharset()));
                            latch.countDown()
                        }
                        
                    })
                }
            })
   latch.await(2, TimeUnit.SECONDS)
  
}