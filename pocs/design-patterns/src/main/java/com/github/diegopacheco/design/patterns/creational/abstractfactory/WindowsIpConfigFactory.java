package com.github.diegopacheco.design.patterns.creational.abstractfactory;

public class WindowsIpConfigFactory implements IpConfigFactory{
    @Override
    public String[] getIPCommand() {
        return new String[]{"ipconfig"};
    }
}
