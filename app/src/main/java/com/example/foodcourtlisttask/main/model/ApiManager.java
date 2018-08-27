package com.example.foodcourtlisttask.main.model;

import android.content.Context;
import android.util.Log;

import com.example.foodcourtlisttask.main.interfaces.ApiManagerInterface;
import com.example.foodcourtlisttask.main.interfaces.MainModelInterface;
import com.example.foodcourtlisttask.main.model.retrofit_control.ApiUtils;
import com.example.foodcourtlisttask.main.model.retrofit_control.Service;
import com.example.foodcourtlisttask.pojos.Store;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Aya on 27/08/2018.
 */

public class ApiManager implements ApiManagerInterface {
    MainModelInterface mainModel;
    Context context;

    public ApiManager(MainModelInterface mainModel,Context context){
        this.mainModel=mainModel;
        this.context=context;
    }

    @Override
    public void getStoresListFromApi() {
        Service apiService= ApiUtils.getServiceStores();
        apiService.getStoresList().enqueue(new Callback<List<Store>>() {
            @Override
            public void onResponse(Call<List<Store>> call, Response<List<Store>> response) {
                Log.i("myTag", "name" + response.body().get(0).getName());
                mainModel.returnStoresListFromApi(response.body());
            }

            @Override
            public void onFailure(Call<List<Store>> call, Throwable t) {
                Log.i("myTag", t.getMessage());

            }
        });

    }
}
