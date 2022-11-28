package com.danti.ojasaee;

public class ModelClass {
    private String body,title;
    private int imageIcon;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(int imageIcon) {
        this.imageIcon = imageIcon;
    }



    public ModelClass(int imageIcon, String title,String body ) {
        this.body = body;
        this.title = title;
        this.imageIcon = imageIcon;
    }




}
