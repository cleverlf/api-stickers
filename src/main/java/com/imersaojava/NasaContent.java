package com.imersaojava;

public class NasaContent {

    public String hdurl;
    public String title;

    public NasaContent(String hdurl, String title) {
        this.hdurl = hdurl;
        this.title = title;
    }

    public String getHdurl() {
        return hdurl;
    }

    public void setHdurl(String hdurl) {
        this.hdurl = hdurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
