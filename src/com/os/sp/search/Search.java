package com.os.sp.search;

public class Search {
    
    public static void main(String[] args) {
        
        SearchConfiguration.getSearchArea("area.contact");
        System.out.println(OperatorStorage.getOperator("string.equals"));
        
    }

}
