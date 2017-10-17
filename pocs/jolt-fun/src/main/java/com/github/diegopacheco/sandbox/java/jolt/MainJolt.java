package com.github.diegopacheco.sandbox.java.jolt;

import java.io.File;
import java.util.List;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;

public class MainJolt {
	public static void main(String[] args) throws Throwable {
		
		String basePath = new File(".").getCanonicalPath() + "/src/main/resources/";
		
        List chainrSpecJSON = JsonUtils.classpathToList( "/spec.json" );
        Chainr chainr = Chainr.fromSpec( chainrSpecJSON );

        Object inputJSON = JsonUtils.classpathToObject( "/input.json" );

        Object transformedOutput = chainr.transform( inputJSON );
        System.out.println( JsonUtils.toJsonString( transformedOutput ) );
		
	}
}
