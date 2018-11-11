package com.anhtnt.swd_project.Model;

import com.google.gson.annotations.SerializedName;

public class RequestCreate {
    @SerializedName("data")
    private String data;
    @SerializedName("status")
    private boolean status;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
