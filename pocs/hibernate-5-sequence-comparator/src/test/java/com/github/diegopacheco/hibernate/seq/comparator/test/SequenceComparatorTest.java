package com.github.diegopacheco.hibernate.seq.comparator.test;

import com.github.diegopacheco.hibernate.seq.comparator.diff.Diff;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.SequenceGenerator;
import org.hibernate.id.SequenceHiLoGenerator;
import org.hibernate.id.enhanced.LegacyHiLoAlgorithmOptimizer;
import org.hibernate.id.enhanced.PooledLoOptimizer;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.junit.jupiter.api.Test;

import java.util.Properties;

public class SequenceComparatorTest {

    private static final String TEST_SEQUENCE = "test_sequence";

    @Test
    public void test() {

        String leftOptimizer = LegacyHiLoAlgorithmOptimizer.class.getName();
        IdentifierGenerator leftGenerator = new SequenceHiLoGenerator();

        Properties leftProperties = new Properties();
        leftProperties.setProperty(SequenceGenerator.GENERATOR_NAME, "hilo");
        leftProperties.setProperty(SequenceHiLoGenerator.MAX_LO, "3");
        leftProperties.setProperty(SequenceGenerator.SEQUENCE, TEST_SEQUENCE);

        String rightOptimizer = PooledLoOptimizer.class.getName();
        IdentifierGenerator rightGenerator = new SequenceStyleGenerator();

        Properties rightProperties = new Properties();
        rightProperties.setProperty(SequenceStyleGenerator.SEQUENCE_PARAM, TEST_SEQUENCE);
        rightProperties.setProperty(SequenceGenerator.GENERATOR_NAME, "pooled_lo");
        rightProperties.setProperty(SequenceStyleGenerator.OPT_PARAM, PooledLoOptimizer.class.getName());
        rightProperties.setProperty(SequenceStyleGenerator.INITIAL_PARAM, "1");
        rightProperties.setProperty(SequenceStyleGenerator.INCREMENT_PARAM, "4"); // needs to be bigger than 1 or silently chooses Noop

        Diff diff = new Diff(leftOptimizer, leftProperties, leftGenerator,
                rightOptimizer, rightProperties, rightGenerator);
        diff.run();
    }

}
