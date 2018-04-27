package com.github.diegopacheco.netflixoss.sandbox.governator.test;

import java.util.List;

import org.junit.Test;

import com.github.diegopacheco.netflixoss.sandbox.governator.MyConfig;
import com.google.common.collect.Lists;
import com.google.inject.Injector;
import com.netflix.config.ConfigurationManager;
import com.netflix.governator.configuration.ArchaiusConfigurationProvider;
import com.netflix.governator.guice.BootstrapBinder;
import com.netflix.governator.guice.BootstrapModule;
import com.netflix.governator.guice.LifecycleInjector;
import com.netflix.governator.lifecycle.LifecycleManager;

public class MyConfigTest {
	
		@Test
		public void testAnn() throws Throwable {
			
			ConfigurationManager.getConfigInstance().setProperty("config.host", "127.0.0.1");
      ConfigurationManager.getConfigInstance().setProperty("config.port", "6379");
			
			List<Class<?>> ignore = Lists.newArrayList();
			Injector injector = LifecycleInjector
          .builder()
          .usingBasePackages("com.github.diegopacheco.netflixoss")
          .ignoringAutoBindClasses(ignore)
          .withBootstrapModule(
              new BootstrapModule(){
                  @Override
                  public void configure(BootstrapBinder binder){
                  	binder.bindConfigurationProvider().to(ArchaiusConfigurationProvider.class);
                  }
              }
          ).createInjector();
			
      LifecycleManager manager = injector.getInstance(LifecycleManager.class);
      manager.start();
      
      System.out.println("LifecycleManager: " + manager);
      System.out.println("Config: " + injector.getInstance(MyConfig.class));
      System.out.println("Host: " + injector.getInstance(MyConfig.class).getHost());
      System.out.println("Port: " + injector.getInstance(MyConfig.class).getPort());
			
		}
	
}
