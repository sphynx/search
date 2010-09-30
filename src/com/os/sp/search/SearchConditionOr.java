package com.os.sp.search;

public class SearchConditionOr extends SearchCondition {
    
    private final SearchCondition left;
    private final SearchCondition right;
    
    public SearchCondition getLeft() {
        return left;
    }
    public SearchCondition getRight() {
        return right;
    }
    
    public SearchConditionOr(SearchCondition left, SearchCondition right) {
        this.left = left;
        this.right = right;
    }
    
    @Override
    public String toString() {
        return left.toString() + " OR " + right.toString();
    }
}
