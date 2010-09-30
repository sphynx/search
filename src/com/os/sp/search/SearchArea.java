package com.os.sp.search;

import java.util.List;

public class SearchArea {
    
    public static final int ACTION_PLAN_CATEGORY = 1;
    public static final int ACTION_PLAN = 2;
    public static final int ASSET = 3;
    public static final int CONTACT_GROUP = 4;
    public static final int CONTACT_WITHIN_ORGANIZATION = 5;
    public static final int CONTACT = 6;
    public static final int DOCUMENT_CATEGORY = 7;
    public static final int DOCUMENT = 8;
    public static final int EXTERNALIZED_PROCESS = 9;
    public static final int LOCAL_PROCESS = 10;
    public static final int QUESTIONNAIRE_TEMPLATE = 11;
    public static final int REPORT_TEMPLATE = 12;
    public static final int RESOURCE_TYPE = 13;

    private String key;
	private String table;
    private String alias;
    private String selectColumns;
    private List<Field> fields;
    private String join;
    private String where;

    public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getJoin() {
		return join;
	}

	public void setJoin(String join) {
		this.join = join;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

	public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getSelectColumns() {
		return selectColumns;
	}

	public void setSelectColumns(String selectColumns) {
		this.selectColumns = selectColumns;
	}

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	public SearchArea(String key, String table, String alias, String selectColumns,
			List<Field> fields, String join, String where) {
		super();
		this.key = key;
		this.table = table;
		this.alias = alias;
		this.selectColumns = selectColumns;
		this.fields = fields;
		this.join = join;
		this.where = where;
	}
	@Override
	public String toString() {
		String res = "key = " + key 
	    + ", table = " + table 
		+ ", alias = " + alias
		+ ", select-columns = " + selectColumns
		+ ", area-join = " + join
		+ ", where = " + where
		+ "\n";
		
		if (fields != null) {
			for (Field f : fields) {
				res += f.toString() + "\n";
			}
		}
		
		return res;
	}
}
