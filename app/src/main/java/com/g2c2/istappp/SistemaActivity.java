package com.g2c2.istappp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import com.g2c2.istappp.intefaces.ConvocatoriaAPI;
import com.g2c2.istappp.model.Convocatoria;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.g2c2.istappp.databinding.ActivitySistemaBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SistemaActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivitySistemaBinding binding;
    String codigo,cedula;
    private static final String CHANNEL_ID = "canal";
    private PendingIntent pendingIntent;
    private final static int NOTIFICACION_ID = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySistemaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_sistema);
        appBarConfiguration = new AppBarConfiguration.Builder(
                navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "INSTITUTO SUPERIOR TECNOLÓGICO DEL AZUAY / ISTA", Snackbar.LENGTH_LONG)
                        .setAction("ISTA", null).show();
            }
        });

        codigo = getIntent().getStringExtra("codigo");
        TextView tv =  findViewById(R.id.txtcodcarrera);
        tv.setText(codigo);
                                                        //Modificable dependiendo de la dirección IP de la PC
                                                        //Necesario para servicios Back-End y Fenix
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.174.24:8080/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        ConvocatoriaAPI convocatoriaAPI = retrofit.create(ConvocatoriaAPI.class);
        Call<List<Convocatoria>> callco = convocatoriaAPI.find();

        callco.enqueue(new Callback<List<Convocatoria>>() {
            @Override
            public void onResponse(Call<List<Convocatoria>> call, Response<List<Convocatoria>> response) {
                Notify2();
                Notify();
            }

            @Override
            public void onFailure(Call<List<Convocatoria>> call, Throwable t) {

            }
        });
    }



    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_sistema);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }



    private void Notify() {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_baseline_assignment_24);
        builder.setContentTitle("Practicas Preprofesionales ISTA");
        builder.setContentText("Podrian existir convocatorias nuevas, revise la pestaña correspondiente");
        builder.setColor(Color.YELLOW);
        builder.setPriority(NotificationCompat.PRIORITY_HIGH);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
        notificationManagerCompat.notify(NOTIFICACION_ID,builder.build());

    }


    private void Notify2(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "Notificacion";
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,name, NotificationManager.IMPORTANCE_HIGH);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);



        }
    }

}