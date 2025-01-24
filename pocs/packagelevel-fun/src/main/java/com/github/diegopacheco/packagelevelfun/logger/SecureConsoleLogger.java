package com.github.diegopacheco.packagelevelfun.logger;

import java.text.MessageFormat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SecureConsoleLogger {

    private static final Map<String,String> restrictedFields = new ConcurrentHashMap<>();

    SecureConsoleLogger(){
        restrictedFields.put("password","**********");
        restrictedFields.put("ssn","###-##-####");
        restrictedFields.put("creditCard","####-####-####-####");
        restrictedFields.put("email","*****@*****");
        restrictedFields.put("firstName","*****");
        restrictedFields.put("lastName","*****");
        restrictedFields.put("name","*****");
    }

    public static void debug(Map<String,String> data){
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String callerClass = stackTraceElements[2].getClassName();
        try {
            Class<?> clazz = Class.forName(callerClass);
            if(clazz.isAnnotationPresent(com.github.diegopacheco.packagelevelfun.annotation.SecureLogging.class)){
                for(Map.Entry<String,String> entry : data.entrySet()){
                    if(restrictedFields.containsKey(entry.getKey())){
                        data.put(entry.getKey(),restrictedFields.get(entry.getKey()));
                    }
                }
            }
        } catch (ClassNotFoundException e) {}

        System.out.println(MessageFormat.format("[DEBUG]: {0}", data));
    }

}
