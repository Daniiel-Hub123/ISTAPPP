package com.g2c2.istappp.intefaces;

import com.g2c2.istappp.model.Usuario;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UsuarioAPI {


    @GET("api/auth/user/{email}")
    public Call<Usuario> find(@Path("email") String email);





}
