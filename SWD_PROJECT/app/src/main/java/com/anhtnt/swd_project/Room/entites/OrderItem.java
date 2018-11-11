package com.anhtnt.swd_project.Room.entites;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.anhtnt.swd_project.Model.Product;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "OrderItem")
public class OrderItem implements Serializable {
    @PrimaryKey
    @ColumnInfo(name = "uuid")
    @NonNull
    private String orderItemId;
    @TypeConverters(FoodDataConvert.class)
    @ColumnInfo(name = "food")
    private Product food;

    public OrderItem() {
    }

    @NonNull
    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(@NonNull String orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Product getFood() {
        return food;
    }

    public void setFood(Product food) {
        this.food = food;
    }
}
