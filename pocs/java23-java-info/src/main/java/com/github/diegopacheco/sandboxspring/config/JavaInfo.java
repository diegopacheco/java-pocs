package com.github.diegopacheco.sandboxspring.config;

import org.springframework.stereotype.Component;

/**
 *  Property                        Value (OpenJDK 12)                        Value (Oracle JRE 8u201)                Value (Sun JRE 5u22)                                 Description
 * ------------------------------- ----------------------------------------- --------------------------------------- ---------------------------------------------------- ---------------------------------------------------------------------------------------------------------------
 *  java.version                    "12"                                      "1.8.0_201"                             "1.5.0_22"                                           Java Runtime Environment version, which may be interpreted as a Runtime.Version
 *  java.version.date               "2019-03-19"                              null                                    null                                                 Java Runtime Environment version date, in ISO-8601 YYYY-MM-DD format, which may be interpreted as a LocalDate
 *  java.vendor                     "Oracle Corporation"                      "Oracle Corporation"                    "Sun Microsystems Inc."                              Java Runtime Environment vendor
 *  java.vendor.version             null                                      null                                    null                                                 Java vendor version
 *  java.vendor.url                 "https://java.oracle.com/"                "http://java.oracle.com/"               "http://java.sun.com/"                               Java vendor URL
 *  java.vendor.url.bug             "https://bugreport.java.com/bugreport/"   "http://bugreport.sun.com/bugreport/"   "http://java.sun.com/cgi-bin/bugreport.cgi"          Undocumented
 *  java.specification.name         "Java Platform API Specification"         "Java Platform API Specification"       "Java Platform API Specification"                    Java Runtime Environment specification name
 *  java.specification.vendor       "Oracle Corporation"                      "Oracle Corporation"                    "Sun Microsystems Inc."                              Java Runtime Environment specification vendor
 *  java.specification.version      "12"                                      "1.8"                                   "1.5"                                                Java Runtime Environment specification version, whose value is the feature element of the runtime version
 *  java.vm.name                    "OpenJDK 64-Bit Server VM"                "Java HotSpot(TM) 64-Bit Server VM"     "Java HotSpot(TM) 64-Bit Server VM"                  Java Virtual Machine implementation name
 *  java.vm.vendor                  "Oracle Corporation"                      "Oracle Corporation"                    "Sun Microsystems Inc."                              Java Virtual Machine implementation vendor
 *  java.vm.version                 "12+33"                                   "25.201-b09"                            "1.5.0_22-b03"                                       Java Virtual Machine implementation version which may be interpreted as a Runtime.Version
 *  java.vm.info                    "mixed mode, sharing"                     "mixed mode"                            "mixed mode"                                         Undocumented
 *  java.vm.specification.name      "Java Virtual Machine Specification"      "Java Virtual Machine Specification"    "Java Virtual Machine Specification"                 Java Virtual Machine specification name
 *  java.vm.specification.vendor    "Oracle Corporation"                      "Oracle Corporation"                    "Sun Microsystems Inc."                              Java Virtual Machine specification vendor
 *  java.vm.specification.version   "12"                                      "1.8"                                   "1.0"                                                Java Virtual Machine specification version, whose value is the feature element of the runtime version
 *  java.runtime.name               "OpenJDK Runtime Environment"             "Java(TM) SE Runtime Environment"       "Java(TM) 2 Runtime Environment, Standard Edition"   Undocumented
 *  java.runtime.version            "12+33"                                   "1.8.0_201-b09"                         "1.5.0_22-b03"                                       Undocumented
 *  java.class.version              "56.0"                                    "52.0"                                  "49.0"                                               Java class format version number
 *  jdk.debug                       "release"                                 null                                    null                                                 Undocumented
 *  sun.java.launcher               "SUN_STANDARD"                            "SUN_STANDARD"                          "SUN_STANDARD"                                       Undocumented
 *  sun.management.compiler         "HotSpot 64-Bit Tiered Compilers"
 * 
 */
@Component
public class JavaInfo {

    private String info;

    public JavaInfo(){
        StringBuffer sb = new StringBuffer();
        sb.append(System.getProperty("java.runtime.name")).
                append("\n").
                append(System.getProperty("java.specification.version")).
                append(" ").
                append(System.getProperty("java.runtime.version"));
        info = sb.toString();
    }

    public String getInfo() {
        return info;
    }

}
