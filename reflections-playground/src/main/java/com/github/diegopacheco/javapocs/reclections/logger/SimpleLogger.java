package com.github.diegopacheco.javapocs.reclections.logger;

import com.github.diegopacheco.javapocs.reclections.annotations.PostProcessToString;
import com.github.diegopacheco.javapocs.reclections.annotations.UpperCasePostToString;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleLogger implements Logger{

    private Map<Class,Optional<Method>> cachePostProc = new ConcurrentHashMap<>();
    private Map<Class,Optional<Boolean>> cacheUpper = new ConcurrentHashMap<>();

    @Override
    public <T> void log(T obj) {
        try{
            Optional<Method> customPostProcessor = cachePostProc.get(obj.getClass());
            if (null!=customPostProcessor && !Optional.empty().equals(customPostProcessor)){
                callCustomProcessor(obj,customPostProcessor.get());
                return;
            }else{
                if (processReflectionLevel2(obj)) return;
            }

            if (null!=cacheUpper.get(obj.getClass()) && cacheUpper.get(obj.getClass()).isPresent()){
                System.out.println(obj.toString().toUpperCase());
                return;
            }
            if (!Optional.empty().equals(cacheUpper.get(obj.getClass()))){
                if (processReflectionLevel1(obj)) return;
            }
            System.out.println(obj);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    private <T> boolean processReflectionLevel1(T obj) {
        UpperCasePostToString annotation = obj.getClass().getAnnotation(UpperCasePostToString.class);
        if (null!=annotation){
            cacheUpper.put(obj.getClass(),Optional.of(true));
            System.out.println(obj.toString().toUpperCase());
            return true;
        }
        cacheUpper.put(obj.getClass(),Optional.empty());
        return false;
    }

    private <T> boolean processReflectionLevel2(T obj) {
        if (!Optional.empty().equals(cachePostProc.get(obj.getClass()))){
            Method[] methods = obj.getClass().getDeclaredMethods();
            for(Method m: methods){
                if(null!=m.getDeclaredAnnotation(PostProcessToString.class)){
                    cachePostProc.put(obj.getClass(),Optional.of(m));
                    callCustomProcessor(obj,m);
                    return true;
                }
            }
            cachePostProc.put(obj.getClass(),Optional.empty());
        }
        return false;
    }

    private void callCustomProcessor(Object obj,Method customPostProcessor){
        try{
            String toStringResult = obj.toString();
            toStringResult = (String)customPostProcessor.invoke(obj,toStringResult);
            System.out.println(toStringResult);
        }catch(Exception e){
            throw new RuntimeException(e);
        }

    }

}
