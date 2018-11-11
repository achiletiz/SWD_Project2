package com.anhtnt.swd_project.Utils;

import com.anhtnt.swd_project.Connect.connectionString;

public class ConfigApi {
    public  static  final  String BASE_URL = connectionString.localhost;
    public  interface  Api {
        String GET_PRODUCT_Tat_Ca_San_Pham = "products/getAll";
        String CREATE_ORDER = "orders/create";
        String CREATE_CUSTOMER="customers/create";
    }
}
