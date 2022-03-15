package com.example.myapplication.model;

public class Language {
    private int id;
    private float giaTien;
    private String name;

    public Language(int id,float giaTien, String name) {
        this.giaTien=giaTien;
        this.id = id;
        this.name = name;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}