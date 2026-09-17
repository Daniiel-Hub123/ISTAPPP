package com.g2c2.istappp.notify;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;


import com.g2c2.istappp.model.Convocatoria;

import java.util.List;

public class NotificacionConvocatoria extends Service {


    private static final String TAG = "NotificacíonConvocatoriaService";
    List<Convocatoria> lista;


    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {
        super.onCreate();

        if(lista.size()<1){
               

        }


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }




}

