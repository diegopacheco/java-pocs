package com.github.diegopacheco.sandbox.java.cass.dual.writer.core.dao;

import com.datastax.driver.core.Row;

public class HashComparableRow {
	
	private RowHasher hasher;
	private Row originalRow;
	
	public HashComparableRow(RowHasher hasher, Row originalRow) {
		super();
		this.hasher = hasher;
		this.originalRow = originalRow;
	}

	public Row getOriginalRow() {
		return originalRow;
	}
	
	public RowHasher getHasher() {
		return hasher;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HashComparableRow other = (HashComparableRow) obj;
		if (hasher == null) {
			if (other.hasher != null)
				return false;
		} else if (!hasher.hash(originalRow).equals(other.getHasher().hash(originalRow)))
			return false;
		return true;
	}
	
}
