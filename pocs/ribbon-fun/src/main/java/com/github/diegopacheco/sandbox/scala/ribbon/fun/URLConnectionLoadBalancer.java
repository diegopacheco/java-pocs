package com.github.diegopacheco.sandbox.scala.ribbon.fun;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.google.common.collect.Lists;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.LoadBalancerBuilder;
import com.netflix.loadbalancer.LoadBalancerStats;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.reactive.CommandBuilder;
import com.netflix.loadbalancer.reactive.LoadBalancerExecutable;

public class URLConnectionLoadBalancer {

	private final ILoadBalancer loadBalancer;

	public URLConnectionLoadBalancer(List<Server> serverList) {
		loadBalancer = LoadBalancerBuilder.newBuilder().buildFixedServerListLoadBalancer(serverList);
	}

	public String call(final String path) throws Exception {
		return CommandBuilder.<String> newBuilder()
				.withLoadBalancer(loadBalancer)
				.build(new LoadBalancerExecutable<String>() {
					public String run(Server server) throws Exception {
						
						URL url = new URL("http://" + server.getHost() + ":" + server.getPort() + path);
						HttpURLConnection conn = (HttpURLConnection) url.openConnection();
						return conn.getResponseMessage();
					}
				}).execute();
	}

	public LoadBalancerStats getLoadBalancerStats() {
		return ((BaseLoadBalancer) loadBalancer).getLoadBalancerStats();
	}

	public static void main(String[] args) throws Exception {
		
		URLConnectionLoadBalancer urlLoadBalancer = 
				new URLConnectionLoadBalancer(Lists.newArrayList(new Server("www.google.com", 80),new Server("www.linkedin.com", 80), new Server("www.yahoo.com", 80)));
		
		for (int i = 0; i < 6; i++) {
			System.out.println(urlLoadBalancer.call("/"));
		}
		
		System.out.println("=== Load balancer stats ===");
		System.out.println(urlLoadBalancer.getLoadBalancerStats());
	}
}