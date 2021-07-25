package com.github.diegopacheco.design.patterns.creational.abstractfactory;

public class Main {
    public static void main(String[] args) {
        IpConfigFactory factory;
        ProcessManager pm;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("linux")) {
            factory = new LinuxIpConfigFactory();
            pm = new ProcessManager(factory);
        }else{
            factory = new WindowsIpConfigFactory();
            pm = new ProcessManager(factory);
        }
        System.out.println(pm.getIp());
    }
}
