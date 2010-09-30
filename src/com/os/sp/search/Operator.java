package com.os.sp.search;

public class Operator {
    
    public final static Operator STRING_STARTS_WITH = new Operator("operator.string.startWith", Type.STRING, 
         " $p like '$v%'");
    public final static Operator STRING_EQUALS = new Operator("operator.string.equals", Type.STRING, 
        " $p = '$v'");
    public final static Operator STRING_CONTAINS = new Operator("operator.string.contains", Type.STRING, 
        " $p like '%$v%'");
    public final static Operator STRING_ENDS_WITH = new Operator("operator.string.endWith", Type.STRING, 
        " $p like '%$v%'");
    
    private String name;
    private int type;
    private String pattern;
    
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
    
    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public Operator(String name, int type, String pattern) {
        this.name = name;
        this.type = type;
        this.pattern = pattern;
    }
}
