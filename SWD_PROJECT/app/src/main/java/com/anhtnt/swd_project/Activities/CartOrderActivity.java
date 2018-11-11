package com.anhtnt.swd_project.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import com.anhtnt.swd_project.Adapter.CartAdapter;
import com.anhtnt.swd_project.Presenter.CartPresenter;
import com.anhtnt.swd_project.R;
import com.anhtnt.swd_project.Room.entites.OrderItem;
import com.anhtnt.swd_project.Views.CardView;

import java.util.List;

public class CartOrderActivity extends AppCompatActivity  implements CardView{
    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    CartAdapter mCartAdapter;
    CartPresenter mCartPresenter;
    private  List<OrderItem> mOrderItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_order);
        iniatailView();
        iniatailData();
    }
    private  void iniatailData(){
        mCartPresenter = new CartPresenter(CartOrderActivity.this,getApplication(),this);
        mCartPresenter.getOrderItem();

    }
    private void UpdateUI(){
        if(mCartAdapter == null){
            mCartAdapter = new CartAdapter(CartOrderActivity.this,mOrderItems);
            mRecyclerView.setAdapter(mCartAdapter);
        }
    }
    private  void iniatailView(){
        mToolbar = findViewById(R.id.toolbar_home);
        setSupportActionBar(mToolbar);
        mRecyclerView = findViewById(R.id.AllProducts);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(CartOrderActivity.this) ;
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
    }
    @Override
    public void showOrder(List<OrderItem> mOrderItemList) {
        mOrderItems = mOrderItemList;
        if(mOrderItems!=null){
            UpdateUI();
        }
    }

    @Override
    public void showFail(String message) {

    }
}
