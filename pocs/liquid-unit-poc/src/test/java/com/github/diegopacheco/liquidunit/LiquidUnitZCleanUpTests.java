package com.github.diegopacheco.liquidunit;

import com.github.diegopacheco.liquidunit.dao.DatabaseMigrationDAO;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@Order(100)
public class LiquidUnitZCleanUpTests {

    @Test
    public void cleanup(){}

    @AfterAll
    public static void tearDown() throws Exception {
        System.out.println("Cleaning up... ");
        DatabaseMigrationDAO dao = new DatabaseMigrationDAO();
        dao.close();
    }
}
