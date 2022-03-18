package com.example.profile.model;

public class Chat {
    private int id;
    private String ten;
    private String moTa;

    public Chat(int id,String ten,String moTa){
    this.id=id;
    this.ten=ten;
    this.moTa=moTa;
    }
    public String getMoTa() {
        return moTa;

    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
