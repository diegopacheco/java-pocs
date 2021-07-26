package com.github.diegopacheco.design.patterns.structural.decorator;

// Decorator
public class DataSourceDecorator implements DataSource{
    private DataSource wrappee;

    DataSourceDecorator(DataSource source) {
        this.wrappee = source;
    }

    @Override
    public boolean write(String data) {
        return wrappee.write(data);
    }

    @Override
    public String read() {
        return wrappee.read();
    }
}
