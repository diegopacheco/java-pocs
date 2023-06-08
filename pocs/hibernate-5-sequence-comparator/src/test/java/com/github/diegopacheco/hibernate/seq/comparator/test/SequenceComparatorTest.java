package com.github.diegopacheco.hibernate.seq.comparator.test;

import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataBuildingContext;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.PersistentIdentifierGenerator;
import org.hibernate.id.SequenceGenerator;
import org.hibernate.id.SequenceHiLoGenerator;
import org.hibernate.id.SequenceValueExtractor;
import org.hibernate.internal.SessionImpl;
import org.hibernate.testing.boot.MetadataBuildingContextTestingImpl;
import org.hibernate.type.StandardBasicTypes;
import org.junit.jupiter.api.Test;
import java.util.Properties;
import static org.junit.Assert.assertEquals;

public class SequenceComparatorTest {

    private static final String TEST_SEQUENCE = "test_sequence";

    @Test
    public void test(){
        // Set Up
        StandardServiceRegistry serviceRegistry;
        SessionFactoryImplementor sessionFactory;
        SequenceHiLoGenerator generator;
        SessionImplementor sessionImpl;
        SequenceValueExtractor sequenceValueExtractor;

        serviceRegistry = new StandardServiceRegistryBuilder()
                .enableAutoClose()
                .applySetting( AvailableSettings.HBM2DDL_AUTO, "create-drop" )
                .build();

        MetadataBuildingContext buildingContext = new MetadataBuildingContextTestingImpl( serviceRegistry );

        Properties properties = new Properties();
        properties.setProperty( SequenceGenerator.SEQUENCE, TEST_SEQUENCE );
        properties.setProperty( SequenceGenerator.GENERATOR_NAME, "hilo" );
        properties.setProperty( SequenceHiLoGenerator.MAX_LO, "3" );
        properties.put(
                PersistentIdentifierGenerator.IDENTIFIER_NORMALIZER,
                buildingContext.getObjectNameNormalizer()
        );

        generator = new SequenceHiLoGenerator();
        generator.configure( StandardBasicTypes.LONG, properties, serviceRegistry );

        Metadata metadata = new MetadataSources( serviceRegistry ).buildMetadata();
        generator.registerExportables( metadata.getDatabase() );

        sessionFactory = (SessionFactoryImplementor) metadata.buildSessionFactory();
        generator.initialize( sessionFactory.getSqlStringGenerationContext() );
        sequenceValueExtractor = new SequenceValueExtractor( sessionFactory.getDialect(), TEST_SEQUENCE );

        int expectedGeneratedValue = 4;
        int expectedSequenceValue = 1;

        int upTo = 50;
        int checkEvery = 4;
        int currentCheck = 1;

        sessionImpl = (SessionImpl) sessionFactory.openSession();
        StringBuffer sb = new StringBuffer();
        sb.append("SequenceHiLoGenerator - Optimizer: LegacyHilo - Test for[" + upTo + "]\n\r");
        try {

            for(int i=1;i<=upTo;i++){
                assertEquals(expectedGeneratedValue, generateValue(sessionImpl,generator));
                assertEquals(expectedSequenceValue, extractSequenceValue(sequenceValueExtractor,sessionImpl));

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
            sessionImpl.close();
        }
        System.out.println(sb.toString());

        // Tear Down
        if ( sessionFactory != null ) {
            sessionFactory.close();
        }
        if ( serviceRegistry != null ) {
            StandardServiceRegistryBuilder.destroy( serviceRegistry );
        }
    }

    private long extractSequenceValue(SequenceValueExtractor sequenceValueExtractor,
                                      SessionImplementor sessionImpl) {
        return sequenceValueExtractor.extractSequenceValue( sessionImpl );
    }

    private long generateValue(SessionImplementor sessionImpl,
                               SequenceGenerator generator) {
        Transaction transaction =  sessionImpl.beginTransaction();
        try {
            return (Long) generator.generate( sessionImpl, null );
        }
        finally {
            transaction.commit();
        }
    }

}
