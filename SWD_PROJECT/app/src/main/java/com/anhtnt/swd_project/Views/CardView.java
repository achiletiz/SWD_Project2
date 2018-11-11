package com.anhtnt.swd_project.Views;

import com.anhtnt.swd_project.Room.entites.OrderItem;

import java.util.List;

public interface CardView {
    void showOrder(List<OrderItem> mOrderItemList);
    void showFail(String message);
}
