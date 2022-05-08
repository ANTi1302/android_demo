package com.example.myapplication.entity;

public class Employee {
    private String name;
    private String phone;
    private String address;
    private String age;

    public Employee() {
    }

    public Employee(String name, String phone, String address, String age) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
