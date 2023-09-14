package com.hb.dl.demo.forms;

public class SearchForm {

    private String searchBar;

    private String departmentNumber;
    private boolean plageWithPicture;
    public String getSearchBar(){
        return searchBar;
    }

    public void setSearchBar(String searchBar) {
        this.searchBar = searchBar;
    }

    public String getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(String departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public boolean isPlageWithPicture() {
        return plageWithPicture;
    }

    public void setPlageWithPicture(boolean plageWithPicture) {
        this.plageWithPicture = plageWithPicture;
    }
}
