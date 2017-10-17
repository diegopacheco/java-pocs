package com.github.diegopacheco.sandbox.scala.ribbon.fun.common;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.UnpooledByteBufAllocator;

import java.nio.charset.Charset;
import java.util.Map;

import rx.Observable;

import com.netflix.hystrix.HystrixExecutableInfo;
import com.netflix.ribbon.hystrix.FallbackHandler;

public class RecommendationServiceFallbackHandler implements FallbackHandler<ByteBuf> {
	
	public Observable<ByteBuf> getFallback(HystrixExecutableInfo<?> hystrixInfo,Map<String, Object> requestProperties) {
		byte[] bytes = Movie.ORANGE_IS_THE_NEW_BLACK.toString().getBytes(Charset.defaultCharset());
		ByteBuf byteBuf = UnpooledByteBufAllocator.DEFAULT.buffer(bytes.length);
		byteBuf.writeBytes(bytes);
		return Observable.just(byteBuf);
	}
	
}