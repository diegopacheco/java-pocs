package com.github.diegopacheco.packagelevelfun.logger;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
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

    public static void debugPrint(Map<String,String> data){
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        List<RuntimeInfo> runtimeInfoList = extractRuntimeInfo(stackTraceElements);

        try {
            for(RuntimeInfo runtimeInfo : runtimeInfoList){
                Class<?> clazz = Class.forName(runtimeInfo.getPackageName() + "." + runtimeInfo.getClassName());
                if(clazz.isAnnotationPresent(com.github.diegopacheco.packagelevelfun.annotation.SecureLogging.class)){
                    for(Map.Entry<String,String> entry : data.entrySet()){
                        if(restrictedFields.containsKey(entry.getKey())){
                            data.put(entry.getKey(),restrictedFields.get(entry.getKey()));
                        }
                    }
                }
            }
        } catch (ClassNotFoundException e) {}

        System.out.println(MessageFormat.format("[DEBUG]: {0}", data));
    }

    public static List<RuntimeInfo> extractRuntimeInfo(StackTraceElement[] stackTraceElements) {
        List<RuntimeInfo> runtimeInfoList = new ArrayList<>();
        for (StackTraceElement element : stackTraceElements) {
            String className = element.getClassName();
            int lastDotIndex = className.lastIndexOf('.');
            if (lastDotIndex != -1) {
                String packageName = className.substring(0, lastDotIndex);
                String simpleClassName = className.substring(lastDotIndex + 1);
                String methodName = element.getMethodName();
                Boolean isSecure = isSecure(className);
                runtimeInfoList.add(new RuntimeInfo(packageName, simpleClassName, methodName,isSecure));
            } else {
                // Handle the case where there is no package name
                String methodName = element.getMethodName();
                Boolean isSecure = false;
                runtimeInfoList.add(new RuntimeInfo("", className, methodName,isSecure));
            }
        }
        return runtimeInfoList;
    }

    private static Boolean isSecure(String className){
        try {
            Class<?> clazz = Class.forName(className);
            if(clazz.isAnnotationPresent(com.github.diegopacheco.packagelevelfun.annotation.SecureLogging.class)){
                return true;
            }
            if (clazz.getPackage().isAnnotationPresent(com.github.diegopacheco.packagelevelfun.annotation.SecureLogging.class)){
                return true;
            }
        } catch (ClassNotFoundException e) {}
        return false;
    }

}
