package com.github.diegopacheco.packagelevelfun.logger;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SecureConsoleLogger {

    private static final Map<String,String> restrictedFields = new ConcurrentHashMap<>();

    static{
        restrictedFields.put("password","**********");
        restrictedFields.put("ssn","###-##-####");
        restrictedFields.put("creditcard","####-####-####-####");
        restrictedFields.put("email","*****@*****");
        restrictedFields.put("firstname","*****");
        restrictedFields.put("lastname","*****");
        restrictedFields.put("name","*****");
    }

    public static void debugPrint(Map<String,String> data){
        Map<String, String> mutableData = new ConcurrentHashMap<>(data);

        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        List<RuntimeInfo> runtimeInfoList = extractRuntimeInfo(stackTraceElements);

        for (RuntimeInfo runtimeInfo : runtimeInfoList) {
            // Simple Fuzzy matching going on here
            String methodName = runtimeInfo.getMethodName();
            if (null != methodName && !methodName.isEmpty()) {
                methodName = methodName.trim().toLowerCase();
                methodName = methodName.replace("get", "");
            }
            for (String key : restrictedFields.keySet()) {
                if (methodName.contains(key)) {
                    mutableData.put(key, restrictedFields.get(key));
                }
            }
        }
        System.out.println(MessageFormat.format("[DEBUG]: {0}", mutableData));
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
                if (isSecure){
                    runtimeInfoList.add(new RuntimeInfo(packageName, simpleClassName, methodName,isSecure));
                }
            } else {
                // no package name, very likely main - do nothing.
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
        } catch (ClassNotFoundException _) {}
        return false;
    }

}
