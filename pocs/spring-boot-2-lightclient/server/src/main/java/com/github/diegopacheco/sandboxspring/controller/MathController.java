package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.model.Op;
import com.github.diegopacheco.sandboxspring.model.Value;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import org.xerial.snappy.Snappy;

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

	@PostMapping(path= "/sub", consumes = "application/json", produces = "application/json")
	public String sub(@RequestBody String boddy){
		String[] data = boddy.split(",");
		Double va = Double.parseDouble(data[0]);
		Double vb = Double.parseDouble(data[1]);
		Double result =  va - vb;
		return result+"";
	}

	@PostMapping(path= "/echo", consumes = "application/json", produces = "application/json")
	public String echo(@RequestBody String boddy){
		try{
			byte[] rawBytes = boddy.getBytes("UTF-8");
			byte[] raw = Snappy.uncompress(rawBytes);
			String str = new String(raw,"UTF-8");
			byte[] compressed = Snappy.compress(str.getBytes("UTF-8"));
			return new String(compressed, "UTF-8");
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

}