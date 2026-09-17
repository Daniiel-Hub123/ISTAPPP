package com.g2c2.istappp.intefaces;

import com.g2c2.istappp.model.Carrera;
import com.g2c2.istappp.model.Usuario;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CarreraAPI {



    @GET("api/carreras/nombre/{codigo}")
    public Call<Carrera> findCarrera(@Path("codigo") String codigo);



}
