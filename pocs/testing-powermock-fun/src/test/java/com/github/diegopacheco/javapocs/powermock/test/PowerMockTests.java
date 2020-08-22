package com.github.diegopacheco.javapocs.powermock.test;

import com.github.diegopacheco.javapocs.powermock.CalculatorFinal;
import com.github.diegopacheco.javapocs.powermock.CalculatorStatic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.annotation.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.easymock.EasyMock.expect;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.powermock.api.easymock.PowerMock.*;

@RunWith(PowerMockRunner.class)
//@PrepareForTest({CalculatorFinal.class,CalculatorStatic.class}) // also works
@PrepareForTest(fullyQualifiedNames="com.github.diegopacheco.javapocs.powermock.*") // also works
public class PowerMockTests {

    @Mock
    CalculatorFinal mockFinal;

    @Test
    public void mockFinalClassAndMethodWorking() {
        expect(mockFinal.sum(Integer.valueOf(1),Integer.valueOf(1))).andReturn(3).anyTimes();
        replay(mockFinal);

        int result = mockFinal.sum(Integer.valueOf(1),Integer.valueOf(1));
        assertEquals(3, result);
    }

    @Test
    public void mockStaticAndFinalClassAndStaticFinalMethodWorking() {
        mockStatic(CalculatorStatic.class);
        expect(CalculatorStatic.sum(Integer.valueOf(1),Integer.valueOf(1))).andReturn(3);
        replay(CalculatorStatic.class);

        int result = CalculatorStatic.sum(Integer.valueOf(1),Integer.valueOf(1));
        assertEquals(3, result);
    }

}
