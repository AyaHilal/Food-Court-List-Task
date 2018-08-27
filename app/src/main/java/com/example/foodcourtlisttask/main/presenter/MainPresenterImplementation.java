package com.example.foodcourtlisttask.main.presenter;

import android.content.Context;
import android.text.Editable;


import com.example.foodcourtlisttask.main.interfaces.MainModelInterface;
import com.example.foodcourtlisttask.main.interfaces.MainPresenterInterface;
import com.example.foodcourtlisttask.main.interfaces.MainViewInterface;
import com.example.foodcourtlisttask.main.model.MainListImplementation;
import com.example.foodcourtlisttask.pojos.Store;

import java.util.List;

/**
 * Created by Aya on 27/08/2018.
 */

public class MainPresenterImplementation implements MainPresenterInterface {
    MainViewInterface mainView;
    MainModelInterface mainModel;
    Context context;

   public MainPresenterImplementation(MainViewInterface mainViewInterface, Context context){
    this.mainView=mainViewInterface;
    this.context=context;
    mainModel=new MainListImplementation(this,context);

    }

    @Override
    public void getStoresListFromPresenter() {
        mainModel.getStoresListFromModel();
    }

    @Override
    public void returnStoresListFromModel(List<Store> storesList) {
        mainView.displayStoresList(storesList);
    }

    @Override
    public void requestModelSearch(Editable s) {
         mainModel.requestPresenterSearch(s);
    }
}
