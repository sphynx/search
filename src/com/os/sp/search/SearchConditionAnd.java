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
	public String prettyPrint(String searchArea) {
    	
       	String clause = "(";
       	clause += getLeft().prettyPrint(searchArea);
       	clause += " and ";
       	clause += getRight().prettyPrint(searchArea);
       	clause += ")";
 
		return clause;
	}
	
	@Override
	public List<Join> joins(String searchArea) {
		return Join.merge(getLeft().joins(searchArea), getRight().joins(searchArea));
	}
}
