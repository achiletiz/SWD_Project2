package com.anhtnt.swd_project.Repositories;

import com.anhtnt.swd_project.Utils.ConfigApi;
import com.google.gson.annotations.SerializedName;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AppService {
    @POST(ConfigApi.Api.GET_PRODUCT_Tat_Ca_San_Pham)
    Call<ResponseBody> getJsonSanPham();
    @FormUrlEncoded
    @GET(ConfigApi.Api.CREATE_CUSTOMER)
    Call<ResponseBody> createCustomer(
            @Field("name") String name,
            @Field("address") String address,
            @Field("gender") String gender,
            @Field("phone") String phone
            );
    @FormUrlEncoded
    @GET(ConfigApi.Api.CREATE_ORDER)
    Call<ResponseBody> createOrder(
            @Field("productId") int productId,
            @Field("quantity") int quatity
    );
}
