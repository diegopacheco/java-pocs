package com.github.diegopacheco.javapocs.reclections.logger;

import com.github.diegopacheco.javapocs.reclections.annotations.PostProcessToString;
import com.github.diegopacheco.javapocs.reclections.annotations.UpperCasePostToString;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleLogger implements Logger{

    private Map<Class,Method> cachePostProc = new ConcurrentHashMap<>();
    private Map<Class,Boolean> cacheUpper = new ConcurrentHashMap<>();

    @Override
    public <T> void log(T obj) {
        try{
            Method customPostProcessor = cachePostProc.get(obj.getClass());
            if (null!=customPostProcessor){
                callCustomProcessor(obj,customPostProcessor);
                return;
            }
            Method[] methods = obj.getClass().getDeclaredMethods();
            for(Method m: methods){
                if(null!=m.getDeclaredAnnotation(PostProcessToString.class)){
                    cachePostProc.put(obj.getClass(),m);
                    callCustomProcessor(obj,m);
                    return;
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
