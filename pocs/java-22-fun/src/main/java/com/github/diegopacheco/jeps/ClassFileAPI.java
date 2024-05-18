package com.github.diegopacheco.jeps;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.classfile.ClassElement;
import java.lang.classfile.ClassFile;
import java.lang.classfile.ClassModel;
import java.lang.classfile.MethodModel;

public class ClassFileAPI {

    public static class PersonPojo{
        private String name;
        private int age;

        public PersonPojo(){}

        public PersonPojo(String name, int age){
            this.name = name;
            this.age = age;
        }

        public String getName(){
            return name;
        }
        public String debugGetName(){
            return name;
        }
    }

    public static void run(){
        System.out.println("457: Class-File API (Preview)");

        String className = PersonPojo.class.getName();
        String classAsPath = className.replace('.', '/') + ".class";
        InputStream stream = PersonPojo.class.getClassLoader().getResourceAsStream(classAsPath);
        byte[] bytes = null;
        try {
            bytes = IOUtils.toByteArray(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ClassFile cf = ClassFile.of();
        ClassModel classModel = cf.parse(bytes);
        byte[] newBytes = cf.build(classModel.thisClass().asSymbol(),
                classBuilder -> {
                    for (ClassElement ce : classModel) {
                        if (!(ce instanceof MethodModel mm
                                && mm.methodName().stringValue().startsWith("debug"))) {
                            classBuilder.with(ce);
                        }
                    }
                });
        System.out.println(new String(newBytes));
    }
}
