package com.example.rm31675.braadcastreceiver.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by rm31675 on 21/11/2016.
 */
public class MyOrderedReceiver1 extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Receiver 1", Toast.LENGTH_LONG).show();
    }
}
