package com.github.diegopacheco.oop.antipatterns.boolflag;

/**
 * BoolFlag Antipattern
 *
 * This class demonstrates the BoolFlag antipattern where a boolean flag is used to control
 * the flow of logic in a method, leading to less readable and maintainable code.
 *
 * Instead, consider using polymorphism or separate methods for different behaviors.
 */
public class BoolFag {

    // Provider
    public void generateReport(boolean summary) {
        if (summary) {
             // process summary report
        } else {
            // process detailed report
        }
    }

    // Consumer
    class ExporterClient{
        public void process(){
            generateReport(true);
        }
    }

}
