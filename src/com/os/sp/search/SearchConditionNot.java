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
	public String prettyPrint(String searchArea) {
       	String clause = "not (";
       	clause += getCondition().prettyPrint(searchArea);
       	clause += ")";
       	return clause;

	}

	@Override
	public List<Join> joins(String searchArea) {
		return condition.joins(searchArea);
	}
    

}
