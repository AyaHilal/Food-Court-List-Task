package com.example.foodcourtlisttask.main.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.foodcourtlisttask.R;
import com.example.foodcourtlisttask.pojos.Store;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Aya on 27/08/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.viewHolder> {

    List<Store> storesList;
    Context context;
    public RecyclerViewAdapter(Context context, List<Store> storesList) {
        this.storesList=storesList;
        this.context=context;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_recycler,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
       holder.storeName.setText(storesList.get(position).getName());
       holder.storeDescription.setText(storesList.get(position).getDescription());
       String imageUrl = storesList.get(position).getImage();
        Log.i("myTag", "url " + imageUrl);
//        Picasso.with(context).load(imageUrl).into(holder.storeImage);
        Glide.with(context).load(imageUrl).into(holder.storeImage);

    }

    @Override
    public int getItemCount() {
        return storesList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.storeImage) ImageView storeImage;
        @BindView(R.id.storeName)  TextView storeName;
        @BindView(R.id.storeDescription) TextView storeDescription;

        public viewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

    }

    }

