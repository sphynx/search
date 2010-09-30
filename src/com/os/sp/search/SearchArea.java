package com.os.sp.search;

import java.util.List;

public class SearchArea {
    
    public static final String ACTION_PLAN_CATEGORY = "area.actionPlanCategory";
    public static final String ACTION_PLAN = "area.actionPlan";
    public static final String ASSET = "area.asset";
    public static final String CONTACT_GROUP = "area.contactGroup";
    public static final String CONTACT_WITHIN_ORGANIZATION = "area.contactInOrg";
    public static final String CONTACT = "area.contact";
    public static final String DOCUMENT_CATEGORY = "area.documentCategory";
    public static final String DOCUMENT = "area.document";
    public static final String EXTERNALIZED_PROCESS = "area.externalizedProcess";
    public static final String LOCAL_PROCESS = "area.localProcess";
    public static final String QUESTIONNAIRE_TEMPLATE = "area.questionnaireTemplate";
    public static final String REPORT_TEMPLATE = "area.reportTemplate";
    public static final String RESOURCE_TYPE = "area.resourceType";

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
