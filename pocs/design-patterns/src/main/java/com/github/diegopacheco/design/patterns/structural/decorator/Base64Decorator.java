package com.github.diegopacheco.design.patterns.structural.decorator;

import java.util.Base64;

public class Base64Decorator extends DataSourceDecorator {

    public Base64Decorator(DataSource source) {
        super(source);
    }

    @Override
    public boolean write(String data) {
        return super.write(encode(data));
    }

    @Override
    public String read() {
        return decode(super.read());
    }

    private String encode(String data) {
        byte[] result = data.getBytes();
        for (int i = 0; i < result.length; i++) {
            result[i] += (byte) 1;
        }
        return Base64.getEncoder().encodeToString(result);
    }

    private String decode(String data) {
        byte[] result = Base64.getDecoder().decode(data);
        for (int i = 0; i < result.length; i++) {
            result[i] -= (byte) 1;
        }
        return new String(result);
    }
}
