package com.os.sp.search;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Join {
	
	private String sql;

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public Join(String sql) {
		super();
		this.sql = sql;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Join) {
			Join that = (Join) obj;
			if (that.getSql() != null) {
				return that.getSql().equals(this.getSql());
			} else if (this.getSql() == null) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public int hashCode() {
		return getSql() != null ? getSql().hashCode() : 0;
	}
	
	public static List<Join> merge(List<Join> joins1, List<Join> joins2) {
		// remove duplicates, leaving the order of lists untouched
		Set<Join> joins = new LinkedHashSet<Join>(joins1);
		joins.addAll(joins2);
		return new ArrayList<Join>(joins);
	}
}
