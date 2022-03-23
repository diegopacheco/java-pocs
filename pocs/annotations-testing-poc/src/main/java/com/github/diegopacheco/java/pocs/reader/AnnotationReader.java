package com.github.diegopacheco.java.pocs.reader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AnnotationReader {

    public static<T> T getAnnotationValue(Class<?> clazz,Class<? extends Annotation> annotationClass,String method){
        try{
            Annotation annotation = clazz.getAnnotation(annotationClass);
            Method m = annotationClass.getMethod(method,(Class[])null);
            if (null==annotation) return((T)m.getDefaultValue());
            T result = (T)m.invoke(annotation,(Object[])null);
            return result;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public static Set<Class> findAllClasses(String packageName,Class annotationFilter) {
        try {
            InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream(packageName.replaceAll("[.]", "/"));
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            Set<Class> allClasses = reader.lines()
                    .filter(line -> line.endsWith(".class"))
                    .map(line -> getClass(line, packageName))
                    .collect(Collectors.toSet());

            Set<Class> result = new HashSet<>();
            for(Class clazz : allClasses){
                Annotation a = clazz.getDeclaredAnnotation(annotationFilter);
                if (null!=a){
                    result.add(clazz);
                }
            }
            return result;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    private static Class getClass(String className, String packageName) {
        try {
            return Class.forName(packageName+"."+ className.substring(0, className.lastIndexOf('.')));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
