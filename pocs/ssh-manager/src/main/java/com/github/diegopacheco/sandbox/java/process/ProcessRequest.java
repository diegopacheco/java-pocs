package com.github.diegopacheco.sandbox.java.process;

/**
 * ProcessRequest represents a request to schdule a SHELL command to be executed.
 * 
 * @author diegopacheco
 *
 */
public class ProcessRequest {
	
	private String name;
	private String cmd;
	private ProcessChecker checker;
	
	public ProcessRequest(){}
	
	public ProcessRequest(String name, String cmd, ProcessChecker checker) {
		super();
		this.name = name;
		this.cmd = cmd;
		this.checker = checker;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public ProcessChecker getChecker() {
		return checker;
	}
	public void setChecker(ProcessChecker checker) {
		this.checker = checker;
	}

	@Override
	public String toString() {
		return "ProcessRequest [name=" + name + ", cmd=" + cmd + ", checker=" + checker + "]";
	}
	
}
