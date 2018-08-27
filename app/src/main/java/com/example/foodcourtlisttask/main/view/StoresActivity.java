package com.example.foodcourtlisttask.main.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;


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

    }


    @Override
    public void displayStoresList(List<Store> storesList) {
        RecyclerViewDecorator dividerItemDecoration = new RecyclerViewDecorator(StoresActivity.this);
        storesRecyclerView.addItemDecoration(dividerItemDecoration);
        recyclerViewAdapter=new RecyclerViewAdapter(StoresActivity.this,storesList);
        storesRecyclerView.setAdapter(recyclerViewAdapter);
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate( R.menu.search_item, menu);
//        MenuItem myActionMenuItem = menu.findItem( R.id.action_search);
//        final SearchView searchView = (SearchView) myActionMenuItem.getActionView();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                if (TextUtils.isEmpty(newText)) {
//
//                } else {
//                }
//                return true;
//            }
//        });
//
//        return true;
//    }

}
