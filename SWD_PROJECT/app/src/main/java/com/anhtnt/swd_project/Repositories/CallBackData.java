package com.anhtnt.swd_project.Repositories;

public interface CallBackData<T> {
    void onSuccess(T t);

    void onFail(String message);
}