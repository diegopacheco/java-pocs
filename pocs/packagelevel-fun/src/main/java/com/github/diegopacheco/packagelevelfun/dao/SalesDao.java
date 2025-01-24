package com.github.diegopacheco.packagelevelfun.dao;

import com.github.diegopacheco.packagelevelfun.logger.SecureConsoleLogger;

import java.util.Map;

public class SalesDao {
    public String getBestSalesManSSN(){
        String ssn = "123-45-6789";
        SecureConsoleLogger.debugPrint(Map.of("ssn",ssn));
        return ssn;
    }
}
