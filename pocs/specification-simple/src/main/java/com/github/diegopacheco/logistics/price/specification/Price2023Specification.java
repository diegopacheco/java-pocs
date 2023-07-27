package com.github.diegopacheco.logistics.price.specification;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Price2023Specification implements PriceSpecification{

    private Map<State,BigDecimal> taxPerState = new ConcurrentHashMap<>();

    public Price2023Specification() {
        taxPerState.put(State.Alabama,new BigDecimal(11));
        taxPerState.put(State.Alaska,new BigDecimal(7.5));
        taxPerState.put(State.Arizona,new BigDecimal(11.2));
        taxPerState.put(State.Arkansas,new BigDecimal(11.5));
        taxPerState.put(State.California,new BigDecimal(10.25));
        taxPerState.put(State.Colorado,new BigDecimal(11.2));
        taxPerState.put(State.Connecticut,new BigDecimal(6.35));
        taxPerState.put(State.Delaware,new BigDecimal(0));
        taxPerState.put(State.Georgia,new BigDecimal(9));
        taxPerState.put(State.Hawaii,new BigDecimal(4.5));
        taxPerState.put(State.Idaho,new BigDecimal(9));
        taxPerState.put(State.Illinois,new BigDecimal(11));
        taxPerState.put(State.Indiana,new BigDecimal(7));
        taxPerState.put(State.Iowa,new BigDecimal(8));
        taxPerState.put(State.Florida,new BigDecimal(8));
        taxPerState.put(State.Kansas,new BigDecimal(10.6));
        taxPerState.put(State.Kentucky,new BigDecimal(6));
        taxPerState.put(State.Louisiana,new BigDecimal(11.45));
        taxPerState.put(State.Maine,new BigDecimal(5.50));
        taxPerState.put(State.Maryland,new BigDecimal(6));
        taxPerState.put(State.Massachusetts,new BigDecimal(6.25));
        taxPerState.put(State.Michigan,new BigDecimal(0));
        taxPerState.put(State.Minnesota,new BigDecimal(8.37));
        taxPerState.put(State.Mississippi,new BigDecimal(8));
        taxPerState.put(State.Missouri,new BigDecimal(10.1));
        taxPerState.put(State.Montana,new BigDecimal(0));
        taxPerState.put(State.Nebraska,new BigDecimal(7.5));
        taxPerState.put(State.Nevada,new BigDecimal(8.26));
        taxPerState.put(State.New_Hampshire,new BigDecimal(0));
        taxPerState.put(State.New_Jersey,new BigDecimal(0));
        taxPerState.put(State.New_Mexico,new BigDecimal(8.75));
        taxPerState.put(State.New_York,new BigDecimal(8.75));
        taxPerState.put(State.North_Carolina,new BigDecimal(7.5));
        taxPerState.put(State.North_Dakota,new BigDecimal(8.5));
        taxPerState.put(State.Ohio,new BigDecimal(8));
        taxPerState.put(State.Oklahoma,new BigDecimal(11.5));
        taxPerState.put(State.Oregon,new BigDecimal(0));
        taxPerState.put(State.Pennsylvania,new BigDecimal(8));
        taxPerState.put(State.Rhode_Island,new BigDecimal(7));
        taxPerState.put(State.South_Carolina,new BigDecimal(9));
        taxPerState.put(State.South_Dakota,new BigDecimal(6.5));
        taxPerState.put(State.Tennessee,new BigDecimal(10));
        taxPerState.put(State.Texas,new BigDecimal(8.25));
        taxPerState.put(State.Utah,new BigDecimal(8.7));
        taxPerState.put(State.Vermont,new BigDecimal(7));
        taxPerState.put(State.Virginia,new BigDecimal(7));
        taxPerState.put(State.Washington,new BigDecimal(10.4));
        taxPerState.put(State.West_Virginia,new BigDecimal(7));
        taxPerState.put(State.Wisconsin,new BigDecimal(5.6));
        taxPerState.put(State.Wyoming,new BigDecimal(6));
    }

    @Override
    public boolean isSatisfiedBy(int year, State state) {
        return 2023==year && taxPerState.containsKey(state);
    }

    @Override
    public BigDecimal getTax(State state) {
        BigDecimal taxState = taxPerState.get(state);
        return taxState;
    }

}


