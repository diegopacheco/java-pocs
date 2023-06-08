package com.github.diegopacheco.hibernate.seq.comparator.test;

import com.github.diegopacheco.hibernate.seq.comparator.container.DBContext;
import com.github.diegopacheco.hibernate.seq.comparator.diff.Diff;
import org.hibernate.boot.model.naming.ObjectNameNormalizer;
import org.hibernate.boot.spi.MetadataBuildingContext;
import org.hibernate.id.PersistentIdentifierGenerator;
import org.hibernate.id.SequenceGenerator;
import org.hibernate.id.SequenceHiLoGenerator;
import org.hibernate.id.enhanced.LegacyHiLoAlgorithmOptimizer;
import org.hibernate.id.enhanced.PooledLoOptimizer;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.testing.boot.MetadataBuildingContextTestingImpl;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class SequenceComparatorTest {

    private static final String TEST_SEQUENCE = "test_sequence";

    @Test
    public void test(){

        String leftGenerator = SequenceHiLoGenerator.class.getName();
        String leftOptimizer = LegacyHiLoAlgorithmOptimizer.class.getName();
        SequenceHiLoGenerator generator = new SequenceHiLoGenerator();
        DBContext context = new DBContext(generator);

        Properties properties = new Properties();
        properties.setProperty( SequenceGenerator.GENERATOR_NAME, "hilo" );
        properties.setProperty( SequenceHiLoGenerator.MAX_LO, "3" );
        properties.setProperty( SequenceGenerator.SEQUENCE, TEST_SEQUENCE );
        properties.put(
                PersistentIdentifierGenerator.IDENTIFIER_NORMALIZER,
                context.getMetadataBuildingContext().getObjectNameNormalizer()
        );
        context.connect(properties);

        // the seq.next value expected
        int expectedGeneratedValue = 4;

        // the seq value on the db expected
        int expectedSequenceValue = 1;

        // how far the for loop will go
        int upTo = 50;

        // when is time to check the db value
        int checkEvery = 4;

        // start value for the db value check, related to: checkEvery
        int currentCheck = 1;

        StringBuffer sbHilo = new StringBuffer();
        try {

            for(int i=1;i<=upTo;i++){
                assertEquals(expectedGeneratedValue, context.generateValue());
                assertEquals(expectedSequenceValue, context.extractSequenceValue());

                sbHilo.append("Next Value[" + expectedGeneratedValue +
                        "] DB Sequence Val[" + expectedSequenceValue +"]\n\r");

                expectedGeneratedValue++;
                if (currentCheck==checkEvery){
                    currentCheck += checkEvery;
                    expectedSequenceValue++;
                    currentCheck = 1;
                }else{
                    currentCheck++;
                }
            }

        } finally {
            context.shutDown();
        }
        System.out.println("SequenceHiLoGenerator - Optimizer: LegacyHilo - Test for[" + upTo + "]\n\r");
        System.out.println(sbHilo.toString());

        String rightGenerator = SequenceStyleGenerator.class.getName();
        String rightOptimizer = PooledLoOptimizer.class.getName();
        SequenceStyleGenerator generator2 = new SequenceStyleGenerator();
        final DBContext context2 = new DBContext(generator2);

        properties = new Properties();
        properties.setProperty( SequenceStyleGenerator.SEQUENCE_PARAM, TEST_SEQUENCE );
        properties.setProperty( SequenceGenerator.GENERATOR_NAME, "pooled_lo" );
        properties.setProperty( SequenceStyleGenerator.OPT_PARAM, PooledLoOptimizer.class.getName());
        properties.setProperty( SequenceStyleGenerator.INITIAL_PARAM, "1" );
        properties.setProperty( SequenceStyleGenerator.INCREMENT_PARAM, "4" ); // needs to be bigger than 1 or silently chooses Noop
        properties.put(
                PersistentIdentifierGenerator.IDENTIFIER_NORMALIZER,
                new ObjectNameNormalizer() {
                    @Override
                    protected MetadataBuildingContext getBuildingContext() {
                        return new MetadataBuildingContextTestingImpl( context2.getServiceRegistry() );
                    }
                }
        );
        context2.connect(properties);

        StringBuffer sbPooledLo = new StringBuffer();
        try {

            for(int i=1;i<=upTo;i++){
                long genVal = context2.generateValue();
                long seqVal = context2.extractSequenceValue();
                sbPooledLo.append("Next Value[" + genVal + "] DB Sequence Val[" + seqVal +"]\n\r");
            }

        } finally {
            context2.shutDown();
        }
        System.out.println("SequenceStyleGenerator - Optimizer: PooledLo - Test for[" + upTo + "]\n\r");
        System.out.println(sbPooledLo.toString());

        Diff diff = new Diff(sbHilo.toString(),sbPooledLo.toString(),
                leftGenerator,leftOptimizer, rightGenerator, rightOptimizer);
        diff.run();
    }

}
