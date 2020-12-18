package com.github.diegopacheco.sandboxspring.test;

import com.github.diegopacheco.sandboxspring.service.DateService;
import com.github.diegopacheco.sandboxspring.service.ExtendedDateService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = MockTests.ConfigBeans.class)
public class MockTests {

    @Autowired
    @Qualifier("ds1")
    DateService ds;

    @InjectMocks // requires @ExtendWith(MockitoExtension.class)
    @Qualifier("ds2")
    ExtendedDateService ds2;

    @Configuration
    static class ConfigBeans{
        @MockBean
        @Qualifier("ds1")
        DateService ds;

        @Mock
        @Qualifier("ds2")
        DateService ds2;
    }

    @Test
    public void testWithMocks(){
        assertNotNull(ds);
        System.out.println(ds);

        assertNotNull(ds2);
        System.out.println(ds2);
    }

}
