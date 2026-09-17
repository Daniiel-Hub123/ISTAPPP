package com.g2c2.istappp.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.g2c2.istappp.R;
import com.g2c2.istappp.model.Convocatoria;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ConvocatoriasAdaptador extends RecyclerView.Adapter<ConvocatoriasAdaptador.ViewHolder> {


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView nombreProyecto,siglasCarrera,fecha;
        private Button aplicar;
        Context context;

        public ViewHolder(View itemView) {
            super(itemView);
            nombreProyecto = (TextView) itemView.findViewById(R.id.txtnombrecon);
            siglasCarrera = (TextView) itemView.findViewById(R.id.txtsiglascon);
            fecha = (TextView) itemView.findViewById(R.id.txtfechacon);
            aplicar = (Button) itemView.findViewById(R.id.btnaplicarcon);
            context = itemView.getContext();
        }

        void setOnClickListeners(){
                aplicar.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            Uri uri = Uri.parse("https://www.tecazuay.edu.ec");
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            context.startActivity(intent);

        }
    }


    public List<Convocatoria> listaConvocatorias;

    public ConvocatoriasAdaptador(List<Convocatoria> listaConvocatorias) {
        this.listaConvocatorias=listaConvocatorias;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_convocatoria,parent,false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nombreProyecto.setText(listaConvocatorias.get(position).getNombreProyecto());
        holder.siglasCarrera.setText(listaConvocatorias.get(position).getSiglasCarrera());
        holder.fecha.setText(listaConvocatorias.get(position).getFecha());

        holder.setOnClickListeners();

    }


    @Override
    public int getItemCount() {

        return listaConvocatorias.size();

    }






}
