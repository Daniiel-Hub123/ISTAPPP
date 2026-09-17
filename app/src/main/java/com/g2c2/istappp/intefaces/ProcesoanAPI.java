package com.g2c2.istappp.intefaces;

import com.g2c2.istappp.model.ProcesoAN;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProcesoanAPI {


    @GET("api/anexo3/allByCedula/{cedula}")
    public Call<List<ProcesoAN>> find(@Path("cedula") String cedula);


}
