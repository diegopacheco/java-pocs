package com.github.diegopacheco.liquidunit.core;

import java.util.Properties;
import java.util.regex.Pattern;

public class LiquidUnitConfig {
    private static final String CONFIG_FILE = "application.properties";

    private String dbHost;
    private int dbPort;
    private String dbName;
    private String dbUser;
    private String dbPassword;
    private Pattern assertionPattern;

    public LiquidUnitConfig() {
        this.assertionPattern = Pattern.compile("--\\s*expect\\s*:\\s*(\\d+)");
        loadProperties();
    }

    private void loadProperties() {
        Properties properties = new Properties();
        try (var input = getClass().getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                useDefaultProperties();
                return;
            }
            properties.load(input);
            dbHost = properties.getProperty("db.host", "127.0.0.1");
            dbPort = Integer.parseInt(properties.getProperty("db.port", "3306"));
            dbName = properties.getProperty("db.database", "profile");
            dbUser = properties.getProperty("db.user", "root");
            dbPassword = properties.getProperty("db.password", "pass");
        } catch (Exception e) {
            useDefaultProperties();
        }
    }

    private void useDefaultProperties() {
        dbHost = "127.0.0.1";
        dbPort = 3306;
        dbName = "profile";
        dbUser = "root";
        dbPassword = "pass";
    }

    // Getters
    public String getDbHost() { return dbHost; }
    public int getDbPort() { return dbPort; }
    public String getDbName() { return dbName; }
    public String getDbUser() { return dbUser; }
    public String getDbPassword() { return dbPassword; }
    public Pattern getAssertionPattern() { return assertionPattern; }

    public String getJdbcUrl() {
        return String.format("jdbc:mysql://%s:%d/%s", dbHost, dbPort, dbName);
    }
}