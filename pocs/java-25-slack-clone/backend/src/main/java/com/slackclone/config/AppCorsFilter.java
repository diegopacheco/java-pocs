package com.slackclone.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AppCorsFilter extends CorsFilter {

    public AppCorsFilter(@Value("${app.cors-origins}") String origins) {
        super(source(origins));
    }

    private static UrlBasedCorsConfigurationSource source(String origins) {
        CorsConfiguration config = new CorsConfiguration();
        for (String origin : origins.split(",")) {
            config.addAllowedOrigin(origin.trim());
        }
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.setAllowCredentials(false);
        UrlBasedCorsConfigurationSource src = new UrlBasedCorsConfigurationSource();
        src.registerCorsConfiguration("/**", config);
        return src;
    }
}
