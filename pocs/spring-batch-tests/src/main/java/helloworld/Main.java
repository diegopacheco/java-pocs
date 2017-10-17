package helloworld;

import org.springframework.batch.core.launch.support.CommandLineJobRunner;

public class Main {
	public static void main(String[] args) {
		//CommandLineJobRunner.main(new String[]{"spring-batch-beans.xml","simpleJob"});		
		CommandLineJobRunner.main(new String[]{"spring-itens-beans.xml","simpleJob"});
	}
}
