package com.github.diegopacheco.audible.fun;

import com.nfl.dm.audible.MappingType;
import com.nfl.dm.audible.service.DomainMapper;
import com.nfl.dm.audible.service.DomainMapperBuilder;
import com.nfl.dm.audible.service.MappingService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.github.diegopacheco.audible.fun"})
public class ApplicationConfig {

    @Bean
    public MappingService domainService() {
        return new MappingService();
    }

    @Bean
    public DomainMapper domainMapper() {
        return new DomainMapperBuilder().setAutoMapUsingOrika(true)
        								.setDefaultEmbeddedMapping(MappingType.EMBEDDED)
        								.setParallelProcessEmbeddedList(true)
        								.build();
    }

}