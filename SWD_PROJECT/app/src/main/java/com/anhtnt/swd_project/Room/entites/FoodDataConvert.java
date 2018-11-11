package com.anhtnt.swd_project.Room.entites;
import android.arch.persistence.room.TypeConverter;

import com.anhtnt.swd_project.Model.Product;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

    public class FoodDataConvert {
        @TypeConverter // note this annotation
        public String fromFoodList(Product product) {
            if (product == null) {
                return (null);
            }
            Gson gson = new Gson();
            Type type = new TypeToken<Product>() {
            }.getType();
            String json = gson.toJson(product, type);
            return json;
        }

        @TypeConverter // note this annotation
        public Product toExtraList(String productString) {
            if (productString == null) {
                return (null);
            }
            Gson gson = new Gson();
            Type type = new TypeToken<Product>() {
            }.getType();
            Product cardType = gson.fromJson(productString, type);
            return cardType;
        }
    }

