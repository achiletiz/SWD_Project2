package com.anhtnt.swd_project.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Product implements Serializable{

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("takenDay")
    private String taken_day;

    @SerializedName("price")
    private double price;

    private  int quatity;
    public Product() {
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

    public String getTaken_day() {
        return taken_day;
    }

    public void setTaken_day(String taken_day) {
        this.taken_day = taken_day;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuatity() {
        return quatity;
    }

    public void setQuatity(int quatity) {
        this.quatity = quatity;
    }
}
