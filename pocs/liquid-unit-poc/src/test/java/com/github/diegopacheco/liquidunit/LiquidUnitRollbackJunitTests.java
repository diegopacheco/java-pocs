package com.github.diegopacheco.liquidunit;

import java.io.FileInputStream;
import java.sql.ResultSet;
import java.util.regex.Pattern;

//
// This class just extends form LiquidUnitRollbackTests
// I did this to be able to run the tests ans Junit so the LiquidUnitRollbackTests is the source of truth
// That way I can run Junit for tests and Runtime.
//
public class LiquidUnitRollbackJunitTests extends LiquidUnitRollbackTests {}