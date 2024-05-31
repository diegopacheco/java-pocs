package com.github.diegopacheco.javapocs.suites.suites;

import com.github.diegopacheco.javapocs.suites.SubTests;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({
        SubTests.class
})
public class JustSubSuiteTests {
}
