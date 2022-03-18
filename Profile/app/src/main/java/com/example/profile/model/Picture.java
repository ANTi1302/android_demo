package com.example.profile.model;

public class Picture {
    private int id;
    private String img;
    public Picture(int id, String img){
        this.id=id;
        this.img=img;
    }
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
