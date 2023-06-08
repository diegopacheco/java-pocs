package org.hibernate.id;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.dialect.*;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.exception.GenericJDBCException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.hibernate.jdbc.Work;

public class SequenceValueExtractor {

    private final Dialect dialect;
    private final String queryString;

    public SequenceValueExtractor(Dialect dialect, String sequenceName) {
        this.dialect = dialect;
        if ( dialect instanceof DerbyDialect ) {
            queryString = "VALUES SYSCS_UTIL.SYSCS_PEEK_AT_SEQUENCE('HIBERNATE_ORM_TEST', '" + sequenceName.toUpperCase() + "')";
        }
        else if ( dialect instanceof DB2Dialect) {
            queryString = "values PREVIOUS value for " + sequenceName;
        }
        else if ( dialect instanceof Oracle8iDialect ) {
            queryString = "select " + sequenceName + ".currval from dual";
        }
        else if ( dialect instanceof SQLServer2012Dialect ) {
            queryString = "SELECT CONVERT(varchar(200), Current_value) FROM sys.sequences WHERE name = '" + sequenceName + "'";
        }
        else if ( dialect instanceof HSQLDialect ) {

            queryString = "call current value for " + sequenceName;
        }
        else if ( dialect instanceof AbstractHANADialect) {

            queryString = "select " + sequenceName + ".currval from sys.dummy";
        }
        else if ( dialect instanceof MariaDB103Dialect) {

            queryString = "select LASTVAL(" + sequenceName + ")";
        }
        else {
            queryString = "select currval('" + sequenceName + "');";
        }
    }

    public long extractSequenceValue(final SessionImplementor sessionImpl) {
        class WorkImpl implements Work {
            private long value;

            public void execute(Connection connection) throws SQLException {
                Session session = (Session) sessionImpl;
                Transaction transaction = session.beginTransaction();
                try {
                    final PreparedStatement query = sessionImpl.getJdbcCoordinator()
                            .getStatementPreparer()
                            .prepareStatement( queryString );
                    ResultSet resultSet = sessionImpl.getJdbcCoordinator().getResultSetReturn().extract( query );
                    resultSet.next();
                    value = resultSet.getLong( 1 );

                    resultSet.close();
                    transaction.commit();
                }catch (GenericJDBCException e){
                    transaction.rollback();
                    throw e;
                }
                if ( dialect instanceof DerbyDialect) {
                    value--;
                }
            }
        }
        WorkImpl work = new WorkImpl();
        ((Session) sessionImpl).doWork( work );
        return work.value;
    }

}
