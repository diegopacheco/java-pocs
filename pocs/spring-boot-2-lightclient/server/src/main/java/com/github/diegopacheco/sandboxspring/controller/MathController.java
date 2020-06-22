package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.model.Op;
import com.github.diegopacheco.sandboxspring.model.Value;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {

	private Gson gson = new Gson();

	@PostMapping(path= "/sum", consumes = "application/json", produces = "application/json")
	public String sum(@RequestBody String boddy){
		Op op   = gson.fromJson(boddy,Op.class);
		Double result =  op.getVa() + op.getVb();
		Value v = new Value(result);
		String json = gson.toJson(v);
		return json;
	}

	@GetMapping(path= "/mul/{vaStr}/{vbStr}", consumes = "application/json", produces = "application/json")
	public String mul(@PathVariable String vaStr,@PathVariable String vbStr){
		Double va = Double.parseDouble(vaStr);
		Double vb = Double.parseDouble(vbStr);
		Double result = va*vb;
		return result+"";
	}

}