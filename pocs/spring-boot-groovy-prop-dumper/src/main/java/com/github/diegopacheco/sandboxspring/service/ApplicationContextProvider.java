package com.github.diegopacheco.sandboxspring.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.stereotype.Component;

import java.util.*;

@Component("ApplicationContextProvider")
public class ApplicationContextProvider implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static ApplicationContext getContext() {
        return applicationContext;
    }

    public static void printConfigs(){
        ConfigurableEnvironment env = (ConfigurableEnvironment) getContext().getEnvironment();
        System.out.println("************************* ACTIVE APP PROPERTIES ******************************");
        List<MapPropertySource> propertySources = new ArrayList<>();

        env.getPropertySources().forEach(it -> {
            if (it instanceof MapPropertySource) {
                propertySources.add((MapPropertySource) it);
            }
        });

        propertySources.stream()
                .map(propertySource -> propertySource.getSource().keySet())
                .flatMap(Collection::stream)
                .distinct()
                .sorted()
                .forEach(key -> {
                    try {
                        System.out.println(key + "=" + env.getProperty(key));
                    } catch (Exception e) {
                        System.out.println(String.format("%s -> %s", key, e.getMessage()));
                    }
                });
        System.out.println("******************************************************************************");
    }

    public static Map<String,String> getAllConfigs(){
        Map<String,String> result = new HashMap<>();
        ConfigurableEnvironment env = (ConfigurableEnvironment) getContext().getEnvironment();
        List<MapPropertySource> propertySources = new ArrayList<>();

        env.getPropertySources().forEach(it -> {
            if (it instanceof MapPropertySource) {
                propertySources.add((MapPropertySource) it);
            }
        });

        final Map<String,MapPropertySource> cps = new HashMap<>();
        propertySources.stream()
                .map(propertySource -> {
                    cps.put("CPS", propertySource);
                    return propertySource.getSource().keySet();
                })
                .flatMap(Collection::stream)
                .distinct()
                .sorted()
                .forEach(key -> {
                    try {
                        result.put(key, cps.get("CPS") + "." +  key + "=" + env.getProperty(key));
                    } catch (Exception e) {
                        result.put(key,(String.format("%s -> %s", key, e.getMessage())));
                    }
                });


        Iterator<MapPropertySource> ps = propertySources.iterator();
        int total=0;
        while (ps.hasNext()){
            result.put("PROPERTY_SOURCE_"+total,ps.next().getName());
            total++;
        }
        return result;
    }

}