package com.g2c2.istappp.model;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProcesoAN {


    private String cedula;
    private String nombreproyecto;
    private String siglas_carrera;
    private Date fecha_solicitud;
    private String nombre_responsable;
    private String titulo_responsable;
    private String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombreproyecto() {
        return nombreproyecto;
    }

    public void setNombreproyecto(String nombreproyecto) {
        this.nombreproyecto = nombreproyecto;
    }

    public String getSiglas_carrera() {
        return siglas_carrera;
    }

    public void setSiglas_carrera(String siglas_carrera) {
        this.siglas_carrera = siglas_carrera;
    }



    @SuppressLint("SimpleDateFormat")
    public String getFecha_solicitud() {
        Date myDate = fecha_solicitud;
        return  new SimpleDateFormat("dd-MM-yyyy").format(myDate);

    }





    public void setFecha_solicitud(Date fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
    }

    public String getNombre_responsable() {
        return nombre_responsable;
    }

    public void setNombre_responsable(String nombre_responsable) {
        this.nombre_responsable = nombre_responsable;
    }

    public String getTitulo_responsable() {
        return titulo_responsable;
    }

    public void setTitulo_responsable(String titulo_responsable) {
        this.titulo_responsable = titulo_responsable;
    }
}
