package com.example.rm31675.braadcastreceiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rm31675.braadcastreceiver.receiver.AlarmReceiver;

public class AlarmActivity extends AppCompatActivity {

    private EditText etTempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        etTempo = (EditText) findViewById(R.id.etTempo);
    }

    public void configurar(View v){

        String tempo = etTempo.getText().toString();
        if(!tempo.equals("")){
            Intent i = new Intent(this, AlarmReceiver.class);
            PendingIntent pi = PendingIntent.getBroadcast(this.getApplicationContext(),1234, i, 0);

            int t = Integer.parseInt(tempo);
            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+(t*1000), pi);

            Toast.makeText(this.getApplicationContext(),"Alarme configurado para daqui a " + t + " segundos!", Toast.LENGTH_SHORT).show();
        }
    }
}
