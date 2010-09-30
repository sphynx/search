package com.os.sp.search;

public class Search {
    
    public static void main(String[] args) {
        
    	Predicate p = new Predicate("contact.firstName", "string.starts-with", "a");
    	SearchRequest req = new SearchRequest("area.contact", p);
    	
    	System.out.println("generated SQL: \n" + SQLGenerator.generateSql(req));
    }

}
