package com.github.diegopacheco.javapocs.model.test;

import org.junit.jupiter.api.Test;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void test() {
        User user = new User();
        user.setName("12345678912");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        for (ConstraintViolation v : violations) {
            String key = "";
            if (v.getPropertyPath() != null) {
                key = v.getPropertyPath().toString();
                assertEquals("name", key);
                assertEquals("size must be between 0 and 10", v.getMessage());
            }
        }
        assertEquals(1, violations.size());
    }

}
