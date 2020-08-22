package com.github.diegopacheco.javapocs.powermock.test;

import com.github.diegopacheco.javapocs.powermock.CalculatorStatic;
import com.github.diegopacheco.javapocs.powermock.deep.HistoryCalculator;
import com.github.diegopacheco.javapocs.powermock.deep.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames="com.github.diegopacheco.javapocs.powermock.*")
//@PowerMockIgnore("com.github.diegopacheco.javapocs.powermock.CalculatorStatic")
public class HistoryCalculatorByIgnoreTest {

    @Test
    public void mockDeepFinals() {
        mockStatic(HistoryCalculator.class);
        when(HistoryCalculator.sum(Integer.valueOf(1),Integer.valueOf(1))).thenReturn(new Result(1,1,0));

        Result result = HistoryCalculator.sum(1,1);
        assertEquals(new Result(1,1,0), result);
    }

}
