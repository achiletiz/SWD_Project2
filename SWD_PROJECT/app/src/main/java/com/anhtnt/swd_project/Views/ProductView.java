package com.anhtnt.swd_project.Views;

import com.anhtnt.swd_project.Model.Product;

import java.util.List;

public interface ProductView {
    void showProduct(List<Product> mProductList);
    void showFail(String message);
}
