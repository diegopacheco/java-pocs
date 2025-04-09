package com.github.diegopacheco.liquidunit;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import com.github.diegopacheco.liquidunit.junit.LiquidUnitTests;

@TestInstance(Lifecycle.PER_CLASS)
public class MyMigrationTests extends LiquidUnitTests {
    // All test methods are inherited from LiquidUnitTests
}