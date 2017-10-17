package com.github.diegopacheco.sandbox.java.proxy;

import java.io.BufferedReader;
import java.io.InputStream;

public class ConnectionHelper {
	
	private BufferedReader br;
	private InputStream is;
	
	public ConnectionHelper() {
	}

	public ConnectionHelper(BufferedReader br, InputStream is) {
		super();
		this.br = br;
		this.is = is;
	}

	public BufferedReader getBr() {
		return br;
	}

	public void setBr(BufferedReader br) {
		this.br = br;
	}

	public InputStream getIs() {
		return is;
	}

	public void setIs(InputStream is) {
		this.is = is;
	}
	
	
}
