package com.os.sp.search;

public class Search {
    
    public static void main(String[] args) {
        
    	Predicate p = new Predicate("contact.firstName", "string.contains", "a");
    	SearchRequest req = new SearchRequest("area.contact", p);
    	
    	System.out.println("generated SQL: " + SQLGenerator.generateSql(req));
        
    }

}
