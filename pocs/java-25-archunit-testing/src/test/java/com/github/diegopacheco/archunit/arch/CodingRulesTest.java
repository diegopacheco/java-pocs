package com.github.diegopacheco.archunit.arch;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noFields;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_USE_JODATIME;

@AnalyzeClasses(packages = "com.github.diegopacheco.archunit", importOptions = ImportOption.DoNotIncludeTests.class)
public class CodingRulesTest {

    @ArchTest
    static final ArchRule noFieldInjection = noFields()
            .should().beAnnotatedWith("org.springframework.beans.factory.annotation.Autowired")
            .as("use constructor injection, never @Autowired on fields");

    @ArchTest
    static final ArchRule repositoriesAreInterfaces = classes()
            .that().areAnnotatedWith(Repository.class)
            .should().beInterfaces()
            .as("Spring Data repositories must be interfaces");

    @ArchTest
    static final ArchRule controllersAreRestControllers = classes()
            .that().resideInAPackage("..controller..")
            .should().beAnnotatedWith(RestController.class)
            .as("everything in the controller package must be a @RestController");

    @ArchTest
    static final ArchRule noStandardStreams = NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS
            .as("never use System.out / System.err, log instead");

    @ArchTest
    static final ArchRule noGenericExceptions = NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS
            .as("throw specific exceptions, never raw Exception / RuntimeException / Throwable");

    @ArchTest
    static final ArchRule noJavaUtilLogging = NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING
            .as("use SLF4J, not java.util.logging");

    @ArchTest
    static final ArchRule noJodaTime = NO_CLASSES_SHOULD_USE_JODATIME
            .as("use java.time, not Joda-Time");
}
