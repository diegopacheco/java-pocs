package com.github.diegopacheco.liquidunit;

import com.github.diegopacheco.liquidunit.execution.engine.LiquidUnitTests;
import org.junit.jupiter.api.Order;

//
// This class just extends form LiquidUnitTests
// I did this to be able to run the tests ans Junit so the LiquidUnitTests is the source of truth
// That way I can run Junit for tests and Runtime.
//
@Order(1)
public class LiquidUnitJunitTests extends LiquidUnitTests {}