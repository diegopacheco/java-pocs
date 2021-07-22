package com.github.diegopacheco.cw.custom.metrics;

public class TagManager {

    private static boolean TEST_MODE = false;

    public static boolean isTestModeON(){
        return TEST_MODE;
    }

    public static boolean enableTestMode(){
        TEST_MODE=true;
        return TEST_MODE;
    }

    public static boolean disableTestMode(){
        TEST_MODE=false;
        return TEST_MODE;
    }

}
