package com.github.diegopacheco.sandboxspring.config;

import org.springframework.boot.web.embedded.tomcat.TomcatReactiveWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Not used on the benchmarks
 */
@Configuration
public class TomcatWebFluxConfig {

    @Bean
    public WebServerFactoryCustomizer<TomcatReactiveWebServerFactory> tomcatCustomizer() {
        return factory -> factory.addConnectorCustomizers(connector -> {
            /*
                connector.setProperty("maxThreads", "600");
                connector.setProperty("minSpareThreads", "50");
                connector.setProperty("maxConnections", "8192");
                connector.setProperty("connectionTimeout", "20000");
                connector.setProperty("keepAliveTimeout", "60000");
                connector.setProperty("maxKeepAliveRequests", "200");
                connector.setProperty("compression", "on");
                connector.setProperty("compressionMinSize", "1048");
                connector.setProperty("compressableMimeType", "text/html,text/xml,text/plain,text/css,text/javascript,application/javascript,application/json");
             */
        });
    }
}
