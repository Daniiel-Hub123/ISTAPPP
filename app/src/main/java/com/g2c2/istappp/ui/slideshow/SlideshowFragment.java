package com.g2c2.istappp.ui.slideshow;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;


import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.g2c2.istappp.R;
import com.g2c2.istappp.databinding.FragmentSlideshowBinding;
import com.g2c2.istappp.model.Carrera;

import org.w3c.dom.Text;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    private FragmentSlideshowBinding binding;


    private View root;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
         root = binding.getRoot();

        final TextView textView = binding.cartitlebuscar;
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        Button btnAceptar = (Button) root.findViewById(R.id.btnbuscar);
        btnAceptar.setOnClickListener(aceptarL);




        return root;
    }


    View.OnClickListener aceptarL=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            EditText name = root.findViewById(R.id.editxtCarrera);
            TextView titulo = root.findViewById(R.id.titulocarrera);
            TextView descripcion = root.findViewById(R.id.txtdescripcion);
            TextView coordinador = root.findViewById(R.id.editTextcoord);
            TextView encargado = root.findViewById(R.id.editTextencarg);
            TextView actividades = root.findViewById(R.id.txtactividades);
            ImageView img = root.findViewById(R.id.fotocarrera);
            TextView txtcord = root.findViewById(R.id.coordcar);
            TextView txtencar = root.findViewById(R.id.encargcar);
            TextView txtact = root.findViewById(R.id.actividades);

            Log.i("NumberGenerated", String.valueOf(name.getText()));
            Editable texto = name.getText();
            Cursor cCarrera= Carrera.getCursor(getContext(),texto.toString());

            cCarrera.moveToFirst();
            int cont = cCarrera.getCount();
            Log.i("NumberGenerated", String.valueOf(cont));

            if(cont > 0 || cCarrera.moveToFirst()) {

                img.setVisibility(View.VISIBLE);
                txtcord.setVisibility(View.VISIBLE);
                txtencar.setVisibility(View.VISIBLE);
                txtact.setVisibility(View.VISIBLE);
                titulo.setText(cCarrera.getString(cCarrera.getColumnIndexOrThrow("nombre")));
                descripcion.setText(cCarrera.getString(cCarrera.getColumnIndexOrThrow("descripcion")));
                coordinador.setText(cCarrera.getString(cCarrera.getColumnIndexOrThrow("coordinador")));
                encargado.setText(cCarrera.getString(cCarrera.getColumnIndexOrThrow("encargado")));
                actividades.setText(cCarrera.getString(cCarrera.getColumnIndexOrThrow("actividades")));



            } else {
                Toast.makeText(getContext(),"No existe la carrera", Toast.LENGTH_LONG).show();
                cCarrera.close();

            }


            cCarrera.close();

/*

            String[] desde =new String[]{"nombre","descripcion","actividades", "coordinador", "encargado"};
            int[] hasta=new int[]{R.id.titulocarrera,R.id.txtdescripcion,R.id.txtactividades,R.id.editTextcoord,
                    R.id.editTextencarg};
            CursorAdapter cursorAdapter= new SimpleCursorAdapter(
                    getContext(), R.layout.fragment_slideshow,cCarrera,desde,hasta,0
            );

*/

        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}