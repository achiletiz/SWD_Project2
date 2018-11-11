package com.anhtnt.swd_project.Model;

import com.google.gson.annotations.SerializedName;

public class Customer {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("yob")
    private String yob;
    @SerializedName("address")
    private  String address;
    @SerializedName("gender")
    private String gender;
    @SerializedName("phone")
    private  String phone;

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

    public String getYob() {
        return yob;
    }

    public void setYob(String yob) {
        this.yob = yob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
