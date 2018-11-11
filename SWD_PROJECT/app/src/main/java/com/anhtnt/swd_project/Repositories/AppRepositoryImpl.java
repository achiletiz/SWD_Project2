package com.anhtnt.swd_project.Repositories;

import android.content.Context;

import com.anhtnt.swd_project.Model.Product;
import com.anhtnt.swd_project.Model.RequestCreate;
import com.anhtnt.swd_project.Utils.ClientApi;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppRepositoryImpl  implements  AppRepository {
    @Override
    public void getTatCaSanPham(Context context,  final CallBackData<List<Product>> callBackData) {
        ClientApi clientApi = new ClientApi();
        Call<ResponseBody> serviceCall = clientApi.appService().getJsonSanPham();
        serviceCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response != null && response.body() != null) {
                    if (response.code() == 200) {
                        try {
                            String result = response.body().string();
                            Type type = new TypeToken<ResponseResult<List<Product>>>() {
                            }.getType();
                            ResponseResult<List<Product>> responseResult =
                                    new Gson().fromJson(result, type);

                            if (responseResult.getData() == null) {
                                callBackData.onFail(response.message());
                            } else {
                                List<Product> mProducts = responseResult.getData();
                                // Log.e("List Product", categogyArrayList.toString());
                                callBackData.onSuccess(mProducts);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    callBackData.onFail("Server error");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBackData.onFail("Tải dữ liệu thất bại");
            }
        });
    }

    @Override
    public void createOrder(Context context, int productId, int quantity, final CallBackData<RequestCreate> callBackData) {
        ClientApi clientApi = new ClientApi();
        Call<ResponseBody> serviceCall = clientApi.appService().createOrder(productId,quantity);
        serviceCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response != null && response.body() != null) {
                    if (response.code() == 200) {
                        try {
                            String result = response.body().string();
                            Type type = new TypeToken<ResponseResult<RequestCreate>>() {
                            }.getType();
                            ResponseResult<RequestCreate> responseResult =
                                    new Gson().fromJson(result, type);

                            if (responseResult.getData() == null) {
                                callBackData.onFail(response.message());
                            } else {
                                RequestCreate mPrRequestCreate = responseResult.getData();
                                // Log.e("List Product", categogyArrayList.toString());
                                callBackData.onSuccess(mPrRequestCreate);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    callBackData.onFail("Server error");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBackData.onFail("Tải dữ liệu thất bại");
            }
        });
    }

    @Override
    public void createCustomer(Context context, String name, String address, String gender, String phone,final CallBackData<RequestCreate> callBackData) {
        ClientApi clientApi = new ClientApi();
        Call<ResponseBody> serviceCall = clientApi.appService().createCustomer(name,address,gender,phone);
        serviceCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response != null && response.body() != null) {
                    if (response.code() == 200) {
                        try {
                            String result = response.body().string();
                            Type type = new TypeToken<ResponseResult<RequestCreate>>() {
                            }.getType();
                            ResponseResult<RequestCreate> responseResult =
                                    new Gson().fromJson(result, type);

                            if (responseResult.getData() == null) {
                                callBackData.onFail(response.message());
                            } else {
                                RequestCreate mPrRequestCreate = responseResult.getData();
                                // Log.e("List Product", categogyArrayList.toString());
                                callBackData.onSuccess(mPrRequestCreate);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    callBackData.onFail("Server error");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBackData.onFail("Tải dữ liệu thất bại");
            }
        });
    }
}
