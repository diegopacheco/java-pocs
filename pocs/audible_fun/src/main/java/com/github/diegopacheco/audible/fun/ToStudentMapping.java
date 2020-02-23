package com.github.diegopacheco.audible.fun;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import com.nfl.dm.audible.annotation.Mapping;
import com.nfl.dm.audible.annotation.MappingTo;
import com.nfl.dm.audible.annotation.PostProcessor;

import org.springframework.stereotype.Component;

@Component
@MappingTo(ToStudent.class)
public class ToStudentMapping {

    @Mapping(originalClass = FromStudent.class)
    public Map<String, Function<FromStudent, ?>> getMapping() {
        Map<String, Function<FromStudent, ?>> map = new HashMap<>();
        map.put("firstName", (FromStudent s) -> s.getName().split(" ")[0]);
        map.put("lastName", (FromStudent s) -> s.getName().split(" ")[1]);

        return map;
    }

    @PostProcessor(originalClass = FromStudent.class)
	public void postProcess(ToStudent toStudent, FromStudent fromStudent) {
		toStudent.setSomeField(doSomethingThatRequiresToStudent(toStudent.getFirstName()));
	}

    private Object doSomethingThatRequiresToStudent(String firstName) {
        return firstName.toUpperCase() + "*";
    }
    
}