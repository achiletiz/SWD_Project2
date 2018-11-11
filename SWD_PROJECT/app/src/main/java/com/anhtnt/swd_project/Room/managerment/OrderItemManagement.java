package com.anhtnt.swd_project.Room.managerment;

import android.app.Application;
import android.database.sqlite.SQLiteConstraintException;
import android.os.AsyncTask;

import com.anhtnt.swd_project.Room.dao.ProductDao;
import com.anhtnt.swd_project.Room.database.AppDatabase;
import com.anhtnt.swd_project.Room.entites.OrderItem;

import java.util.List;

public class OrderItemManagement  {
    private ProductDao mProductDao;
    private Application mApplication;
    public OrderItemManagement(Application mApplication) {
        this.mApplication = mApplication;
        AppDatabase mAppDatabase = AppDatabase.getDatabase(mApplication);
        mProductDao = mAppDatabase.mProductDao();

    }
    public void getAllOrderItemEntity(OnDataCallBackOrderData listener) {
        GetAllOrderItemAsync getOrderAsync = new GetAllOrderItemAsync(mProductDao, listener);
        getOrderAsync.execute();
    }
    public void addOrderItem(OrderItem orderItem) {
        AddOrderItemAsyn addOrderItemAsyn = new AddOrderItemAsyn(mProductDao);
        addOrderItemAsyn.execute(orderItem);
    }
    private class GetAllOrderItemAsync extends AsyncTask<List<OrderItem>, Void, Void> {
        private ProductDao mFoodDao;
        private List<OrderItem> mListOrderItem;
        private OnDataCallBackOrderData mListener;

        public GetAllOrderItemAsync(ProductDao foodDAO, OnDataCallBackOrderData listener){
            this.mFoodDao= foodDAO;
            this.mListener= listener;
        }
        @Override
        protected Void doInBackground(List<OrderItem>... lists) {
            try{
                mListOrderItem= mFoodDao.getAllOrderItemEntity();
            }catch (SQLiteConstraintException e){

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(mListOrderItem!= null){
                mListener.onDataSuccess(mListOrderItem);
            }else {
                mListener.onDataFail("Lấy thông tin giỏ hàng thất bại!");
            }
        }
    }
    private class AddOrderItemAsyn extends AsyncTask<OrderItem, Void, Void> {
        private ProductDao mFoodDao;
        public AddOrderItemAsyn(ProductDao mFoodDao) {
            this.mFoodDao = mFoodDao;
        }
        @Override
        protected Void doInBackground(OrderItem... orderItem) {
            mFoodDao.insertOrderItem(orderItem);
            return null;
        }
    }
    public interface OnDataCallBackOrderData {
        void onDataSuccess(List<OrderItem> orderItemEntityList);

        void onDataFail(String message);
    }
}
