package com.github.diegopacheco.sandboxspring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;
import java.util.stream.StreamSupport;


//
// interesting: MutablePropertySources and SpringIterableConfigurationPropertySource.isImmutablePropertySource
//
@Configuration
@PropertySource("classpath:/service.override.properties")
public class BeanDebugger implements ApplicationListener {

    @Autowired
    private Environment env;

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent instanceof ServletWebServerInitializedEvent){
            System.out.println("********** Starting up... " + applicationEvent);
            Properties props = new Properties();
            MutablePropertySources propSrcs = ((AbstractEnvironment) env).getPropertySources();
            StreamSupport.stream(propSrcs.spliterator(), false)
                    .filter(ps -> ps instanceof EnumerablePropertySource)
                    .map(ps -> ((EnumerablePropertySource) ps).getPropertyNames())
                    .flatMap(Arrays::<String>stream)
                    .forEach(propName -> props.setProperty(propName, env.getProperty(propName)));
            System.out.println("Bean Debugger: ");
            System.out.println("Prop Sources: + " + propSrcs);
            System.out.println("Props: : " + props);

            System.out.println(">>> Simple list of all properties source: ");
            Iterator<org.springframework.core.env.PropertySource<?>> ps = propSrcs.iterator();
            int total=0;
            while (ps.hasNext()){
                System.out.println("Property Source: " + ps.next().getName());
                total++;
            }
            System.out.println("Total Number of Properties sources: " + total);
            System.out.println("<<<");

        }
    }
}
