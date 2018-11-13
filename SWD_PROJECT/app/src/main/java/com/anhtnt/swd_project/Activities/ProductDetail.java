package com.anhtnt.swd_project.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.anhtnt.swd_project.Model.Product;
import com.anhtnt.swd_project.R;
import com.anhtnt.swd_project.Utils.ChangeValue;
import com.squareup.picasso.Picasso;

public class ProductDetail extends AppCompatActivity  implements View.OnClickListener{
    private Product product;
    private ImageView mImageViewHinh;
    private ImageView mImgIncrease;
    private ImageView mImgDecrease;;
    private int mQuantity = 1;
    private  double mTotal;
    private TextView mTextViewEdit;
    private LinearLayout linearLayout;
    private TextView mTextViewPriceTotal,mTxtViewName,mTxtViewPrice,mTxtViewQuantity;
    public  static  final  String BUNDLE_PRODUCT_DETAIL = "PRODUCTDETAIL";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        getDataFromThietBiSanPHam();
        iniatialView();
        iniatialData();
    }
    private  void iniatialView(){
        mTxtViewName = findViewById(R.id.text_name_all);
        mImageViewHinh = findViewById(R.id.image_all);
        mTextViewPriceTotal = findViewById(R.id.text_amount_order_all);
        mTxtViewPrice = findViewById(R.id.text_price_all);
        mTxtViewQuantity = findViewById(R.id.date_all);

        mTextViewEdit = findViewById(R.id.edit_text_quantity_order_all);
        mImgDecrease = findViewById(R.id.image_decrease_edit_order_all);
        mImgIncrease = findViewById(R.id.image_increase_edit_order_all);
        linearLayout = findViewById(R.id.lnl_button_save_edit_order_all);
        linearLayout.setOnClickListener(this);
        mImgIncrease.setOnClickListener(this);
        mImgDecrease.setOnClickListener(this);
    }
    private  void getDataFromThietBiSanPHam(){
        Intent intent = getIntent();
        product = (Product) intent.getSerializableExtra(HomeActivity.BUNDLE_ALL);
    }
    private  void iniatialData(){
            Picasso.get().load(product.getImage()).into(mImageViewHinh);
        mTxtViewQuantity.setText(product.getTaken_day());
        mTxtViewPrice.setText(ChangeValue.formatDecimalPrice((float) product.getPrice()));
        mTxtViewName.setText(product.getName());
        mTotal = product.getPrice();
        mTextViewPriceTotal.setText(ChangeValue.formatDecimalPrice((float) mTotal));
    }
    private void buttonIncrease() {
        mQuantity++;
        mTotal = product.getPrice()* mQuantity;
        mTextViewEdit.setText(String.valueOf(mQuantity));
        mTextViewPriceTotal.setText(ChangeValue.formatDecimalPrice((float) mTotal));
    }
    private void buttonDecrease() {
        mQuantity--;
        if(mQuantity < 0){
            mQuantity = 0;
        }
        mTotal = product.getPrice()* mQuantity;
        mTextViewEdit.setText(String.valueOf(mQuantity));
        mTextViewPriceTotal.setText(ChangeValue.formatDecimalPrice((float) mTotal));
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_increase_edit_order_all:
                buttonIncrease();
                break;
            case R.id.image_decrease_edit_order_all:
                buttonDecrease();
                break;
            case  R.id.lnl_button_save_edit_order_all:
                showLogoutDialog();
        }
    }
    private void showLogoutDialog() {
        final Dialog dialog = new Dialog(ProductDetail.this);
        dialog.setContentView(R.layout.alert_diglog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button buttonOk = dialog.findViewById(R.id.btn_yes);
        Button buttonNo = dialog.findViewById(R.id.btn_no);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product.setQuatity(mQuantity);
                product.setTotal(mTotal);
                intentToCustomer(product);
            }
        });
        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }
    private  void intentToCustomer(Product mProduct){
        Intent intent = new Intent(ProductDetail.this,CustomerActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(BUNDLE_PRODUCT_DETAIL,mProduct);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
