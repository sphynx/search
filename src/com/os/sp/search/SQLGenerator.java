package com.os.sp.search;

public class SQLGenerator {
    
    public static String generateSql(SearchRequest req) {
    	
    	String queryTemplate = SearchConfiguration.getQueryTemplate();
    	SearchArea area = SearchConfiguration.getSearchArea(req.getSearchArea());
    	
    	return queryTemplate;
    }
}
