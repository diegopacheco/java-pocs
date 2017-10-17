package com.github.diegopacheco.sandbox.java.proxy.littleproxy;

import java.io.IOException;

import org.littleshoot.proxy.HttpFilters;
import org.littleshoot.proxy.HttpFiltersAdapter;
import org.littleshoot.proxy.HttpFiltersSourceAdapter;
import org.littleshoot.proxy.HttpProxyServer;
import org.littleshoot.proxy.impl.DefaultHttpProxyServer;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;

public class LittleProxyServer {
	public static void main(String[] args) {

		HttpProxyServer server = DefaultHttpProxyServer.bootstrap().withPort(8888)
				.withFiltersSource(new HttpFiltersSourceAdapter() {
					public HttpFilters filterRequest(HttpRequest originalRequest, ChannelHandlerContext ctx) {
						return new HttpFiltersAdapter(originalRequest) {
							
							private String url = "";
							
							@Override
							public HttpResponse clientToProxyRequest(HttpObject httpObject) {
								this.url = originalRequest.getUri();
								System.out.println("clientToProxyRequest for: " + url);
								System.out.println(httpObject);
								System.out.println("******");
								return null;
							}
							
							@Override
							public HttpObject serverToProxyResponse(HttpObject httpObject) {
								System.out.println("serverToProxyResponse");
								System.out.println(httpObject);
								System.out.println("******");
								return httpObject;
							}
							@Override
							public HttpObject proxyToClientResponse(HttpObject httpObject) {
								if (url.toString().contains("error.com")){
									DecoderResult result = DecoderResult.failure(new IOException("Deu ruim!"));
									HttpObject mock = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.INTERNAL_SERVER_ERROR);
									mock.setDecoderResult(result);
									return mock;
								}else if (url.toString().contains("wikipedia")){
									try {
										Thread.sleep(15000L);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
									return httpObject;
								} else{
									return httpObject;
								}
							}

						};
					}
	   }).start();
	   System.out.println(server.toString());

	}
}
