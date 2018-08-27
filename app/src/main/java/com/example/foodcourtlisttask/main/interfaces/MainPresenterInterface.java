package com.example.foodcourtlisttask.main.interfaces;

import android.text.Editable;

import com.example.foodcourtlisttask.pojos.Store;

import java.util.List;

/**
 * Created by Aya on 27/08/2018.
 */

public interface MainPresenterInterface {
    void getStoresListFromPresenter();
    void returnStoresListFromModel(List<Store> storesList);

    void requestModelSearch(Editable s);
}
