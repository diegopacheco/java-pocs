package tests;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class TestSample {

    @RepeatedTest(value = 2)
    public void test2x(){
        System.out.println("ok");
    }

}