package com.github.diegopacheco.sandbox.java.cass.dual.writer.core.forklift;

import java.util.concurrent.atomic.AtomicInteger;

public class ForkLiftExecutionMetric {
	
	private Integer fromCount;
	private Integer toCount;
	
	private String fromDaoName;
	private String toDaoName;
	
	private Long startTime;
	private Long finishTime;
	private Long totalTime;
	private String totalTimeAsString;
	
	private AtomicInteger pending = new AtomicInteger(0);
	
	public ForkLiftExecutionMetric() {}
	
	public ForkLiftExecutionMetric(Integer fromCount, Integer toCount, String fromDaoName, String toDaoName,
	    Long startTime, Long finishTime, Long totalTime) {
		super();
		this.fromCount = fromCount;
		this.toCount = toCount;
		this.fromDaoName = fromDaoName;
		this.toDaoName = toDaoName;
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.totalTime = totalTime;
	}

	public Integer getFromCount() {
		return fromCount;
	}
	public void setFromCount(Integer fromCount) {
		this.fromCount = fromCount;
	}
	
	public Integer getToCount() {
		return toCount;
	}
	public void setToCount(Integer toCount) {
		this.toCount = toCount;
	}
	
	public String getFromDaoName() {
		return fromDaoName;
	}
	public void setFromDaoName(String fromDaoName) {
		this.fromDaoName = fromDaoName;
	}
	
	public String getToDaoName() {
		return toDaoName;
	}
	public void setToDaoName(String toDaoName) {
		this.toDaoName = toDaoName;
	}
	
	public Long getStartTime() {
		return startTime;
	}
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	
	public Long getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Long finishTime) {
		this.finishTime = finishTime;
	}
	
	public Long getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(Long totalTime) {
		this.totalTime = totalTime;
	}
	
	public String getTotalTimeAsString() {
		return totalTimeAsString;
	}
	public void setTotalTimeAsString(String totalTimeAsString) {
		this.totalTimeAsString = totalTimeAsString;
	}
	
	public AtomicInteger getPending() {
		return pending;
	}
	public void setPending(AtomicInteger pending) {
		this.pending = pending;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fromDaoName == null) ? 0 : fromDaoName.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((toCount == null) ? 0 : toCount.hashCode());
		result = prime * result + ((toDaoName == null) ? 0 : toDaoName.hashCode());
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
		ForkLiftExecutionMetric other = (ForkLiftExecutionMetric) obj;
		if (fromDaoName == null) {
			if (other.fromDaoName != null)
				return false;
		} else if (!fromDaoName.equals(other.fromDaoName))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (toCount == null) {
			if (other.toCount != null)
				return false;
		} else if (!toCount.equals(other.toCount))
			return false;
		if (toDaoName == null) {
			if (other.toDaoName != null)
				return false;
		} else if (!toDaoName.equals(other.toDaoName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return toJSON();
	}
	
	public String toJSON() {
		return "{ 'fromCount'='" + fromCount + "',"
					 + " 'toCount'=" + toCount + "', "
					 + "'fromDaoName'='" + fromDaoName + "', "
					 + "'toDaoName'=" + toDaoName + "',"
					 + "'startTime'=" + startTime + "', "
					 + "'finishTime'=" + finishTime + "', "
					 + "'totalTime'=" + totalTime + "', "
					 + "'totalTimeAsString'=" + totalTimeAsString + "', "
					 + "'pending'=" + pending + "' " 
					 + "}";
	}
	
}
