package com.os.sp.search;

import java.util.List;

public abstract class SearchCondition {

	public abstract String toSql(String searchArea);
	public abstract List<Join> getJoins(String searchArea);
	
	public SearchCondition and(SearchCondition that) {
		return new SearchConditionAnd(this, that);
	}
	
	public SearchCondition or(SearchCondition that) {
		return new SearchConditionOr(this, that);
	}
	
	public SearchCondition inverse() {
		return new SearchConditionNot(this);
	}
}
