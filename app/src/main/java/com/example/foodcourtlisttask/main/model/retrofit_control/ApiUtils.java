package com.example.foodcourtlisttask.main.model.retrofit_control;

/**
 * Created by Aya on 27/08/2018.
 */

public class ApiUtils {
    public static final String BASE_URL =  "http://188.166.81.130/staging/public/";

    public static Service getServiceStores() {

        return RetrofitClient.getClient(BASE_URL).create(Service.class);
    }
}
