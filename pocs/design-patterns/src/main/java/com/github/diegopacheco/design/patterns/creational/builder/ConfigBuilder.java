package com.github.diegopacheco.design.patterns.creational.builder;

import java.util.Objects;

public class ConfigBuilder {

    private int port;
    private String host;
    private String path;

    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }

    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }

    public ConfigBuilder(int port, String host, String path) {
        this.port = port;
        this.host = host;
        this.path = path;
    }

    static class Builder{

        private int port;
        private String host;
        private String path;

        public static Builder standard(){
            return new Builder();
        }

        public Builder withPort(int port){
            this.port = port;
            return this;
        }

        public Builder withHost(String host){
            this.host = host;
            return this;
        }

        public Builder withPath(String path){
            this.path = path;
            return this;
        }

        public ConfigBuilder build(){
            return new ConfigBuilder(this.port,this.host,this.path);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConfigBuilder that = (ConfigBuilder) o;
        return port == that.port && Objects.equals(host, that.host) && Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(port, host, path);
    }

    @Override
    public String toString() {
        return "ConfigBuilder{" +
                "port=" + port +
                ", host='" + host + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
