package com.github.diegopacheco.service.app;

import com.github.diegopacheco.hidden.NoOneSeemsMe;
import com.github.diegopacheco.service.history.AuditMathService;
import com.github.diegopacheco.service.math.Calculator;
import com.github.diegopacheco.service.math.SimpleCalculatorService;

public class Main{

  private Main(){}

  public static void main(String[] args){
    Calculator calc = new SimpleCalculatorService();
    AuditMathService audit = new AuditMathService(calc);
    System.out.println("2 + 3 = " + audit.add(2, 3));
    System.out.println("2 - 3 = " + audit.sub(2, 3));
    System.out.println("Historical Math Service = " + audit.getHistory());

    // works because is on the same module
    NoOneSeemsMe.showSecret();
  }
}
