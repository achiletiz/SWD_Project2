package com.anhtnt.swd_project.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;

import com.anhtnt.swd_project.Adapter.ProductAdapter;
import com.anhtnt.swd_project.Model.Product;
import com.anhtnt.swd_project.Presenter.ProductPresenter;
import com.anhtnt.swd_project.R;
import com.anhtnt.swd_project.Utils.GirdSpacingItemDecoration;
import com.anhtnt.swd_project.Views.ProductView;

import java.util.List;

public class HomeActivity extends AppCompatActivity  implements ProductView{
    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private ProductAdapter mAdapter;
    private List<Product> productList;
    private ProductPresenter mProductPresenter;
    public   static  final  String BUNDLE_ALL = "getAll";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        iniatailView();
        iniatialData();
    }
    private  void iniatailView(){
        mToolbar = findViewById(R.id.toolbar_home);
        setSupportActionBar(mToolbar);
        mRecyclerView = findViewById(R.id.AllProducts);
       final LinearLayoutManager layoutManager = new LinearLayoutManager(HomeActivity.this) ;
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,CartOrderActivity.class);
                startActivity(intent);
            }
        });
    }
    private  void iniatialData(){
        mProductPresenter = new ProductPresenter(HomeActivity.this,this, HomeActivity.this);
        mProductPresenter.showProduct();
    }
    private  void updateUI(){
        if(mAdapter == null){
            mAdapter = new ProductAdapter(HomeActivity.this,productList);
            mRecyclerView.setAdapter(mAdapter);
            mAdapter.setOnItemClickListner(new ProductAdapter.setOnClickListener() {
                @Override
                public void setOnItemClickListener(int postion) {
                        intentSpChiTietTatCa(productList.get(postion));
                }
            });
        }
        else  {
            mAdapter.notifyDataSetChanged();
        }
    }
    @Override
    public void showProduct(List<Product> mProductList) {
        productList = mProductList;
        if(productList !=null){
            updateUI();
        }

    }

    @Override
    public void showFail(String message) {

    }
    private  void intentSpChiTietTatCa(Product product){
        Intent intent = new Intent(HomeActivity.this,ProductDetail.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(BUNDLE_ALL, product);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
