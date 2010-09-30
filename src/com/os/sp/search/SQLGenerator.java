package com.os.sp.search;

import java.util.Iterator;

public class SQLGenerator {
	
    public static String generateSql(SearchRequest req) {
    	
    	String queryTemplate = SearchConfiguration.getQueryTemplate();
    	String areaKey = req.getSearchArea();
    	SearchArea area = SearchConfiguration.getSearchArea(areaKey);
    	
    	queryTemplate = queryTemplate.replace("$(what)", area.getSelectColumns());
    	queryTemplate = queryTemplate.replace("$(table)", area.getTable());
    	queryTemplate = queryTemplate.replace("$(alias)", area.getAlias());
    	
    	SearchCondition cond = req.getCondition();
    	
    	String joins = "";
       	for (Iterator<Join> i = cond.joins(areaKey).iterator(); i.hasNext(); ) {
       		Join j = i.next();
       		joins += "join " + j.getSql();
       		joins += "\n";
       	}
 
       	queryTemplate = queryTemplate.replace("$(joins)", joins);
       	
       	String where = req.getCondition().prettyPrint(areaKey);
       	
       	queryTemplate = queryTemplate.replace("$(where)", where);
       	queryTemplate = queryTemplate.replace("$(area_where)", area.getWhere());
    	
    	return queryTemplate;
    }
}
