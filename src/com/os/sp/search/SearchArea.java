package com.os.sp.search;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchArea {
    
    public static final String QUERY_TEMPLATE = "select $(what) from $(table) $(alias) $(joins) where $(where)";
    
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

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public SearchArea(String table, String alias, String what) {
        this.table = table;
        this.alias = alias;
        this.what = what;
    }
    
    private String table;
    private String alias;
    private String what;
    private List<Field> fields;

    private static final Map<Integer, SearchArea> areaStorage = initStorage();
    
    private static Map<Integer, SearchArea> initStorage() {
        Map<Integer, SearchArea> map = new HashMap<Integer, SearchArea>();
        map.put(ACTION_PLAN_CATEGORY, new SearchArea("action_plan_category", "apc", "*"));
        map.put(ACTION_PLAN, new SearchArea("action_plan", "ap", "*"));
        map.put(ASSET, new SearchArea("asset", "a", "*"));
        map.put(CONTACT_GROUP, new SearchArea("contact_group", "cg", "*"));
        map.put(CONTACT_WITHIN_ORGANIZATION, new SearchArea("contact", "c", "*"));
        map.put(CONTACT, new SearchArea("contact", "c", "*"));
        map.put(DOCUMENT_CATEGORY, new SearchArea("document_category", "dc", "*"));
        map.put(DOCUMENT, new SearchArea("document", "d", "*"));
        map.put(EXTERNALIZED_PROCESS, new SearchArea("local_process", "lp", "*"));
        map.put(LOCAL_PROCESS, new SearchArea("local_process", "lp", "*"));
        map.put(QUESTIONNAIRE_TEMPLATE, new SearchArea("questionnaire_template", "qt", "*"));
        map.put(REPORT_TEMPLATE, new SearchArea("report_template", "rt", "*"));
        map.put(RESOURCE_TYPE, new SearchArea("resource_type", "rt", "*"));
        return map;
    }
    
    public SearchArea getAreaById(int id) {
        return areaStorage.get(id);
    }
}
