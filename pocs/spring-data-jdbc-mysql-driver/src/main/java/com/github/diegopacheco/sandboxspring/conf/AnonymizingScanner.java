package com.github.diegopacheco.sandboxspring.conf;

import com.github.diegopacheco.sandboxspring.driver.Anonymizing;
import com.github.diegopacheco.sandboxspring.driver.AnonymizingCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import java.lang.reflect.Field;

@Configuration
public class AnonymizingScanner {

    @Autowired
    private ApplicationContext applicationContext;

    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            Class<?> beanClass = applicationContext.getType(beanName);
            if (beanClass != null) {
                for (Field field : beanClass.getDeclaredFields()) {
                    if (field.isAnnotationPresent(Anonymizing.class)) {
                        AnonymizingCatalog.getInstance().addAnonymizingField(beanName.getClass().getSimpleName(),field.getName());
                    }
                }
            }
        }
    }
}