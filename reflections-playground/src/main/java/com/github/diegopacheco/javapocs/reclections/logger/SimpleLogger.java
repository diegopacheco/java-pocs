package com.github.diegopacheco.javapocs.reclections.logger;

import com.github.diegopacheco.javapocs.reclections.annotations.PostProcessToString;
import com.github.diegopacheco.javapocs.reclections.annotations.UpperCasePostToString;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleLogger implements Logger{

    private Map<Class,Optional<Method>> cachePostProc = new ConcurrentHashMap<>();
    private Map<Class,Boolean> cacheUpper = new ConcurrentHashMap<>();

    @Override
    public <T> void log(T obj) {
        try{
            Optional<Method> customPostProcessor = cachePostProc.get(obj.getClass());
            if (null!=customPostProcessor && !Optional.empty().equals(customPostProcessor)){
                callCustomProcessor(obj,customPostProcessor.get());
                return;
            }else{
                if (!Optional.empty().equals(cachePostProc.get(obj.getClass()))){
                    Method[] methods = obj.getClass().getDeclaredMethods();
                    for(Method m: methods){
                        if(null!=m.getDeclaredAnnotation(PostProcessToString.class)){
                            cachePostProc.put(obj.getClass(),Optional.of(m));
                            callCustomProcessor(obj,m);
                            return;
                        }
                    }
                    cachePostProc.put(obj.getClass(),Optional.empty());
                }
            }

            if (null!=cacheUpper.get(obj.getClass()) && cacheUpper.get(obj.getClass())){
                System.out.println(obj.toString().toUpperCase());
                return;
            }
            UpperCasePostToString annotation = obj.getClass().getAnnotation(UpperCasePostToString.class);
            if (null!=annotation){
                cacheUpper.put(obj.getClass(),true);
                System.out.println(obj.toString().toUpperCase());
                return;
            }

            cacheUpper.put(obj.getClass(),false);
            System.out.println(obj);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
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
