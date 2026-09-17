package com.g2c2.istappp.intefaces;

import com.g2c2.istappp.model.Convocatoria;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ConvocatoriaAPI {

    @GET("api/anexo2/listarconvocatorias/all")
    public Call<List<Convocatoria>> find();

}
