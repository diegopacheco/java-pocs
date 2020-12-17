package com.github.diegopacheco.sandboxspring.tests;

import com.github.diegopacheco.sandboxspring.config.SpringBeansConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringBeansConfig.class,properties = {"otherMessage=dude my friend!"})
public class SpringBootForValueTest {

    @Autowired
    @Qualifier("message")
    String message;

    @Value("${otherMessage:man}")
    String otherMessage;

    @Test
    public void shouldGreetOk(){
        assertEquals("hi my friend!",message);
        System.out.println(message);
    }

    @Test
    public void shouldGreetOkCustomTest(){
        assertEquals("dude my friend!",otherMessage);
        System.out.println(otherMessage);
    }

}
