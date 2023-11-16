package com.trungson.jsonarrayobject_project;

public class Item {
    private String Ten;
    private String url;

    public Item(String ten, String url) {
        Ten = ten;
        this.url = url;
    }

    public Item() {
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
