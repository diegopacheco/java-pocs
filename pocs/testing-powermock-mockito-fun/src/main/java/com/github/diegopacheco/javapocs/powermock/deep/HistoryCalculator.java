package com.github.diegopacheco.javapocs.powermock.deep;

import com.github.diegopacheco.javapocs.powermock.CalculatorStatic;

public final class HistoryCalculator {

    public final static Result sum(int a,int b){
        int result = CalculatorStatic.sum(1,b);
        return new Result(a,b,result);
    }

}
