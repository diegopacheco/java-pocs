package com.github.diegopacheco.archunit.arch;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

@AnalyzeClasses(packages = "com.github.diegopacheco.archunit", importOptions = ImportOption.DoNotIncludeTests.class)
public class DependencyRulesTest {

    @ArchTest
    static final ArchRule modelDependsOnNothingElse = noClasses()
            .that().resideInAPackage("..model..")
            .should().dependOnClassesThat()
            .resideInAnyPackage("..controller..", "..service..", "..dao..", "..config..")
            .as("the domain model must not depend on any other layer");

    @ArchTest
    static final ArchRule servicesNeverDependOnControllers = noClasses()
            .that().resideInAPackage("..service..")
            .should().dependOnClassesThat().resideInAPackage("..controller..")
            .as("services must not know about controllers");

    @ArchTest
    static final ArchRule persistenceNeverDependsOnUpperLayers = noClasses()
            .that().resideInAPackage("..dao..")
            .should().dependOnClassesThat().resideInAnyPackage("..controller..", "..service..")
            .as("the persistence layer must not depend on service or controller");

    @ArchTest
    static final ArchRule noCyclesBetweenSlices = slices()
            .matching("com.github.diegopacheco.archunit.(*)..")
            .should().beFreeOfCycles()
            .as("packages must not form dependency cycles");
}
