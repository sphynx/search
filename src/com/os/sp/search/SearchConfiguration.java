package com.os.sp.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchConfiguration {
    
    /*
    Map: search area -> [applicable fields]
     */
    private static Map<Integer, List<Field>> conf = initConfiguration();
    
    private static Map<Integer, List<Field>> initConfiguration() {
        Map<Integer, List<Field>> res = new HashMap<Integer, List<Field>>();
        
        List<Field> fields = new ArrayList<Field>();
        fields.add(new Field("contact.firstName", Type.STRING));
        fields.add(new Field("contact.lastName", Type.STRING));
        fields.add(new Field("contact.companyName", Type.STRING));
        fields.add(new Field("contact.id", Type.INTEGER));
        res.put(SearchArea.CONTACT, fields);
        
        fields = new ArrayList<Field>();
        fields.add(new Field("rt.name", Type.STRING));
        fields.add(new Field("rt.description", Type.STRING));
        fields.add(new Field("rt.owner", Type.STRING));
        res.put(SearchArea.RESOURCE_TYPE, fields);
        
        return res;
    }
    
    public static List<Field> getFields(Integer searchArea) {
        return conf.get(searchArea);
    }
    
    public static Field getFieldByName(String name) {
        /// TODO
        return null;
    }
}
