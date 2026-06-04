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
public class NamingConventionTest {

    @ArchTest
    static final ArchRule servicesAreNamedService = classes()
            .that().areAnnotatedWith(Service.class)
            .should().haveSimpleNameEndingWith("Service")
            .as("@Service classes must be named *Service");

    @ArchTest
    static final ArchRule controllersAreNamedController = classes()
            .that().areAnnotatedWith(RestController.class).or().areAnnotatedWith(Controller.class)
            .should().haveSimpleNameEndingWith("Controller")
            .as("controllers must be named *Controller");

    @ArchTest
    static final ArchRule repositoriesAreNamedRepository = classes()
            .that().areAnnotatedWith(Repository.class)
            .should().haveSimpleNameEndingWith("Repository")
            .as("@Repository classes must be named *Repository");

    @ArchTest
    static final ArchRule configsAreNamedConfig = classes()
            .that().areAnnotatedWith(Configuration.class)
            .should().haveSimpleNameEndingWith("Config")
            .orShould().haveSimpleNameEndingWith("Configuration")
            .as("@Configuration classes must be named *Config or *Configuration");
}
