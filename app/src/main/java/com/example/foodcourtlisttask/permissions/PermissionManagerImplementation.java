package com.example.foodcourtlisttask.permissions;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by Aya on 28/08/2018.
 */

public class PermissionManagerImplementation implements PermissionManagerInterface{
    Context context;
    public  PermissionManagerImplementation(Context context)
    {
        this.context=context;
    }

    @Override
    public boolean checkConnectivity() {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
