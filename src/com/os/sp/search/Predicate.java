package com.os.sp.search;

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
}
