package com.os.sp.search;

public class Operator {
	
	public static final String STR_CONTAINS = "string.contains";
	public static final String STR_STARTS_WITH = "string.startsWith";
	public static final String STR_ENDS_WITH = "string.endsWith";
	public static final String STR_EQUALS = "string.equals";
	public static final String STR_MATCHES = "string.matches";
    
    private String name;
    private int type;
    private String template;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getType() {
        return type;
    }
    
    public void setType(int type) {
        this.type = type;
    }
    
    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Operator(String name, int type, String template) {
        this.name = name;
        this.type = type;
        this.template = template;
    }

	@Override
	public String toString() {
		return "operator. name = " + name 
		+ ", type = " + type
		+ ", template = " + template;
	}
}
