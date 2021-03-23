package com.github.diegopacheco.javapocs.reclections.logger;

import com.github.diegopacheco.javapocs.reclections.annotations.PostToString;

public class SimpleLogger implements Logger{

    @Override
    public <T> void log(T obj) {
        PostToString annotation = obj.getClass().getAnnotation(PostToString.class);
        if (null!=annotation){
            System.out.println(obj.toString().toUpperCase());
            return;
        }
        System.out.println(obj);
    }

}
