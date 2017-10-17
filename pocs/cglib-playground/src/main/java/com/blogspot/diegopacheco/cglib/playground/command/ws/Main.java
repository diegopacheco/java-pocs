package com.blogspot.diegopacheco.cglib.playground.command.ws;

public class Main {
	public static void main(String[] args) {
		
//		WebServiceCommandImpl wscmd = (WebServiceCommandImpl) BaseCGLibEnhacer.newInstance(WebServiceCommandImpl.class);
//		Object result = wscmd.execute("exportData");
//		System.out.println("The REsult is :" + result);
		
		WebServiceCommand wscmdInterface = (WebServiceCommand) BaseCGLibEnhacer.newInstance(WebServiceCommand.class);
		Object result2 = wscmdInterface.execute("exportDataWithInterface");
		System.out.println("The Result 2 is :" + result2);
		
		
	}
}
