package com.github.diegopacheco.java.sandbox.java8.lambok;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public
	@Data
class SimplePojo {
	
	private @Getter final String name;
	private @Getter final double salary = 2.0;
	
	private @Getter @Setter String country;  

}
