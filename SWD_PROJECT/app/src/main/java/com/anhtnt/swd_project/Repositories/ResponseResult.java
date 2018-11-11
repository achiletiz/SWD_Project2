package com.anhtnt.swd_project.Repositories;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ResponseResult<T> implements Serializable {
    @SerializedName("data")
    private T data;

    public ResponseResult() {
    }
    public ResponseResult( T data) {
        this.data = data;
    }
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}