package com.g2c2.istappp.model;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Carrera {

    private Integer id;
    private String nombre;
    private String descripcion;
    private String actividades;
    private String coordinador;
    private String encargado;
    private static List<Carrera> lista =new ArrayList<Carrera>();


    private static Cursor cursor;

    public Carrera(String nombre, String descripcion, String actividades, String coordinador, String encargado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.actividades = actividades;
        this.coordinador = coordinador;
        this.encargado = encargado;
    }



    public static Cursor getCursor(Context mc, String name) {
        BaseSQLHelper baseSQLHelper=new BaseSQLHelper(mc);
        String sql="SELECT _rowid_ as _id , nombre,descripcion,actividades,coordinador,encargado FROM carrera WHERE nombre like '%"+name+"%' ";
        cursor = baseSQLHelper.query(sql);
        Log.i("NumberGenerated", sql);
        // baseSQLHelper.close();
        return cursor;
    }

    public static List<Carrera> getLista() {

        return lista;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getActividades() {
        return actividades;
    }

    public void setActividades(String actividades) {
        this.actividades = actividades;
    }

    public String getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(String coordinador) {
        this.coordinador = coordinador;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }
}
