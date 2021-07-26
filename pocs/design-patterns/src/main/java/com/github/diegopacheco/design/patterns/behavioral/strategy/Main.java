package com.github.diegopacheco.design.patterns.behavioral.strategy;

public class Main {
    public static void main(String[] args) {
        String file = "tax_report.pdf";
        ExportStrategy strategy = StrategyFactory.resolve(file);
        strategy.export(file);
    }
}
