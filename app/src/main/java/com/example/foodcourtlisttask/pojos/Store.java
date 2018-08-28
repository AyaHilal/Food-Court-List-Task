package com.example.foodcourtlisttask.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Aya on 27/08/2018.
 */

public class Store{

    @SerializedName("StoreID")
    @Expose
    int id;

    @SerializedName("StoreLogo")
    @Expose
    String image;

    @SerializedName("StoreName")
    @Expose
    String name;


    @SerializedName("StoreDescription")
    @Expose
    String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
