package com.github.diegopacheco.audible.fun;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import com.nfl.dm.audible.annotation.Mapping;
import com.nfl.dm.audible.annotation.MappingTo;

import org.springframework.stereotype.Component;

@Component
@MappingTo(ToCourse.class)
public class ToCourseMapping {

	@Mapping(originalClass = FromCourse.class)
	public Map<String, Function<FromCourse, ?>> getMapping() {
		Map<String, Function<FromCourse, ?>> map = new HashMap<>();
		map.put("name", (FromCourse fc) -> parseCourseTitle(fc.getName()));
		map.put("courseNum", (FromCourse fc) -> parseCourseNumber(fc.getName()));
		map.put("gpa", (FromCourse fc) -> parseGrade(fc.getLetterGrade()));
		return map;
	}
	
	public String parseGrade(String letterGrade) {
		if(letterGrade.equals("A")) return Integer.valueOf(4) + "";
			else if(letterGrade.equals("B")) return Integer.valueOf(3) + "";
			else if(letterGrade.equals("C")) return Integer.valueOf(2) + "";
			else if(letterGrade.equals("D")) return Integer.valueOf(1) + "";
			else if(letterGrade.equals("F")) return Integer.valueOf(0) + "";
		return new String("0");
	}

	public String parseCourseTitle(String name) {
        return name;
	}
	
	public String parseCourseNumber(String name) {
        return name;
	}
}