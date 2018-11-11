package com.anhtnt.swd_project.Presenter;

import android.app.Activity;
import android.content.Context;

import com.anhtnt.swd_project.Model.Product;
import com.anhtnt.swd_project.Repositories.AppRepository;
import com.anhtnt.swd_project.Repositories.AppRepositoryImpl;
import com.anhtnt.swd_project.Repositories.CallBackData;
import com.anhtnt.swd_project.Views.ProductView;

import java.util.List;

public class ProductPresenter {
    private Context mContext;
    private ProductView mProductView;
    private AppRepository mAppRepository;
    private Activity activity;

    public ProductPresenter(Context mContext, ProductView mProductView, Activity activity) {
        this.mContext = mContext;
        this.mProductView = mProductView;
        this.activity = activity;
        this.mAppRepository = new AppRepositoryImpl();

    }
    public  void showProduct(){
        mAppRepository.getTatCaSanPham(mContext, new CallBackData<List<Product>>() {
            @Override
            public void onSuccess(List<Product> products) {
                mProductView.showProduct(products);
            }

            @Override
            public void onFail(String message) {
                mProductView.showFail(message);
            }
        });
    }
}

