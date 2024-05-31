package com.github.diegopacheco.javapocs.suites.suites;

import com.github.diegopacheco.javapocs.suites.SubTests;
import com.github.diegopacheco.javapocs.suites.SumTests;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({
        SumTests.class,
        SubTests.class
})
@SelectPackages("com.github.diegopacheco.javapocs.mul.tests")
public class AllSuiteTests {
}
