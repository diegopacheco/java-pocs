package com.github.diegopacheco.sandbox.java.janio;

import org.codehaus.commons.compiler.CompilerFactoryFactory;
import org.codehaus.commons.compiler.IExpressionEvaluator;
import org.codehaus.janino.ExpressionEvaluator;
import org.codehaus.janino.ScriptEvaluator;

public class MainJanio {
	public static void main(String[] args) throws Throwable {
		
		ExpressionEvaluator ee = new ExpressionEvaluator();
		ee.cook("3 + 4");
		System.out.println(ee.evaluate(null)); 
		
        IExpressionEvaluator ee2 = CompilerFactoryFactory.getDefaultCompilerFactory().newExpressionEvaluator();
        ee2.setExpressionType(double.class);
        ee2.setParameters(new String[] { "total" }, new Class[] { double.class });
        ee2.cook("total >= 100.0 ? 0.0 : 7.95");
        
        Object[] arguments = { new Double(90) };
        Object res = ee2.evaluate( arguments );
        System.out.println("Result = " + String.valueOf(res));
		
        
        ScriptEvaluator se = new ScriptEvaluator();
        se.cook(
        	  " int i = 10; "	  
            + "  System.out.println(i);\n"
            + "  System.out.println(++i);\n"
        );
        se.evaluate(new Object[0]);
        
	}
}
