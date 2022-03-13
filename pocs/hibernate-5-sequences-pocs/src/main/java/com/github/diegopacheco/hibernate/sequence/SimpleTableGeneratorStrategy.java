package com.github.diegopacheco.hibernate.sequence;

import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.StandardOptimizerDescriptor;
import org.hibernate.id.enhanced.TableGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;

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