package com.github.diegopacheco.javapocs.pitest.service;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("com.github.diegopacheco.javapocs.pitest.service")
@IncludePackages("com.github.diegopacheco.javapocs.pitest.service")
public class PiTestSuiteTest {}