package com.os.sp.search;

public class Type {
    
    public static final int STRING = 0;
    public static final int INTEGER = 1;
    public static final int FLOAT = 2;
    public static final int BOOLEAN = 3;
    public static final int DATE = 4;
    public static final int DATE_RANGE = 5;
    
    public static int fromString(String str) {
    	if (str.equals("str")) {
    		return STRING;
    	} else if (str.equals("int")) {
    		return INTEGER;
    	} else if (str.equals("date")) {
    		return DATE;
    	} else if (str.equals("date-range")) {
    		return DATE_RANGE;
    	} else if (str.equals("float")) {
    		return FLOAT;
    	} else if (str.equals("boolean")) {
    		return BOOLEAN;
    	} else {
    		throw new IllegalArgumentException("unknown operator type");
    	}
    }

}
