package com.os.sp.search;

import java.util.List;

public class Field {

	private String key;
	private List<Join> joins;
	private List<String> columns;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public List<Join> getJoins() {
		return joins;
	}
	public void setJoins(List<Join> joins) {
		this.joins = joins;
	}
	public List<String> getColumns() {
		return columns;
	}
	public void setColumns(List<String> columns) {
		this.columns = columns;
	}
	public Field(String key, List<Join> joins, List<String> columns) {
		this.key = key;
		this.joins = joins;
		this.columns = columns;
	}
	
	@Override
	public String toString() {
		String res = "field '" + key + "'\n";
		
		res += " joins: \n";
		for (Join j : joins) {
			res += j.getSql() + "\n";
		}
		
		res += " columns: \n";
		for (String col : columns) {
			res += col + " ";
		}
		
		res += "\n";
		return res;
	}
	
	
}
