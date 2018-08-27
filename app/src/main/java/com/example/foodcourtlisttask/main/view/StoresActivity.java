package com.example.foodcourtlisttask.main.view;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;


import com.example.foodcourtlisttask.R;
import com.example.foodcourtlisttask.main.interfaces.MainPresenterInterface;
import com.example.foodcourtlisttask.main.interfaces.MainViewInterface;
import com.example.foodcourtlisttask.main.presenter.MainPresenterImplementation;
import com.example.foodcourtlisttask.pojos.Store;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StoresActivity extends AppCompatActivity implements MainViewInterface {

    @BindView(R.id.storesRecyclerView)  RecyclerView storesRecyclerView;
    @BindView(R.id.toolbar)Toolbar toolbar;
    @BindView(R.id.searchEditText)EditText searchEditText;
    MainPresenterInterface mainPresenter;
    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stores);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        mainPresenter=new MainPresenterImplementation(this,StoresActivity.this);

        //set view details of recycler view
        layoutManager = new LinearLayoutManager(this);
        storesRecyclerView.setLayoutManager(layoutManager);
        storesRecyclerView.setHasFixedSize(true);
        //call method in presenter to request data
        mainPresenter.getStoresListFromPresenter();

        searchEditText.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                mainPresenter.requestModelSearch(s);
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {

            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                mainPresenter.requestModelSearch((Editable) s);
            }
        });

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if ( v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent( event );
    }
    @Override
    public void displayStoresList(List<Store> storesList) {
        RecyclerViewDecorator dividerItemDecoration = new RecyclerViewDecorator(StoresActivity.this);
        storesRecyclerView.addItemDecoration(dividerItemDecoration);
        recyclerViewAdapter=new RecyclerViewAdapter(StoresActivity.this,storesList);
        storesRecyclerView.setAdapter(recyclerViewAdapter);
    }

}
