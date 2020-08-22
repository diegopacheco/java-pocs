package com.github.diegopacheco.javapocs.powermock.test;

import com.github.diegopacheco.javapocs.powermock.CalculatorStatic;
import com.github.diegopacheco.javapocs.powermock.deep.HistoryCalculator;
import com.github.diegopacheco.javapocs.powermock.deep.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames="com.github.diegopacheco.javapocs.powermock.*")
public class HistoryCalculatorTest {

    @Test
    public void mockDeepFinals() {
        mockStatic(CalculatorStatic.class);
        when(CalculatorStatic.sum(Integer.valueOf(1),Integer.valueOf(1))).thenReturn(3);

        Result result = HistoryCalculator.sum(1,1);
        assertEquals(new Result(1,1,3), result);
    }

}
