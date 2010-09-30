package com.os.sp.search;

import java.util.Iterator;
import java.util.List;

public class Predicate extends SearchCondition {
    
    private String fieldKey;
    private String operatorKey;
    private Object value;
    
	public String getFieldKey() {
		return fieldKey;
	}
	public void setFieldKey(String fieldKey) {
		this.fieldKey = fieldKey;
	}
	public String getOperatorKey() {
		return operatorKey;
	}
	public void setOperatorKey(String operatorKey) {
		this.operatorKey = operatorKey;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
	public Predicate(String fieldKey, String operatorKey, Object value) {
		super();
		this.fieldKey = fieldKey;
		this.operatorKey = operatorKey;
		this.value = value;
	}
	@Override
	public String toSql(String searchArea) {
		Field f = SearchConfiguration.getField(searchArea, getFieldKey());
    	
       	String clause = "(";
       	Operator op = SearchConfiguration.getOperator(getOperatorKey());
       	
       	for (Iterator<String> i = f.getColumns().iterator(); i.hasNext(); ) {
       		String column = i.next();
       		clause += OperatorResolver.resolve(op, column, getValue().toString());
       		if (i.hasNext()) { // merge with `or` by default
       			clause += " or ";
       		}
       	}
       	clause += ")";
 
		return clause;
	}
	@Override
	public List<Join> getJoins(String searchArea) {
		Field f = SearchConfiguration.getField(searchArea, getFieldKey());
    	return f.getJoins();
	}
}
