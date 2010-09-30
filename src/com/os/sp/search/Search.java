package com.os.sp.search;

public class Search {
    
    public static void main(String[] args) {
        
    	SearchCondition cond = 
    		new Predicate(Field.CONTACT_PHONE, Operator.STR_CONTAINS, "422")
        .and(new Predicate(Field.CONTACT_FIRST_NAME, Operator.STR_STARTS_WITH, "a"))
        .and(new Predicate(Field.CONTACT_LAST_NAME, Operator.STR_STARTS_WITH, "a"))
        .or(new Predicate(Field.CONTACT_COMPANY_NAME, Operator.STR_CONTAINS, "Sony"));
    	
    	SearchRequest req = new SearchRequest(SearchArea.CONTACT, cond);
    	
    	System.out.println(SQLGenerator.generateSql(req));
    }

}
