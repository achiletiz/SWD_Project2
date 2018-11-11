package com.anhtnt.swd_project.Presenter;

import android.app.Application;
import android.content.Context;

import com.anhtnt.swd_project.Repositories.AppRepository;
import com.anhtnt.swd_project.Repositories.AppRepositoryImpl;
import com.anhtnt.swd_project.Room.entites.OrderItem;
import com.anhtnt.swd_project.Room.managerment.OrderItemManagement;
import com.anhtnt.swd_project.Views.OrderView;

public class OrderPresenter {
    private Context mContext;
    private AppRepository mAppRepository;
    private OrderView mOrderView;
    private OrderItemManagement mOrderItemManagement;

    public OrderPresenter(Context context, Application application, OrderView orderView){
        this.mContext= context;
        this.mAppRepository= new AppRepositoryImpl();
        this.mOrderItemManagement= new OrderItemManagement(application);
        this.mOrderView= orderView;
    }
    public void addOrderToCart(OrderItem orderItemEntity){
        mOrderItemManagement.addOrderItem(orderItemEntity);
        mOrderView.showOrderSuccessfull();
    }
}
