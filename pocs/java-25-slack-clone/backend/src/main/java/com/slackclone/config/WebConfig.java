package com.slackclone.config;

import com.slackclone.auth.CurrentUserArgumentResolver;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final String mediaDir;

    public WebConfig(@Value("${app.media-dir}") String mediaDir) {
        this.mediaDir = mediaDir;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Path location = Paths.get(mediaDir).toAbsolutePath().normalize();
        registry.addResourceHandler("/media/**")
                .addResourceLocations(location.toUri().toString())
                .setCachePeriod(86400);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new CurrentUserArgumentResolver());
    }
}
