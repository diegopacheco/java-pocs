package container;

import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataBuildingContext;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.*;
import org.hibernate.internal.SessionImpl;
import org.hibernate.testing.boot.MetadataBuildingContextTestingImpl;
import org.hibernate.type.StandardBasicTypes;

import java.util.Properties;

public class DBContext {

    private static final String TEST_SEQUENCE = "test_sequence";

    private StandardServiceRegistry serviceRegistry;
    private SessionFactoryImplementor sessionFactory;
    private SessionImplementor sessionImpl;
    private SequenceValueExtractor sequenceValueExtractor;
    private IdentifierGenerator generator;

    public DBContext(Properties properties, IdentifierGenerator generator){

        serviceRegistry = new StandardServiceRegistryBuilder()
                .enableAutoClose()
                .applySetting( AvailableSettings.HBM2DDL_AUTO, "create-drop" )
                .build();

        MetadataBuildingContext buildingContext = new MetadataBuildingContextTestingImpl( serviceRegistry );

        properties.setProperty( SequenceGenerator.SEQUENCE, TEST_SEQUENCE );
        properties.put(
                PersistentIdentifierGenerator.IDENTIFIER_NORMALIZER,
                buildingContext.getObjectNameNormalizer()
        );
        this.generator = generator;

        generator.configure( StandardBasicTypes.LONG, properties, serviceRegistry );

        Metadata metadata = new MetadataSources( serviceRegistry ).buildMetadata();
        generator.registerExportables( metadata.getDatabase() );

        sessionFactory = (SessionFactoryImplementor) metadata.buildSessionFactory();
        generator.initialize( sessionFactory.getSqlStringGenerationContext() );
        sequenceValueExtractor = new SequenceValueExtractor( sessionFactory.getDialect(), TEST_SEQUENCE );

        sessionImpl = (SessionImpl) sessionFactory.openSession();
    }

    public void shutDown(){
        if ( sessionFactory != null ) {
            sessionFactory.close();
        }
        if ( serviceRegistry != null ) {
            StandardServiceRegistryBuilder.destroy( serviceRegistry );
        }
    }

    public long extractSequenceValue() {
        return sequenceValueExtractor.extractSequenceValue( sessionImpl );
    }

    public long generateValue() {
        Transaction transaction =  sessionImpl.beginTransaction();
        try {
            return (Long) generator.generate( sessionImpl, null );
        }
        finally {
            transaction.commit();
        }
    }

}
