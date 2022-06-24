package com.rcdu.medu.connectivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ConnectionCheck extends BroadcastReceiver {

    public static ConnectivityReceiverListener connectivityReceiverListener;

    public ConnectionCheck() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent arg1) {

        int status = NetworkUtils.getConnectivityStatus(context);

        if (connectivityReceiverListener != null) {
            connectivityReceiverListener.onNetworkConnectionChanged(status);
        }
    }

     public static int isConnected(Context context) {
        return NetworkUtils.getConnectivityStatus(context);
    }


    public interface ConnectivityReceiverListener {
        void onNetworkConnectionChanged(int status);
    }
}
