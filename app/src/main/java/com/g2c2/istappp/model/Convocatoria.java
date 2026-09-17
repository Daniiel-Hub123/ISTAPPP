package com.g2c2.istappp.model;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Convocatoria {

    private String nombreProyecto;
    private String siglasCarrera;
    private Date fecha;


    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getSiglasCarrera() {
        return siglasCarrera;
    }

    public void setSiglasCarrera(String siglasCarrera) {
        this.siglasCarrera = siglasCarrera;
    }

    @SuppressLint("SimpleDateFormat")
    public String getFecha() {

        Date myDate = fecha;

        return new SimpleDateFormat("dd-MM-yyyy").format(myDate);
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
