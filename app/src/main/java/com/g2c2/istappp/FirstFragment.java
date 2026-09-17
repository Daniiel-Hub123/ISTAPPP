package com.g2c2.istappp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.g2c2.istappp.databinding.FragmentFirstBinding;
import com.g2c2.istappp.intefaces.ConvocatoriaAPI;
import com.g2c2.istappp.model.Convocatoria;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    Button exit;
    TextView tv;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);

        //Cerrar vista cuenta
        exit = binding.buttonexitlogin;
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                   getActivity().finish();
                } catch (Throwable throwable) {

                }
            }
        });


        return binding.getRoot();

    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        String  codig = getActivity().getIntent().getStringExtra("codigo");
        tv = binding.txtcodcarrera;
        tv.setText(codig);

        String cedula = getActivity().getIntent().getStringExtra("cedula");



        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
                        //Vista Convocatorias
                        Bundle bundle = new Bundle();
                        bundle.putString("codigo",tv.getText().toString());
                        getParentFragmentManager().setFragmentResult("key",bundle);

            }
        });



        binding.buttonTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_ThirdFragment);
                //Vista Proceso Activo
                Bundle bundle = new Bundle();
                bundle.putString("cedula",cedula);
                getParentFragmentManager().setFragmentResult("keyced",bundle);

            }
        });




    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;


    }



}