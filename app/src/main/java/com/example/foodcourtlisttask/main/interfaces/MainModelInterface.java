package com.example.foodcourtlisttask.main.interfaces;

import android.text.Editable;

import com.example.foodcourtlisttask.pojos.Store;

import java.util.List;

/**
 * Created by Aya on 27/08/2018.
 */

public interface MainModelInterface {
    void getStoresListFromModel();
    void returnStoresListFromApi(List<Store> storesList);
    void requestPresenterSearch(Editable s);
}
