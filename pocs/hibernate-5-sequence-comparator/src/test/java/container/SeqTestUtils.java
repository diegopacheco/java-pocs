package container;

import org.hibernate.Transaction;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.SequenceGenerator;
import org.hibernate.id.SequenceValueExtractor;

public class SeqTestUtils {

    public static long extractSequenceValue(SequenceValueExtractor sequenceValueExtractor,
                                      SessionImplementor sessionImpl) {
        return sequenceValueExtractor.extractSequenceValue( sessionImpl );
    }

    public static long generateValue(SessionImplementor sessionImpl,
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
