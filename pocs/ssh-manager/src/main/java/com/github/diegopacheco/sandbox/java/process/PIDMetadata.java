package com.github.diegopacheco.sandbox.java.process;

import java.math.BigDecimal;
import java.util.Date;

import com.github.diegopacheco.sandbox.java.ssh.monad.Either;

/**
 * Metadata around any PID that we run in linux in order to figure it out whats going on.
 * 
 * @author diegopacheco
 *
 */
public class PIDMetadata {
	
	private String ownerID;
	private BigDecimal pid;
	private Date timestamp;  
	private ProcessChecker checker;
	private Either<String,String> processResult;
	
	public PIDMetadata() {}
	
	public PIDMetadata(String ownerID, BigDecimal pid, Date timestamp, String logFile) {
		super();
		this.ownerID = ownerID;
		this.pid = pid;
		this.timestamp = timestamp;
	}
	
	public String getOwnerID() {
		return ownerID;
	}
	public void setOwnerID(String ownerID) {
		this.ownerID = ownerID;
	}
	public BigDecimal getPid() {
		return pid;
	}
	public void setPid(BigDecimal pid) {
		this.pid = pid;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public ProcessChecker getChecker() {
		return checker;
	}
	public void setChecker(ProcessChecker checker) {
		this.checker = checker;
	}
	
	public Either<String,String> getProcessResult() {
		return processResult;
	}
	public void setProcessResult(Either<String,String> processResult) {
		this.processResult = processResult;
	}

	@Override
	public String toString() {
		return "PIDMetadata [ownerID=" + ownerID + ", pid=" + pid + ", timestamp=" + timestamp + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pid == null) ? 0 : pid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PIDMetadata other = (PIDMetadata) obj;
		if (pid == null) {
			if (other.pid != null)
				return false;
		} else if (!pid.equals(other.pid))
			return false;
		return true;
	}
	
}
