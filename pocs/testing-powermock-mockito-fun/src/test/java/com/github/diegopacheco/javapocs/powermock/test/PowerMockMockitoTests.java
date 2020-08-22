package com.github.diegopacheco.javapocs.powermock.test;

import com.github.diegopacheco.javapocs.powermock.CalculatorStatic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
//@PrepareForTest({CalculatorFinal.class,CalculatorStatic.class}) // also works
@PrepareForTest(fullyQualifiedNames="com.github.diegopacheco.javapocs.powermock.*") // also works
public class PowerMockMockitoTests {

    @Test
    public void mockStaticAndFinalClassAndStaticFinalMethodWorking() {
        mockStatic(CalculatorStatic.class);
        when(CalculatorStatic.sum(Integer.valueOf(1),Integer.valueOf(1))).thenReturn(3);

        int result = CalculatorStatic.sum(Integer.valueOf(1),Integer.valueOf(1));
        assertEquals(3, result);
    }

}
