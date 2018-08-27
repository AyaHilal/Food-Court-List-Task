package com.example.foodcourtlisttask.main.model.retrofit_control;

import com.example.foodcourtlisttask.pojos.Store;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Aya on 27/08/2018.
 */

public interface Service {
    @GET("stores.json")
    Call<List<Store>> getStoresList();
}
