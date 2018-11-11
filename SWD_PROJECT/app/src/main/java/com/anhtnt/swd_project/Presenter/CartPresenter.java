package com.anhtnt.swd_project.Presenter;

import android.app.Application;
import android.content.Context;

import com.anhtnt.swd_project.Repositories.AppRepository;
import com.anhtnt.swd_project.Room.entites.OrderItem;
import com.anhtnt.swd_project.Room.managerment.OrderItemManagement;
import com.anhtnt.swd_project.Views.CardView;

import java.util.List;

public class CartPresenter {
    private Context mContext;
    private AppRepository mAppRepository;
    private CardView mOrderView;
    private OrderItemManagement mOrderItemManagement;

    public CartPresenter(Context context, Application application, CardView cartView) {
        this.mContext = context;
        this.mOrderItemManagement = new OrderItemManagement(application);
        this.mOrderView = cartView;
    }

    public void getOrderItem() {
        mOrderItemManagement.getAllOrderItemEntity(new OrderItemManagement.OnDataCallBackOrderData() {
            @Override
            public void onDataSuccess(List<OrderItem> orderItemEntityList) {
                mOrderView.showOrder(orderItemEntityList);
            }

            @Override
            public void onDataFail(String message) {
                mOrderView.showFail(message);
            }
        });
    }

}
