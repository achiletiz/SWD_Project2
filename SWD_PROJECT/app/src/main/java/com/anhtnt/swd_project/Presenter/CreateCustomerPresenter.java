package com.anhtnt.swd_project.Presenter;

import android.app.Activity;
import android.content.Context;

import com.anhtnt.swd_project.Model.RequestCreate;
import com.anhtnt.swd_project.Repositories.AppRepository;
import com.anhtnt.swd_project.Repositories.AppRepositoryImpl;
import com.anhtnt.swd_project.Repositories.CallBackData;
import com.anhtnt.swd_project.Views.CreateCustomerView;

public class CreateCustomerPresenter {
    private Activity activity;
    private Context context;
    private AppRepository mAppRepository;
    private CreateCustomerView mCreateCustomerView;

    public CreateCustomerPresenter(Activity activity, Context context, CreateCustomerView mCreateOrderView) {
        this.activity = activity;
        this.context = context;
        this.mCreateCustomerView = mCreateOrderView;
        this.mAppRepository = new AppRepositoryImpl();

    }

    public void showRequestCreateOrder(String name, String address, String gender, String phone) {
        mAppRepository.createCustomer(context, name, address, gender, phone, new CallBackData<RequestCreate>() {
            @Override
            public void onSuccess(RequestCreate requestCreate) {
                mCreateCustomerView.showSuccessCustomer(requestCreate);
            }

            @Override
            public void onFail(String message) {

            }
        });
    }
}
