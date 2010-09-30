package com.os.sp.search;

public class SearchConditionNot extends SearchCondition {
    
    private final SearchCondition condition;

    public SearchCondition getCondition() {
        return condition;
    }

    public SearchConditionNot(SearchCondition condition) {
        this.condition = condition;
    }
    
    @Override
    public String toString() {
        return "NOT (" + condition.toString() + ")";
    }
}
