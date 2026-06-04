package com.github.diegopacheco.archunit.arch;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.github.diegopacheco.archunit", importOptions = ImportOption.DoNotIncludeTests.class)
public class PackageConventionTest {

    @ArchTest
    static final ArchRule servicesLiveInServicePackage = classes()
            .that().areAnnotatedWith(Service.class)
            .should().resideInAPackage("..service..")
            .as("@Service classes must live in the 'service' package");

    @ArchTest
    static final ArchRule repositoriesLiveInDaoPackage = classes()
            .that().areAnnotatedWith(Repository.class)
            .should().resideInAPackage("..dao..")
            .as("@Repository classes must live in the 'dao' package");

    @ArchTest
    static final ArchRule controllersLiveInControllerPackage = classes()
            .that().areAnnotatedWith(RestController.class).or().areAnnotatedWith(Controller.class)
            .should().resideInAPackage("..controller..")
            .as("@Controller / @RestController classes must live in the 'controller' package");

    @ArchTest
    static final ArchRule configsLiveInConfigPackage = classes()
            .that().areAnnotatedWith(Configuration.class)
            .should().resideInAPackage("..config..")
            .as("@Configuration classes must live in the 'config' package");

    @ArchTest
    static final ArchRule servicePackageHoldsOnlyServices = classes()
            .that().resideInAPackage("..service..")
            .should().beAnnotatedWith(Service.class)
            .as("every class in the 'service' package must be a @Service");

    @ArchTest
    static final ArchRule configPackageHoldsOnlyConfigs = classes()
            .that().resideInAPackage("..config..")
            .should().beAnnotatedWith(Configuration.class)
            .as("every class in the 'config' package must be a @Configuration");
}
