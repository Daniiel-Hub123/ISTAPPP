package com.g2c2.istappp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.g2c2.istappp.adapter.ConvocatoriasAdaptador;
import com.g2c2.istappp.intefaces.ConvocatoriaAPI;
import com.g2c2.istappp.intefaces.ProcesoanAPI;
import com.g2c2.istappp.model.Convocatoria;
import com.g2c2.istappp.model.ProcesoAN;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ThirdFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    ProgressBar progressBar;
    View view;

    TextView cedula,nombre,siglas,fecha,responsable,empresa,mensaje,titlecedula,
            titlenombre,titlefecha,titleresponsable,titleempresa,titlesiglas;





    public ThirdFragment() {

    }

    public static ThirdFragment newInstance(String param1, String param2) {
        ThirdFragment fragment = new ThirdFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_third, container, false);

        view.findViewById(R.id.button_third).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ThirdFragment.this)
                        .navigate(R.id.action_ThirdFragment_to_FirstFragment);
            }
        });

            progressBar = view.findViewById(R.id.barra);


        titlecedula = view.findViewById(R.id.titlecedulapro);
        titlenombre = view.findViewById(R.id.titlenombrepro);
        titlefecha = view.findViewById(R.id.titlefechapro);
        titleresponsable = view.findViewById(R.id.titleresponsablepro);
        titleempresa = view.findViewById(R.id.titleempresapro);
        titlesiglas = view.findViewById(R.id.titlecarrerapro);



        cedula = view.findViewById(R.id.txtcedulapro);
        nombre = view.findViewById(R.id.txtnombrepro);
        siglas = view.findViewById(R.id.txtcarrerapro);
        fecha = view.findViewById(R.id.txtfechapro);
        responsable = view.findViewById(R.id.txtresponsablepro);
        empresa = view.findViewById(R.id.txtempresapro);
        mensaje = view.findViewById(R.id.txtmensaje);


        //Servicio Practicas


        getParentFragmentManager().setFragmentResultListener("keyced", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey,@NotNull Bundle bundle) {
               String ced = bundle.getString("cedula");
                                                                    //Modificable dependiendo de la dirección IP de la PC
                                                                    //Necesario para servicios Back-End y Fenix
                Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.174.24:8080/")
                        .addConverterFactory(GsonConverterFactory.create()).build();

                ProcesoanAPI procesoanAPI = retrofit.create(ProcesoanAPI.class);
                Call<List<ProcesoAN>> callpan = procesoanAPI.find(ced);

                callpan.enqueue(new Callback<List<ProcesoAN>>() {
                    @Override
                    public void onResponse(Call<List<ProcesoAN>> call, Response<List<ProcesoAN>> response) {

                        List<ProcesoAN> lista = response.body();

                        if (response.isSuccessful() && lista.size() != 0) {

                            for (int i = 0; i < lista.size(); i++) {

                                String estado = lista.get(i).getEstado();

                                if (estado.equals("AN")) {

                                    progressBar.setVisibility(View.GONE);


                                    titlecedula.setVisibility(View.VISIBLE);
                                    titlenombre.setVisibility(View.VISIBLE);
                                    titlefecha.setVisibility(View.VISIBLE);
                                    titleresponsable.setVisibility(View.VISIBLE);
                                    titleempresa.setVisibility(View.VISIBLE);
                                    titlesiglas.setVisibility(View.VISIBLE);

                                    String cedu = lista.get(i).getCedula();
                                    String nomb = lista.get(i).getNombreproyecto();
                                    String sigl = lista.get(i).getSiglas_carrera();
                                    String fech = lista.get(i).getFecha_solicitud();
                                    String resp = lista.get(i).getNombre_responsable();
                                    String title = lista.get(i).getTitulo_responsable();


                                    cedula.setText(cedu);
                                    nombre.setText(nomb);
                                    siglas.setText(sigl);
                                    fecha.setText(fech);
                                    responsable.setText(resp);
                                    empresa.setText(title);



                                }

                            }
                        }
                        else{
                            progressBar.setVisibility(View.GONE);
                            cedula.setVisibility(View.GONE);
                            nombre.setVisibility(View.GONE);
                            siglas.setVisibility(View.GONE);
                            fecha.setVisibility(View.GONE);
                            responsable.setVisibility(View.GONE);
                            empresa.setVisibility(View.GONE);
                            mensaje.setVisibility(View.VISIBLE);



                        }
                    }
                    @Override
                    public void onFailure(Call<List<ProcesoAN>> call, Throwable t) {


                        progressBar.setVisibility(View.GONE);
                        cedula.setVisibility(View.GONE);
                        nombre.setVisibility(View.GONE);
                        siglas.setVisibility(View.GONE);
                        fecha.setVisibility(View.GONE);
                        responsable.setVisibility(View.GONE);
                        empresa.setVisibility(View.GONE);
                        mensaje.setVisibility(View.VISIBLE);



                    }

                });

            }
        });

        return view;
    }





}