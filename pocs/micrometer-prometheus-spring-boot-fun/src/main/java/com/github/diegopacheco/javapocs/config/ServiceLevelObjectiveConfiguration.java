package com.github.diegopacheco.javapocs.config;

import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Meter.Type;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.binder.BaseUnits;
import io.micrometer.core.instrument.config.NamingConvention;
import io.micrometer.health.HealthConfig;
import io.micrometer.health.ServiceLevelObjective;
import io.micrometer.health.objectives.JvmServiceLevelObjectives;
import io.micrometer.health.objectives.OperatingSystemServiceLevelObjectives;
import org.springframework.boot.actuate.health.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import io.micrometer.health.HealthMeterRegistry;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
public class ServiceLevelObjectiveConfiguration {
    private final GenericApplicationContext applicationContext;
    private final NamingConvention camelCasedHealthIndicatorNames = NamingConvention.camelCase;

    public ServiceLevelObjectiveConfiguration(GenericApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    HealthMeterRegistry healthMeterRegistry() {
        HealthMeterRegistry registry = HealthMeterRegistry.builder(HealthConfig.DEFAULT)
                .serviceLevelObjectives(JvmServiceLevelObjectives.MEMORY)
                .serviceLevelObjectives(OperatingSystemServiceLevelObjectives.DISK)
                .serviceLevelObjectives(
                        ServiceLevelObjective.build("api.error.ratio")
                                .failedMessage("API error ratio")
                                .baseUnit(BaseUnits.PERCENT)
                                .tag("uri.matches", "/api/**")
                                .tag("error.outcome", "SERVER_ERROR")
                                .errorRatio(
                                        s -> s.name("http.server.requests").tag("uri", uri -> uri.startsWith("/api")),
                                        all -> all.tag("outcome", "SERVER_ERROR")
                                ).isLessThan(0.01)
                )
                .build();

        for (ServiceLevelObjective slo : registry.getServiceLevelObjectives()) {
            applicationContext.registerBean(
                    camelCasedHealthIndicatorNames.name(slo.getName(), Meter.Type.GAUGE),
                    HealthContributor.class,
                    () -> toHealthContributor(registry, slo)
            );
        }

        return registry;
    }

    private HealthContributor toHealthContributor(HealthMeterRegistry registry, ServiceLevelObjective slo) {
        if (slo instanceof ServiceLevelObjective.SingleIndicator) {
            return new AbstractHealthIndicator(slo.getFailedMessage()) {
                @Override
                protected void doHealthCheck(Health.Builder builder) {
                    ServiceLevelObjective.SingleIndicator singleIndicator = (ServiceLevelObjective.SingleIndicator) slo;
                    builder.status(slo.healthy(registry) ? Status.UP : Status.OUT_OF_SERVICE)
                            .withDetail("value", singleIndicator.getValueAsString(registry))
                            .withDetail("mustBe", singleIndicator.getTestDescription());

                    for (Tag tag : slo.getTags()) {
                        builder.withDetail(camelCasedHealthIndicatorNames.tagKey(tag.getKey()), tag.getValue());
                    }

                    if (slo.getBaseUnit() != null) {
                        builder.withDetail("unit", slo.getBaseUnit());
                    }
                }
            };
        } else {
            ServiceLevelObjective.MultipleIndicator multipleIndicator = (ServiceLevelObjective.MultipleIndicator) slo;
            Map<String, HealthContributor> objectiveIndicators = Arrays.stream(multipleIndicator.getObjectives())
                    .collect(
                            Collectors.toMap(
                                    indicator -> camelCasedHealthIndicatorNames.name(indicator.getName(), Type.GAUGE),
                                    indicator -> toHealthContributor(registry, indicator)
                            )
                    );
            return CompositeHealthContributor.fromMap(objectiveIndicators);
        }
    }
}