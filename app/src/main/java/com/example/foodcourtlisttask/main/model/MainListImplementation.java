package com.example.foodcourtlisttask.main.model;

import android.content.Context;
import android.text.Editable;


import com.example.foodcourtlisttask.main.interfaces.ApiManagerInterface;
import com.example.foodcourtlisttask.main.interfaces.MainModelInterface;
import com.example.foodcourtlisttask.main.interfaces.MainPresenterInterface;
import com.example.foodcourtlisttask.main.presenter.MainPresenterImplementation;
import com.example.foodcourtlisttask.pojos.Store;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aya on 27/08/2018.
 */

public class MainListImplementation implements MainModelInterface {

    MainPresenterInterface mainPresenter;
    Context context;
    ApiManagerInterface apiManager;
    List<Store> storesList;
    List<Store>searchResultList;

    public MainListImplementation(MainPresenterImplementation mainPresenterImplementation, Context context) {
    this.mainPresenter=mainPresenterImplementation;
    this.context=context;
    apiManager=new ApiManager(this,context);

    }

    @Override
    public void getStoresListFromModel() {
        apiManager.getStoresListFromApi();
    }

    @Override
    public void returnStoresListFromApi(List<Store> storesList) {
        mainPresenter.returnStoresListFromModel(storesList);
        this.storesList=storesList;
    }

    @Override
    public void requestPresenterSearch(Editable s)
    {
        searchResultList=new ArrayList<Store>();
        if(!s.toString().isEmpty()) {
            for (Store store:storesList)
            {
                String storeName = store.getName();
                if(storeName.contains(s))
                {
                    searchResultList.add(store);
                }
            }
            mainPresenter.returnStoresListFromModel(searchResultList);
        }
        else{
            mainPresenter.returnStoresListFromModel(storesList);
        }
    }
}
