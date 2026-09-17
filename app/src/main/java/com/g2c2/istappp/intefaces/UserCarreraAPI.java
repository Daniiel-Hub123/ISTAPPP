package com.g2c2.istappp.intefaces;


import com.g2c2.istappp.model.UsuarioCarrera;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserCarreraAPI {

    @GET("api/auth/obtenercarrera/{cedula}")
    public Call<UsuarioCarrera> find(@Path("cedula") String cedula);

}
