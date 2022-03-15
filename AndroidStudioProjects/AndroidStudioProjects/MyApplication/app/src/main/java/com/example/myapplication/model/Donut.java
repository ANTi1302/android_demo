package com.example.myapplication.model;

public class Donut {
    private int id;
    private String tenDonut;
    private String moTa;
    private  String img;
    private float giaTien;

    public float getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(float giaTien) {
        this.giaTien = giaTien;
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

    public String getTenDonut() {
        return tenDonut;
    }

    public void setTenDonut(String tenDonut) {
        this.tenDonut = tenDonut;
    }
    public Donut(){

    }
    public Donut(int id,String tenDonut,String moTa,String img,float giaTien){
        this.id=id;
        this.tenDonut=tenDonut;
        this.moTa=moTa;
        this.img=img;
        this.giaTien=giaTien;
    }
    public Donut(int id,String tenDonut,String moTa,float giaTien){
        this.id=id;
        this.tenDonut=tenDonut;
        this.moTa=moTa;

        this.giaTien=giaTien;
    }
}
