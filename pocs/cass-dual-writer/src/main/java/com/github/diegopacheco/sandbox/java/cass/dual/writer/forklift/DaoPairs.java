package com.github.diegopacheco.sandbox.java.cass.dual.writer.forklift;

import com.github.diegopacheco.sandbox.java.cass.dual.writer.dao.CassDAO;

public class DaoPairs {
	
	private CassDAO from;
	private CassDAO to;
	
	public DaoPairs(CassDAO from, CassDAO to) {
		super();
		this.from = from;
		this.to = to;
	}

	public CassDAO getFrom() {
		return from;
	}
	public void setFrom(CassDAO from) {
		this.from = from;
	}
	
	public CassDAO getTo() {
		return to;
	}
	public void setTo(CassDAO to) {
		this.to = to;
	}
	
}
