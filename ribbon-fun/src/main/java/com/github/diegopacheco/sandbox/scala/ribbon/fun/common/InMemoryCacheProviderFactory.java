package com.github.diegopacheco.sandbox.scala.ribbon.fun.common;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import rx.Observable;

import com.netflix.ribbon.CacheProvider;
import com.netflix.ribbon.CacheProviderFactory;

public class InMemoryCacheProviderFactory implements CacheProviderFactory<Movie> {

	public CacheProvider<Movie> createCacheProvider() {
		return new InMemoryCacheProvider();
	}

	public static class InMemoryCacheProvider implements CacheProvider<Movie> {
		private final Map<String, Object> cacheMap = new ConcurrentHashMap<String, Object>();

		public Observable<Movie> get(String key,Map<String, Object> requestProperties) {
			return null;
		}
	}
}