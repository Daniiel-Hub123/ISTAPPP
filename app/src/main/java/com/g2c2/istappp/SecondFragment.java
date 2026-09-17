package com.g2c2.istappp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.g2c2.istappp.adapter.ConvocatoriasAdaptador;
import com.g2c2.istappp.databinding.FragmentSecondBinding;
import com.g2c2.istappp.intefaces.ConvocatoriaAPI;
import com.g2c2.istappp.intefaces.UserCarreraAPI;
import com.g2c2.istappp.model.Convocatoria;
import com.g2c2.istappp.model.UsuarioCarrera;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    private RecyclerView recyclerViewConvocatoria;

    private ConvocatoriasAdaptador convocatoriasAdaptador;

    TextView carreracod,nocon;

    Button info;

    String cod;

    ProgressBar progressBar;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        getParentFragmentManager().setFragmentResultListener("key", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull @NotNull String requestKey, @NotNull Bundle result) {
                cod = result.getString("codigo");

            }
        });



        binding = FragmentSecondBinding.inflate(inflater, container, false);

        nocon = binding.nocon;
        progressBar = binding.barrap;

                                                    //Modificable dependiendo de la dirección IP de la PC
                                                    //Necesario para servicios Back-End y Fenix
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.174.24:8080/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        ConvocatoriaAPI convocatoriaAPI = retrofit.create(ConvocatoriaAPI.class);
        Call<List<Convocatoria>> callco = convocatoriaAPI.find();

        callco.enqueue(new Callback<List<Convocatoria>>() {
            @Override
            public void onResponse(Call<List<Convocatoria>> call, Response<List<Convocatoria>> response) {



                if(response.isSuccessful()){

                    nocon.setVisibility(View.GONE);

                    List<Convocatoria> lista = response.body();

                    recyclerViewConvocatoria = (RecyclerView) binding.recyclercon;
                    recyclerViewConvocatoria.setLayoutManager(new LinearLayoutManager(getContext()));

                    convocatoriasAdaptador = new ConvocatoriasAdaptador(lista);

                    progressBar.setVisibility(View.GONE);

                    recyclerViewConvocatoria.setAdapter(convocatoriasAdaptador);


                }else{
                    progressBar.setVisibility(View.GONE);
                    nocon.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<Convocatoria>> call, Throwable t) {

                progressBar.setVisibility(View.GONE);
                nocon.setVisibility(View.VISIBLE);
            }
        });


        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        carreracod = view.findViewById(R.id.txtsiglascon);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });




    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}