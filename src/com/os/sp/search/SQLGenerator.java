package com.os.sp.search;


public class SQLGenerator {
	
    public static String generateSql(SearchRequest req) {
    	
    	String areaKey = req.getSearchArea();
    	SearchArea area = SearchConfiguration.getSearchArea(areaKey);
    	SearchCondition condition = req.getCondition();
    	
    	String queryTemplate = SearchConfiguration.getQueryTemplate();
    	queryTemplate = queryTemplate.replace("$(what)", area.getSelectColumns());
    	queryTemplate = queryTemplate.replace("$(table)", area.getTable());
    	queryTemplate = queryTemplate.replace("$(alias)", area.getAlias());
       	queryTemplate = queryTemplate.replace("$(joins)", Join.toSql(
       			Join.merge(condition.getJoins(areaKey), area.getJoins())));
       	queryTemplate = queryTemplate.replace("$(where)", condition.toSql(areaKey));
       	queryTemplate = queryTemplate.replace("$(area_where)", area.getWhere());
    	
    	return queryTemplate;
    }
}
