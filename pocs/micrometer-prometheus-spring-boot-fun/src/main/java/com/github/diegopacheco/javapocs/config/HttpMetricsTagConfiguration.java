package com.github.diegopacheco.javapocs.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.diegopacheco.javapocs.model.Person;
import com.google.common.cache.CacheBuilder;
import io.micrometer.core.instrument.Tags;
import org.springframework.boot.actuate.metrics.web.servlet.DefaultWebMvcTagsProvider;
import org.springframework.boot.actuate.metrics.web.servlet.WebMvcTagsProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.util.ContentCachingResponseWrapper;
import io.micrometer.core.instrument.Tag;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.Optional;

@Configuration
public class HttpMetricsTagConfiguration {

    private final Map<HttpServletResponse, Tags> responseTags = CacheBuilder.newBuilder()
            .maximumSize(10_000)
            .expireAfterWrite(Duration.ofSeconds(10))
            .<HttpServletResponse, Tags>build()
            .asMap();

    @Bean
    OncePerRequestFilter extractCountry() {
        return new OncePerRequestFilter() {
            private final ObjectMapper mapper = new ObjectMapper();

            @Override
            protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain filterChain) throws ServletException, IOException {
                ContentCachingResponseWrapper cached = new ContentCachingResponseWrapper(response);
                filterChain.doFilter(request, cached);

                Object path = request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
                if (path.equals("/api/person/{id}")) {
                    // Prometheus requires the same tags on all `http.server.requests`. So we'll need to add
                    // a `@Timed("person.requests") to the /api/person/{id} endpoint so it has a different name.
                    Person person = mapper.readValue(cached.getContentAsByteArray(), Person.class);
                    responseTags.put(response, Tags.of("country", person.getCountry()));
                }

                cached.copyBodyToResponse();
            }
        };
    }

    @Bean
    WebMvcTagsProvider webMvcTagsProvider() {
        return new DefaultWebMvcTagsProvider() {
            @Override
            public Iterable<Tag> getTags(HttpServletRequest request, HttpServletResponse response,
                                         Object handler, Throwable exception) {
                return Tags.concat(
                        super.getTags(request, response, handler, exception),
                        Optional.ofNullable(responseTags.remove(response)).orElse(Tags.empty())
                );
            }
        };
    }
}
