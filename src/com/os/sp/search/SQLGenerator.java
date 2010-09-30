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
    	
    	Predicate p = (Predicate) req.getCondition();
    	Field f = SearchConfiguration.getField(areaKey, p.getFieldKey());
    	
    	String joins = "";
       	for (Iterator<Join> i = f.getJoins().iterator(); i.hasNext(); ) {
       		Join j = i.next();
       		joins += j.getSql();
       		if (i.hasNext()) {
       			joins += " ";
       		}
       	}
 
       	queryTemplate = queryTemplate.replace("$(joins)", joins);
       	
       	String where = "";
       	Operator op = SearchConfiguration.getOperator(p.getOperatorKey());
       	
       	for (Iterator<String> i = f.getColumns().iterator(); i.hasNext(); ) {
       		String c = i.next();
       		String tpl = op.getTemplate();
       		tpl = tpl.replace("$(F)", c);
       		tpl = tpl.replace("$(V)", p.getValue().toString());
       		where += tpl;
       		if (i.hasNext()) {
       			where += " OR ";
       		}
       	}
       	
       	queryTemplate = queryTemplate.replace("$(where)", where);
    	
    	return queryTemplate;
    }
}
