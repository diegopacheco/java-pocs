package com.github.diegopacheco.es.plugin.test;

import org.apache.lucene.util.LuceneTestCase;
import org.junit.Assert;

public class SimplePluginTests extends LuceneTestCase{
    public void testSimplePlugin(){
        SimplePluginTests sp = new SimplePluginTests();
        Assert.assertNotNull(sp);
   }
}
