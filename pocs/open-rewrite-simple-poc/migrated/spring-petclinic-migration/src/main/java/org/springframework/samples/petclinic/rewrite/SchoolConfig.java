package org.springframework.samples.petclinic.rewrite;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchoolConfig {
        /** Purposely misaligned to cause auto-formatting.
         * {@link}
         * {@link DogSchool
         * {@link DogSchool()}
         * {@link
         *      DogSchool}
         */
    @Bean
    public DogSchool dogSchool() {
        return new DogSchool();
    }

        /**
         * <a href="
         * https://...html">
         * label</a>.
         */
    @Bean
    public CatSchool catSchool() {
        return new CatSchool();
    }

        /**
         */
    @Bean
    @ConditionalOnBean({CatSchool.class, DogSchool.class})
    public VetSchool vetSchool() {
        return new VetSchool();
    }
}
