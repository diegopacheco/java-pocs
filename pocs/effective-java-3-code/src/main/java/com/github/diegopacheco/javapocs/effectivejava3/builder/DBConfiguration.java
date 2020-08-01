package com.github.diegopacheco.javapocs.effectivejava3.builder;

public class DBConfiguration {

    private int port;
    private String host;
    private String schema;
    private String db;
    private String az;
    private String engine;

    private DBConfiguration(){}

    public static class Builder{
        // Required
        private final int port;
        private final String host;
        // Optional
        private String schema = "default";
        private String db = "default";
        private String az = "us-west-2";
        private String engine = "mysql";

        public Builder(int port,String host){
            this.port = port;
            this.host = host;
        }

        public Builder withSchema(String schema){
            this.schema = schema;
            return this;
        }

        public Builder withDB(String db){
            this.db = db;
            return this;
        }

        public Builder withAZ(String az){
            this.az = az;
            return this;
        }

        public Builder withEngine(String engine){
            this.engine = engine;
            return this;
        }

        public DBConfiguration build(){
            return new DBConfiguration(this);
        }

    }

    public DBConfiguration(Builder builder) {
        this.port = builder.port;
        this.host = builder.host;
        this.schema = builder.schema;
        this.db = builder.db;
        this.az = builder.az;
        this.engine = builder.engine;
    }

    public int getPort() {
        return port;
    }
    public String getHost() {
        return host;
    }
    public String getSchema() {
        return schema;
    }
    public String getDb() {
        return db;
    }
    public String getAz() {
        return az;
    }
    public String getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        return "DBConfiguration{" +
                "port=" + port +
                ", host='" + host + '\'' +
                ", schema='" + schema + '\'' +
                ", db='" + db + '\'' +
                ", az='" + az + '\'' +
                ", engine='" + engine + '\'' +
                '}';
    }
}
