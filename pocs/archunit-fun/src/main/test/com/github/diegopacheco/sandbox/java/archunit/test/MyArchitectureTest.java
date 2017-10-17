package com.github.diegopacheco.sandbox.java.archunit.test;

import com.github.diegopacheco.sandbox.java.archunit.Service;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import java.lang.annotation.Documented;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "com.github.diegopacheco.sandbox.java.archunit")
public class MyArchitectureTest {
    
	@ArchTest
    public static final ArchRule myRule = classes().that()
    									 .areAnnotatedWith(Service.class)
    									 .or().haveSimpleName("*Service")
    									 .should().resideInAnyPackage("com.github.diegopacheco.sandbox.java.archunit")
    									 .orShould().beAnnotatedWith(Documented.class);
            
}