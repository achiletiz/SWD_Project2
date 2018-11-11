package com.anhtnt.swd_project.Presenter;

import android.app.Activity;
import android.content.Context;

import com.anhtnt.swd_project.Model.RequestCreate;
import com.anhtnt.swd_project.Repositories.AppRepository;
import com.anhtnt.swd_project.Repositories.AppRepositoryImpl;
import com.anhtnt.swd_project.Repositories.CallBackData;
import com.anhtnt.swd_project.Views.CreateOrderView;

public class CreateOrderPresenter {
    private Activity activity;
    private Context context;
    private AppRepository mAppRepository;
    private CreateOrderView mCreateOrderView;

    public CreateOrderPresenter(Activity activity, Context context, CreateOrderView mCreateOrderView) {
        this.activity = activity;
        this.context = context;
        this.mCreateOrderView = mCreateOrderView;
        this.mAppRepository = new AppRepositoryImpl();

    }
    public  void showRequestCreateOrder(int productID,int quatity){
        mAppRepository.createOrder(context, productID, quatity, new CallBackData<RequestCreate>() {
            @Override
            public void onSuccess(RequestCreate requestCreate) {
                mCreateOrderView.showSuccessOrder(requestCreate);
            }

            @Override
            public void onFail(String message) {

            }
        });
    }

}
