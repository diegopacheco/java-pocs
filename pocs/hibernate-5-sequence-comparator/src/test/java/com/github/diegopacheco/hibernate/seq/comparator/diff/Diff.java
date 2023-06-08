package com.github.diegopacheco.hibernate.seq.comparator.diff;

import com.github.diegopacheco.hibernate.seq.comparator.container.DBContext;
import org.hibernate.boot.model.naming.ObjectNameNormalizer;
import org.hibernate.boot.spi.MetadataBuildingContext;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.IdentityGenerator;
import org.hibernate.id.PersistentIdentifierGenerator;
import org.hibernate.testing.boot.MetadataBuildingContextTestingImpl;

import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class Diff {

    private String left;
    private String right;

    private String leftOptimizer;
    private Properties leftProperties;
    private IdentifierGenerator leftGenerator;

    private String rightOptimizer;
    private Properties rightProperties;
    private IdentifierGenerator rightGenerator;

    public Diff(String leftOptimizer, Properties leftProperties, IdentifierGenerator leftGenerator,
                String rightOptimizer, Properties rightProperties, IdentifierGenerator rightGenerator) {
        this.leftOptimizer = leftOptimizer;
        this.leftProperties = leftProperties;
        this.leftGenerator = leftGenerator;
        this.rightOptimizer = rightOptimizer;
        this.rightProperties = rightProperties;
        this.rightGenerator = rightGenerator;
    }

    public void run(){

        StringBuffer leftBuffer = execute(leftProperties,leftGenerator);
        StringBuffer rightBuffer = execute(rightProperties,rightGenerator);
        this.left = leftBuffer.toString();
        this.right = rightBuffer.toString();

        System.out.println("***** DIFF ***** ");
        System.out.println(">>> LEFT: generator[" + leftGenerator +"] optimizer["+leftOptimizer+"]");
        System.out.println(left);
        System.out.println("<<< RIGHT: generator[" + rightGenerator +"] optimizer["+rightOptimizer+"]");
        System.out.println(right);
        System.out.println("***** DIFF ***** ");

        assertEquals(left,right);
    }

    private StringBuffer execute(Properties properties, IdentifierGenerator generator){
        DBContext context = new DBContext(generator);
        properties.put(
                PersistentIdentifierGenerator.IDENTIFIER_NORMALIZER,
                context.getMetadataBuildingContext().getObjectNameNormalizer()
        );
        context.connect(properties);

        int upTo = 50;
        StringBuffer buffer = new StringBuffer();
        try {
            for(int i=1;i<=upTo;i++){
                long nextVal = context.generateValue();
                long seqVal = context.extractSequenceValue();

                buffer.append("Next Value[" + nextVal +
                        "] DB Sequence Val[" + seqVal +"]\n\r");
            }
        } finally {
            context.shutDown();
        }
        return buffer;
    }

}
