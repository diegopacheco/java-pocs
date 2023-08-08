package com.github.diegopacheco.java.code.elegant;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesApp {
    public static void main(String[] args) {
        System.out.println("Toll price: for a \"\" = " + simulateTollPrice(""));
        System.out.println("Toll price: for a null = " + simulateTollPrice(null));
        System.out.println("Toll price: for a car = " + simulateTollPrice("car"));
        System.out.println("Toll price: for a motorhome = " + simulateTollPrice("motorhome"));
        System.out.println("Toll price: for a truck = " + simulateTollPrice("truck"));
    }

    static final Properties props = new Properties();

    static {
        try{
            InputStream is = PropertiesApp.class.getClassLoader().getResourceAsStream("prices.properties");
            props.load(is);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    private static double simulateTollPrice(String type) {
        if (null == type || "".equals(type.trim())) {
            return Double.parseDouble(props.getProperty("price.standard"));
        }
        return Double.parseDouble(props.getProperty("price." + type));
    }
}
