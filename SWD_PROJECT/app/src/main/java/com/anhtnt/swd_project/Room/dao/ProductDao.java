package com.anhtnt.swd_project.Room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.anhtnt.swd_project.Room.entites.OrderItem;

import java.util.List;

@Dao
public interface ProductDao {
    @Insert
    void insertOrderItem(OrderItem... orderItem);
    @Delete
    void deleteOrderItem(OrderItem... orderItem);

    @Query("select * from orderItem")
    List<OrderItem> getAllOrderItemEntity();
}
