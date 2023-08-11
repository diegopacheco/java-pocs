package com.github.diegopacheco.java.code.elegant;

public class IfObjectApp {
    public static void main(String[] args) {
        System.out.println("Toll price: for a \"\" = " + simulateTollPrice(""));
        System.out.println("Toll price: for a null = " + simulateTollPrice(null));
        System.out.println("Toll price: for a car = " + simulateTollPrice("car"));
        System.out.println("Toll price: for a motorhome = " + simulateTollPrice("motorhome"));
        System.out.println("Toll price: for a truck = " + simulateTollPrice("truck"));
    }

    static class ApplyIF {
        private Boolean condition;
        private double trueBranch;

        private double defaultBranch=0d;

        public ApplyIF(Boolean condition, double trueBranch){
            this.condition = condition;
            this.trueBranch = trueBranch;
        }

        public double eval(){
            return (condition) ? trueBranch : defaultBranch;
        }

    }

    private static double simulateTollPrice(final String type){
        return
            new ApplyIF("car".equals(type) , 10.93d).eval() +
            new ApplyIF("motorhome".equals(type) , 14.23d).eval() +
            new ApplyIF("truck".equals(type) , 17.55d).eval() +
            new ApplyIF(null==type || "".equals(type) , 4.31).eval();
    }
}