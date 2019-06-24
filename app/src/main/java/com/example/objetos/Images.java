package com.example.objetos;

public class Images {

    private String url;
    private String description;
    private int rUrl;


    public Images(String url, String description, int rUrl) {
        this.url = url;
        this.description = description;
        this.rUrl = rUrl;
    }

    public int getrUrl() {
        return rUrl;
    }

    public void setrUrl(int rUrl) {
        this.rUrl = rUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
