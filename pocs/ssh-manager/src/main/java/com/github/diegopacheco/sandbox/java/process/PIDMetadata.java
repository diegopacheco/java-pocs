package com.github.diegopacheco.sandbox.java.process;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Metadata around any PID that we run in linux in order to figure it out whats going on.
 * 
 * @author diegopacheco
 *
 */
public class PIDMetadata {
	
	private String ownerID;
	private BigDecimal pid;
	private String pidFile;
	private Date timestamp;  
	private String logFile;
	private ProcessChecker checker;
	
	public PIDMetadata() {}
	
	public PIDMetadata(String ownerID, BigDecimal pid, String pidFile, Date timestamp, String logFile) {
		super();
		this.ownerID = ownerID;
		this.pid = pid;
		this.pidFile = pidFile;
		this.timestamp = timestamp;
		this.logFile = logFile;
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
	public String getPidFile() {
		return pidFile;
	}
	public void setPidFile(String pidFile) {
		this.pidFile = pidFile;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getLogFile() {
		return logFile;
	}
	public void setLogFile(String logFile) {
		this.logFile = logFile;
	}
	
	public ProcessChecker getChecker() {
		return checker;
	}
	public void setChecker(ProcessChecker checker) {
		this.checker = checker;
	}

	@Override
	public String toString() {
		return "PIDMetadata [ownerID=" + ownerID + ", pid=" + pid + ", pidFile=" + pidFile + ", timestamp=" + timestamp
		    + ", logFile=" + logFile + "]";
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
