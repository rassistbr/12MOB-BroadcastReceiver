package com.example.rm31675.braadcastreceiver.receiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

import com.example.rm31675.braadcastreceiver.AlarmActivity;
import com.example.rm31675.braadcastreceiver.R;

/**
 * Created by rm31675 on 21/11/2016.
 */
public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Alarme disparado!", Toast.LENGTH_LONG).show();
        enviarNotificacao(context);
    }

    private void enviarNotificacao(Context context){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentIntent(PendingIntent.getActivity(context, 0, new Intent(context, AlarmActivity.class), PendingIntent.FLAG_UPDATE_CURRENT));
        builder.setContentTitle("Alarme");
        builder.setContentText("Alarme disparado com sucesso!");
        builder.setTicker("Nova Mensagem");
        builder.setSmallIcon(R.mipmap.ic_launcher);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(100, builder.build());
    }
}
