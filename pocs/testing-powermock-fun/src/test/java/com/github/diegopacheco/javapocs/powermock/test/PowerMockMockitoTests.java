package com.github.diegopacheco.javapocs.powermock.test;

import com.github.diegopacheco.javapocs.powermock.CalculatorStatic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames="com.github.diegopacheco.javapocs.powermock.*") // also works
public class PowerMockMockitoTests {

    @Test
    public void mockStaticAndFinalClassAndStaticFinalMethodWorking() {
        PowerMockito.mockStatic(CalculatorStatic.class);
        Mockito.when(CalculatorStatic.sum(Integer.valueOf(1),Integer.valueOf(1))).thenReturn(3);
        int result = CalculatorStatic.sum(Integer.valueOf(1),Integer.valueOf(1));

        PowerMockito.verifyStatic(CalculatorStatic.class, Mockito.times(1));
        assertEquals(3, result);
    }

}
