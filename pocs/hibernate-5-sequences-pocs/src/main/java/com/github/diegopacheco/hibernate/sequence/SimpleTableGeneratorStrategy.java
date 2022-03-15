package com.github.diegopacheco.hibernate.sequence;

import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.StandardOptimizerDescriptor;
import org.hibernate.id.enhanced.TableGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;

/**
 *  The pool starts at 100.
 *
 *  Hibernate 5.6 logs:
 *
 * table=my_table_sequence,
 *  pkColumnName=name,
 *  valueColumnName=value,
 *  pkColumnValue=my_seq_val_seq,
 *  allocationSize=null
 *
 * using Optimizer => POOLED_LO
 * Ignoring increment size of 1 using minimum of 100
 *
 *
 * mysql> select * from my_table_sequence;
 * +----------------+-------+
 * | name           | value |
 * +----------------+-------+
 * | my_seq_val_seq |   100 |
 * +----------------+-------+
 * 1 row in set (0,00 sec)
 *
 *  ID started at 1
 *
 * mysql> select * from Contact;
 * +----+--------------------------+---------+--------------+
 * | id | email                    | name    | phone        |
 * +----+--------------------------+---------+--------------+
 * |  1 | contant_email0@gmail.com | Person0 | 415-1234-120 |
 * |  2 | contant_email1@gmail.com | Person1 | 415-1234-121 |
 * |  3 | contant_email2@gmail.com | Person2 | 415-1234-122 |
 * |  4 | contant_email3@gmail.com | Person3 | 415-1234-123 |
 * |  5 | contant_email4@gmail.com | Person4 | 415-1234-124 |
 * |  6 | contant_email5@gmail.com | Person5 | 415-1234-125 |
 * |  7 | contant_email6@gmail.com | Person6 | 415-1234-126 |
 * |  8 | contant_email7@gmail.com | Person7 | 415-1234-127 |
 * |  9 | contant_email8@gmail.com | Person8 | 415-1234-128 |
 * | 10 | contant_email9@gmail.com | Person9 | 415-1234-129 |
 * +----+--------------------------+---------+--------------+
 * 10 rows in set (0,00 sec)
 *
 */
public class SimpleTableGeneratorStrategy extends TableGenerator {

    private static final int MIN_INC = 100;

    public SimpleTableGeneratorStrategy() {}

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
        System.out.println( String.format("table=%1$s,\n pkColumnName=%2$s,\n valueColumnName=%3$s,\n" +
                        " pkColumnValue=%4$s,\n allocationSize=%5$s\n",
                params.getProperty(TABLE_PARAM),
                params.getProperty(SEGMENT_COLUMN_PARAM),
                params.getProperty(VALUE_COLUMN_PARAM),
                params.getProperty(SEGMENT_VALUE_PARAM),
                params.getProperty(INCREMENT_PARAM)));
        System.out.println("using Optimizer => " + StandardOptimizerDescriptor.POOLED_LO);
        params.setProperty(OPT_PARAM, StandardOptimizerDescriptor.POOLED_LO.getExternalName());
        super.configure(type, params, serviceRegistry);
    }

    @Override
    protected int determineIncrementSize(Properties params) {
        int incValue = super.determineIncrementSize(params);
        if (incValue < MIN_INC) {
            System.out.println("Ignoring increment size of " + incValue + " using minimum of " + MIN_INC);
            incValue = MIN_INC;
        }
        return incValue;
    }

    // Hibernate 5.6 starts at 1 (if add this code Id will start at 2)
    /*
    public Serializable generate(final SharedSessionContractImplementor session, final Object obj) {
        Serializable result = super.generate(session,obj);
        Long newResult = ((Long)result)+1;
        return newResult;
    }
    */
}