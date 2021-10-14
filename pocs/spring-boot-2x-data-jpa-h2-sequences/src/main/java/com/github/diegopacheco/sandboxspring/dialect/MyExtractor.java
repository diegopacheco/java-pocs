package com.github.diegopacheco.sandboxspring.dialect;

import org.hibernate.tool.schema.extract.internal.SequenceInformationExtractorH2DatabaseImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyExtractor extends SequenceInformationExtractorH2DatabaseImpl {

    @Override
    protected Long resultSetMinValue(ResultSet resultSet) throws SQLException {
        String column = sequenceMinValueColumn();
        Long result = column != null ? resultSet.getBigDecimal( column ).longValue() : null;
        System.out.println("Min Seq: " + result);
        return result;
    }

    @Override
    protected Long resultSetMaxValue(ResultSet resultSet) throws SQLException {
        String column = sequenceMaxValueColumn();
        Long result = column != null ? resultSet.getBigDecimal( column ).longValue() : null;
        System.out.println("Min Seq: " + result);
        return result;
    }

}
