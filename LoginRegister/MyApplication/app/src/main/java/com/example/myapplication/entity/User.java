package com.example.myapplication.entity;

public class User {
    private String name,age,email,pass;

    public User() {
    }

    public User(String name, String age, String email, String pass) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.pass = pass;
    }
    public User(String name, String age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
