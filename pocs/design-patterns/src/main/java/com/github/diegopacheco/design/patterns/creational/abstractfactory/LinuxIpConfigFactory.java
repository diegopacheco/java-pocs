package com.github.diegopacheco.design.patterns.creational.abstractfactory;

public class LinuxIpConfigFactory implements IpConfigFactory{
    @Override
    public String[] getIPCommand() {
        return new String[]{"/sbin/ifconfig","-a"};
    }
}
