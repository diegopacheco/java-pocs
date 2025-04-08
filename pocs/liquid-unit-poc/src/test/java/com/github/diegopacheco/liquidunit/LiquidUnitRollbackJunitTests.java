package com.github.diegopacheco.liquidunit;

import com.github.diegopacheco.liquidunit.execution.engine.LiquidUnitRollbackTests;
import org.junit.jupiter.api.Order;

//
// This class just extends form LiquidUnitRollbackTests
// I did this to be able to run the tests ans Junit so the LiquidUnitRollbackTests is the source of truth
// That way I can run Junit for tests and Runtime.
//
@Order(2)
public class LiquidUnitRollbackJunitTests extends LiquidUnitRollbackTests {}