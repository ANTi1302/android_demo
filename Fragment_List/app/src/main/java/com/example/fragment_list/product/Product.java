package com.example.fragment_list.product;

public class Product {
    private int id;
    private String img;
    private String moTa;
    private String ten;
    private float gia;

    public Product() {
    }

    public Product(int id) {
        this.id = id;
    }

    public Product(int id, String img, String moTa, String ten, float gia) {
        this.id = id;
        this.img = img;
        this.moTa = moTa;
        this.ten = ten;
        this.gia = gia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }
}
