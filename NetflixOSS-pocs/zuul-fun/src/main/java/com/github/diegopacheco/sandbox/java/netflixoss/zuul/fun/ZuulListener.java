package com.github.diegopacheco.sandbox.java.netflixoss.zuul.fun;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.FilterFileManager;
import com.netflix.zuul.FilterLoader;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.filters.FilterRegistry;
import com.netflix.zuul.groovy.GroovyCompiler;
import com.netflix.zuul.groovy.GroovyFileFilter;
import com.netflix.zuul.monitoring.CounterFactory;
import com.netflix.zuul.monitoring.TracerFactory;
import com.netflix.zuul.plugins.Counter;
import com.netflix.zuul.plugins.Tracer;

public class ZuulListener implements ServletContextListener {

	private static final Logger logger = LoggerFactory.getLogger(ZuulListener.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("Booting up... ");
		logger.info("Register servo tracer... ");
		TracerFactory.initialize(new Tracer());

		logger.info("Registering Servo Counter...");
		CounterFactory.initialize(new Counter());
		initJavaFilters();
		initGroovyFilterManager();
	}

	private void initGroovyFilterManager() {
		logger.info("Registering Groovy Filtersr...");
		FilterLoader.getInstance().setCompiler(new GroovyCompiler());
		String scriptRoot = System.getProperty("zuul.filter.root", "");
		
		if (scriptRoot.length() > 0)
			scriptRoot = scriptRoot + File.separator;
		try {
			FilterFileManager.setFilenameFilter(new GroovyFileFilter());
			FilterFileManager.init(5, scriptRoot + "pre", scriptRoot + "route",scriptRoot + "post");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		logger.info("Shuting down the little house :-) ");

	}

	private void initJavaFilters() {
		logger.info("Registering Zuul filters in java... ");
		final FilterRegistry r = FilterRegistry.instance();

		r.put("javaPreFilter", new ZuulFilter() {
			@Override
			public int filterOrder() {
				return 1;
			}

			@Override
			public String filterType() {
				return "pre";
			}

			@Override
			public boolean shouldFilter() {
				return true;
			}

			@Override
			public Object run() {
				logger.info("running javaPreFilter");
				RequestContext.getCurrentContext().set("javaPreFilter-ran",
						true);
				return null;
			}
		});

		r.put("javaPostFilter", new ZuulFilter() {
			@Override
			public int filterOrder() {
				return 2;
			}

			@Override
			public String filterType() {
				return "post";
			}

			@Override
			public boolean shouldFilter() {
				return true;
			}

			@Override
			public Object run() {
				logger.info("running javaPostFilter");
				RequestContext.getCurrentContext().set("javaPostFilter-ran",
						true);
				return null;
			}
		});
	}

}
