package com.os.sp.search;

import java.util.List;

public class SearchConditionAnd extends SearchCondition {
    
    private final SearchCondition left;
    private final SearchCondition right;
    
    public SearchCondition getLeft() {
        return left;
    }
    public SearchCondition getRight() {
        return right;
    }
    
    public SearchConditionAnd(SearchCondition left, SearchCondition right) {
        this.left = left;
        this.right = right;
    }
    
	@Override
	public String toSql(String searchArea) {
    	
       	String clause = "(";
       	clause += getLeft().toSql(searchArea);
       	clause += " and ";
       	clause += getRight().toSql(searchArea);
       	clause += ")";
 
		return clause;
	}
	
	@Override
	public List<Join> getJoins(String searchArea) {
		return Join.merge(getLeft().getJoins(searchArea), getRight().getJoins(searchArea));
	}
}
