package com.github.diegopacheco.packagelevelfun.dao;

import com.github.diegopacheco.packagelevelfun.logger.SecureConsoleLogger;

import java.util.Map;

public class PersonDAO {
    public String getPersonName(){
        String name = "Diego Pacheco";
        SecureConsoleLogger.debugPrint(Map.of("name",name));
        return name;
    }
}
