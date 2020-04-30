import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Config config = (Config) o;
        return Objects.equals(appName, config.appName) &&
                Objects.equals(databaseURL, config.databaseURL) &&
                Objects.equals(schema, config.schema);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appName, databaseURL, schema);
    }
}
