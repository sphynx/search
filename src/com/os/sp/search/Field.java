package com.os.sp.search;

import java.util.List;

public class Field {
    
    private String name;
    private int type; // enum would suffice better, but it's a problem to use it on flex side
    private List<String> tables; 
    
    public Field(String name, int type) {
        super();
        this.name = name;
        this.type = type;
        this.tables = null;
    }
    
    
    
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
}
