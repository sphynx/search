package com.os.sp.search;

import java.util.List;

public class SearchConditionNot extends SearchCondition {
    
    private final SearchCondition condition;

    public SearchCondition getCondition() {
        return condition;
    }

    public SearchConditionNot(SearchCondition condition) {
        this.condition = condition;
    }

	@Override
	public String toSql(String searchArea) {
       	String clause = "not (";
       	clause += getCondition().toSql(searchArea);
       	clause += ")";
       	return clause;

	}

	@Override
	public List<Join> getJoins(String searchArea) {
		return condition.getJoins(searchArea);
	}
    

}
