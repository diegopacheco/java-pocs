package com.github.diegopacheco.junit5.testing;

public enum Months {

    JAN(1),
    FEB(2),
    MAR(3),
    APR(4),
    MAY(5),
    JUN(6),
    JUL(7),
    AUG(8),
    SEP(9),
    OCT(10),
    NOV(11),
    DEC(12);

    private int number;

    Months(int number){
        this.number = number;
    }

    public int getValue(){
        return number;
    }

}
