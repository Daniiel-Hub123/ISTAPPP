package com.g2c2.istappp.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BaseSQLHelper extends SQLiteOpenHelper {

    private static final String BASE= "PracticasISTA.db";
    Context miContext;
    public BaseSQLHelper(@Nullable Context context) {
        super(context,  BASE,  null, 3);
        //DEfinimos la ubicacion de la base en el dispositivo:
        miContext=context;
        File rutaArchivo=miContext.getDatabasePath(BASE);
        //Copiar la base completa

        try {
            if(!existeBase(rutaArchivo.getAbsolutePath())){//Copio solo si no existe.
                copiarBase(rutaArchivo);
            }
        } catch (Exception e) {
            copiarBase(rutaArchivo);
            e.printStackTrace();
        }


        // verificamos que exita.

    }
    private void copiarBase(File rutaArchivo){
        try {
            InputStream inputStream=miContext.getAssets().open(BASE);//Abrimos desde el proyecto
            OutputStream outputStream=new FileOutputStream(rutaArchivo);//Copiamos en el dispositivo
            byte[] buffer=new byte[1024];
            int largo;
            while((largo=inputStream.read(buffer))>0){
                outputStream.write(buffer,0,largo);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private boolean existeBase(String ruta) throws Exception {
        SQLiteDatabase siDB=null;

        siDB= SQLiteDatabase.openDatabase(ruta,null,SQLiteDatabase.OPEN_READONLY);

        if(siDB!=null) {//si le encuentro solo le cierro.
            siDB.close();
            return true;
        }
        return false;
    }
    //DEFINIMOS LOS METODOS DE CONSULTA Y ACCIONES A LA BASE
    public void noQuery(String sql){
        this.getWritableDatabase().execSQL(sql);
    }
    public Cursor query(String sql){
        return this.getReadableDatabase().rawQuery(sql,null);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }








}
