package com.g2c2.istappp.model;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

public class Usuario {


    private Integer id;
    private String cedula;
    private String nombrescompletos;
    private String rol;
    private String email;

    private static Cursor cursor;


    public Usuario(Integer id, String cedula, String nombrescompletos, String rol,String email) {
        this.id = id;
        this.cedula = cedula;
        this.nombrescompletos = nombrescompletos;
        this.rol = rol;
        this.email = email;
    }

    public static Cursor getCursor(Context mc, String email) {
        BaseSQLHelper baseSQLHelper=new BaseSQLHelper(mc);
        String sql="SELECT _rowid_ as _id ,* FROM usuario WHERE email like '%"+email+"%' ";
        cursor = baseSQLHelper.query(sql);
        Log.i("NumberGenerated", sql);

        return cursor;
    }

    public void guardar(Context mc){

        BaseSQLHelper tiendaSQLHelper=new BaseSQLHelper(mc);
        String sql="INSERT INTO usuario (id_usuario,cedula,nombrescompletos,rol,foto,email)\n" +
                "     VALUES (null,'"+getCedula()+"','"+getNombrescompletos()+"', '"+getRol()+"',null,'"+getEmail()+"')";
        tiendaSQLHelper.noQuery(sql);
        tiendaSQLHelper.close();

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombrescompletos() {
        return nombrescompletos;
    }

    public void setNombrescompletos(String nombrescompletos) {
        this.nombrescompletos = nombrescompletos;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
