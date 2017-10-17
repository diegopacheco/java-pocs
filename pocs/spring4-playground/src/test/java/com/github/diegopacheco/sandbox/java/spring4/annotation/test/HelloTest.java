package com.github.diegopacheco.sandbox.java.spring4.annotation.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.diegopacheco.sandbox.java.spring4.annotation.AppConfig;
import com.github.diegopacheco.sandbox.java.spring4.annotation.HelloService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class HelloTest {
	
    @Autowired
    private HelloService hs;
    
    @Test
    public void testHappyPath() {
    	Assert.assertNotNull(hs);
    	Assert.assertNotNull(hs.getMessage());
    }
    
}
