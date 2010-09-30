package com.os.sp.search;

public class SearchRequest {
    
    private boolean searchInLibrary = false;
    private boolean useCurrentFilter = true; 
    private boolean resolveReferences = false; 
    private Filter filter = null;
    private String searchArea;
    private SearchCondition condition;
    
    public boolean isSearchInLibrary() {
        return searchInLibrary;
    }
    public void setSearchInLibrary(boolean searchInLibrary) {
        this.searchInLibrary = searchInLibrary;
    }
    
    public boolean isUseCurrentFilter() {
        return useCurrentFilter;
    }
    public void setUseCurrentFilter(boolean useCurrentFilter) {
        this.useCurrentFilter = useCurrentFilter;
    }
    
    public boolean isResolveReferences() {
        return resolveReferences;
    }
    public void setResolveReferences(boolean resolveReferences) {
        this.resolveReferences = resolveReferences;
    }
    
    public Filter getFilter() {
        return filter;
    }
    public void setFilter(Filter filter) {
        this.filter = filter;
    }
    
    public String getSearchArea() {
        return searchArea;
    }
    public void setSearchArea(String searchArea) {
        this.searchArea = searchArea;
    }
    
    public SearchCondition getCondition() {
        return condition;
    }
    public void setCondition(SearchCondition condition) {
        this.condition = condition;
    }
    
    public SearchRequest(String searchArea, SearchCondition condition) {
        this.searchArea = searchArea;
        this.condition = condition;
    }
}
