package com.anhtnt.swd_project.Repositories;

import android.content.Context;

import com.anhtnt.swd_project.Model.Product;
import com.anhtnt.swd_project.Model.RequestCreate;

import java.util.List;

public interface AppRepository {
    void getTatCaSanPham(Context context, CallBackData<List<Product>> callBackData);
    void createOrder(Context context , int productId, int quantity, CallBackData<RequestCreate> mCallBackData);
    void createCustomer( Context context, String name,String address,String gender,String phone,CallBackData<RequestCreate> mCallBackData);
}
