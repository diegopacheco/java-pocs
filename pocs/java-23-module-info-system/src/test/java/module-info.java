module com.github.diegopacheco.service.test {
    // Add correct path to the main module
    requires com.github.diegopacheco.service;

    // JUnit dependencies
    requires org.junit.jupiter.api;
    requires org.junit.platform.commons;

    // Open test package to JUnit
    opens com.github.diegopacheco.service.test to org.junit.platform.commons;
}