package com.github.diegopacheco.sandboxspring.conf;

import com.github.diegopacheco.sandboxspring.driver.Anonymizing;
import com.github.diegopacheco.sandboxspring.driver.AnonymizingCatalog;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import java.lang.reflect.Field;
import java.util.Set;

@Configuration
public class AnonymizingScanner {

    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .forPackages("com.github.diegopacheco.sandboxspring")
                .addScanners(new FieldAnnotationsScanner()));

        Set<Field> fields = reflections.getFieldsAnnotatedWith(Anonymizing.class);
        for (Field field : fields) {
            Class<?> declaringClass = field.getDeclaringClass();
            Anonymizing anonymizing = field.getAnnotation(Anonymizing.class);
            String dbFieldName = anonymizing.dbFieldName();
            AnonymizingCatalog.getInstance().addAnonymizingField(declaringClass.getSimpleName(), dbFieldName,anonymizing);
        }
    }
}