package com.example.rakesh.news;

/**
 * Created by Rakesh on 12-07-2018.
 */

public class newsitem {
    private String header;
    private String desc;
    private String imageurl;
    private String url;

    public newsitem(String url) {
        this.url = url;
    }


    public String getUrl() {
        return url;
    }

    public newsitem(String header, String desc, String imageurl, String url) {
        this.header = header;
        this.desc = desc;
        this.imageurl = imageurl;
        this.url = url;
    }

    public String getHeader() {
        return header;
    }

    public String getDesc() {
        return desc;
    }

    public String getImageurl() {
        return imageurl;
    }

    public newsitem() {

    }
}
