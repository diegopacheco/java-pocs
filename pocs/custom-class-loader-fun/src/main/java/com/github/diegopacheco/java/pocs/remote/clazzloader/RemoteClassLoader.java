package com.github.diegopacheco.java.pocs.remote.clazzloader;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class RemoteClassLoader {
    public static void load(){
        try{
            URL urlRemote1 = new URL("https://repo1.maven.org/maven2/org/apache/commons/" +
                    "commons-lang3/3.12.0/commons-lang3-3.12.0.jar");

            URL urlLocal = (new URL("file://" + new File(System.getProperty("user.home") + "/.m2/repository/org/springframework/spring-core/5.3.8/" +
                    "spring-core-5.3.8.jar").getAbsolutePath()));

            URLClassLoader classLoader = new URLClassLoader(new URL[]{urlRemote1,urlLocal});

            Class<?> clz = classLoader.loadClass("org.apache.commons.lang3.math.NumberUtils");
            System.out.println("Remote Loaded class: " + clz);

            Object obj = clz.getDeclaredConstructor().newInstance();
            System.out.println("Remote Loaded Object: " + obj);
            System.out.println("Remote Loaded Object Methods: ");
            for(Method m: obj.getClass().getDeclaredMethods()){
                System.out.println(m.getName());
            }

            Method method = clz.getDeclaredMethod("isDigits",String.class);
            Object result = method.invoke(obj,"42");
            System.out.println("Result from remote class: NumberUtils.isDigits(42)==" + result);

            try{
                Class<?> clz2 = RemoteClassLoader.class.getClassLoader().loadClass("org.apache.commons.lang3.math.NumberUtils");
                System.out.println("Remote Loaded class LOCALLY : " + clz2);
            }catch(Exception e){
                System.out.println(e);
                System.out.println("Perfect ISOLATION - cant load remote classes with regular CL! ");
            }



        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
