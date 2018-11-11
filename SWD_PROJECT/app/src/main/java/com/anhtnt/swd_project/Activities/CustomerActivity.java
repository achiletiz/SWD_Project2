package com.anhtnt.swd_project.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.anhtnt.swd_project.Model.Customer;
import com.anhtnt.swd_project.Model.Product;
import com.anhtnt.swd_project.Model.RequestCreate;
import com.anhtnt.swd_project.Presenter.CreateCustomerPresenter;
import com.anhtnt.swd_project.Presenter.CreateOrderPresenter;
import com.anhtnt.swd_project.Presenter.OrderPresenter;
import com.anhtnt.swd_project.R;
import com.anhtnt.swd_project.Room.entites.OrderItem;
import com.anhtnt.swd_project.Views.CreateCustomerView;
import com.anhtnt.swd_project.Views.CreateOrderView;
import com.anhtnt.swd_project.Views.OrderView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class CustomerActivity extends AppCompatActivity implements OrderView,CreateOrderView,CreateCustomerView,View.OnClickListener{
    private CreateCustomerPresenter mCreateCustomerPresenterl;
    private CreateOrderPresenter mCreateOrderPresenter;
    private OrderPresenter mOrderPresenter;
    private Product mProduct;
    private  Button  mButton;
    private CreateCustomerView mCreateCustomerView;
    private EditText nameView,addressView,genderView,phoneView;
    private String day;
    private  boolean  checkOrder = false;
    private  boolean    checkCustommer = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        getData();
        iniatailView();
    }
    private void iniatailView(){
        nameView = findViewById(R.id.edit_text_profile_name);
        addressView = findViewById(R.id.edit_text_profile_adđress);
        genderView = findViewById(R.id.edit_text_edit_gender_info);
        phoneView = findViewById(R.id.edit_text_profile_phone);
        mButton  = findViewById(R.id.button_order);
        mButton.setOnClickListener(this);
    }
    private  void getData(){
        Bundle bundle = new Bundle();
        mProduct = (Product) bundle.getSerializable(ProductDetail.BUNDLE_PRODUCT_DETAIL);
    }
    private  void initialData(){
        day = convertDateToString();
        String name = nameView.getText().toString();
        String address = addressView.getText().toString();
        String gender = genderView.getText().toString();
        String phone = phoneView.getText().toString();
        OrderItem orderItemEntity = new OrderItem();
        String orderId = UUID.randomUUID().toString();
        orderItemEntity.setOrderItemId(orderId);
        Product productOrder = mProduct;
        orderItemEntity.setFood(productOrder);
        mOrderPresenter = new OrderPresenter(CustomerActivity.this,getApplication(),this);
        mOrderPresenter.addOrderToCart(orderItemEntity);
        mCreateCustomerPresenterl = new CreateCustomerPresenter(CustomerActivity.this,CustomerActivity.this,mCreateCustomerView);
        mCreateCustomerPresenterl.showRequestCreateOrder(name,address,gender,phone);
        mCreateOrderPresenter = new CreateOrderPresenter(CustomerActivity.this, CustomerActivity.this,this);
        mCreateOrderPresenter.showRequestCreateOrder(mProduct.getId(),mProduct.getQuatity());

    }
    @Override
    public void showSuccessCustomer(RequestCreate mRequestCreate) {
            if(mRequestCreate!=null){
                checkCustommer = mRequestCreate.isStatus();
            }
    }

    @Override
    public void showSuccessOrder(RequestCreate mRequestCreate) {
            if(mRequestCreate!=null){
                checkOrder = mRequestCreate.isStatus();
            }
    }

    @Override
    public void showOrderSuccessfull() {

    }
    public static String convertDateToString() {
        String today = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date cal = Calendar.getInstance().getTime();
        today = dateFormat.format(cal);
        return today;
    }

    @Override
    public void onClick(View v) {
        int pos = v.getId();
        switch (pos){
            case  R.id.button_order:
                initialData();
                if(checkOrder && checkCustommer){
                    Toast.makeText(CustomerActivity.this,"Order thành công ",Toast.LENGTH_LONG).show();
                    intentToHome();

                }
                Toast.makeText(CustomerActivity.this,"Order  không thành công ",Toast.LENGTH_LONG).show();
                break;
        }
    }
    private  void intentToHome(){

        Intent intent = new Intent(CustomerActivity.this,HomeActivity.class);
        startActivity(intent);
    }
}
