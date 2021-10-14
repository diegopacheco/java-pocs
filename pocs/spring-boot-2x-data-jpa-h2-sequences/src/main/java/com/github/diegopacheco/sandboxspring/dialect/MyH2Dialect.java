package com.github.diegopacheco.sandboxspring.dialect;

import org.hibernate.dialect.H2Dialect;
import org.hibernate.tool.schema.extract.spi.SequenceInformationExtractor;

public class MyH2Dialect extends H2Dialect {

    private MyExtractor extractor = new MyExtractor();

    @Override
    public SequenceInformationExtractor getSequenceInformationExtractor() {
        return extractor;
    }
}
