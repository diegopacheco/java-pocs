package com.github.diegopacheco.hibernate.seq.comparator.test;

import container.DBContext;
import org.hibernate.id.SequenceGenerator;
import org.hibernate.id.SequenceHiLoGenerator;
import org.junit.jupiter.api.Test;
import java.util.Properties;
import static container.SeqTestUtils.extractSequenceValue;
import static container.SeqTestUtils.generateValue;
import static org.junit.Assert.assertEquals;

public class SequenceComparatorTest {

    private static final String TEST_SEQUENCE = "test_sequence";

    @Test
    public void test(){

        Properties properties = new Properties();
        properties.setProperty( SequenceGenerator.GENERATOR_NAME, "hilo" );
        properties.setProperty( SequenceHiLoGenerator.MAX_LO, "3" );
        SequenceHiLoGenerator generator = new SequenceHiLoGenerator();
        DBContext context = new DBContext(properties,generator);

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

        StringBuffer sb = new StringBuffer();
        sb.append("SequenceHiLoGenerator - Optimizer: LegacyHilo - Test for[" + upTo + "]\n\r");
        try {

            for(int i=1;i<=upTo;i++){
                assertEquals(expectedGeneratedValue, generateValue(context.getSession(), generator));
                assertEquals(expectedSequenceValue, extractSequenceValue(context.getSequenceValueExtractor(),context.getSession()));

                sb.append("Next Value[" + expectedGeneratedValue +
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
            context.getSession().close();
            context.shutDown();
        }
        System.out.println(sb.toString());
    }

}
