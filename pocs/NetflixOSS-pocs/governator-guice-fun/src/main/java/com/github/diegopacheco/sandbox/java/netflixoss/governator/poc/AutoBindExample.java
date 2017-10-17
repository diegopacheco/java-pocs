package com.github.diegopacheco.sandbox.java.netflixoss.governator.poc;

import java.util.List;

import com.github.diegopacheco.sandbox.java.netflixoss.governator.poc.exs.ExampleObjectA;
import com.github.diegopacheco.sandbox.java.netflixoss.governator.poc.exs.ExampleObjectB;
import com.google.common.collect.Lists;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;
import com.netflix.governator.annotations.AutoBind;
import com.netflix.governator.guice.AutoBindProvider;
import com.netflix.governator.guice.BootstrapBinder;
import com.netflix.governator.guice.BootstrapModule;
import com.netflix.governator.guice.LifecycleInjector;
import com.netflix.governator.lifecycle.LifecycleManager;

@SuppressWarnings("deprecation")
public class AutoBindExample {
	
	public static void main(String[] args) throws Exception{
        List<Class<?>> ignore = Lists.newArrayList();
        
		Injector injector = LifecycleInjector
            .builder()
            .usingBasePackages("com.github.diegopacheco")
            .ignoringAutoBindClasses(ignore)
            .withBootstrapModule(
                new BootstrapModule(){
                    @Override
                    public void configure(BootstrapBinder binder){
                        TypeLiteral<AutoBindProvider<AutoBind>> typeLiteral = new TypeLiteral<AutoBindProvider<AutoBind>>(){};
                        binder.bind(typeLiteral).to(ExampleAutoBindProvider.class).asEagerSingleton();
                    }
                }
            )
            .createInjector();

        LifecycleManager manager = injector.getInstance(LifecycleManager.class);
        manager.start();

        System.out.println(injector.getInstance(ExampleObjectA.class).getValue());
        System.out.println(injector.getInstance(ExampleObjectB.class).getValue());

        manager.close();
    }
}
