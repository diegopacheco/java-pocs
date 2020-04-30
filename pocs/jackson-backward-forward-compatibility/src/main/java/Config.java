public class Config {

    private String appName;
    private String databaseURL;
    private String schema;

    public Config(){}

    public String getAppName() {
        return appName;
    }
    public String getDatabaseURL() {
        return databaseURL;
    }
    public String getSchema() {
        return schema;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
    public void setDatabaseURL(String databaseURL) {
        this.databaseURL = databaseURL;
    }
    public void setSchema(String schema) {
        this.schema = schema;
    }

    @Override
    public String toString() {
        return "Config{" +
                "appName='" + appName + '\'' +
                ", databaseURL='" + databaseURL + '\'' +
                ", schema='" + schema + '\'' +
                '}';
    }
}
