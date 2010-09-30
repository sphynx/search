package com.os.sp.search;

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
    public String toString() {
        return left.toString() + " AND " + right.toString();
    }
}
