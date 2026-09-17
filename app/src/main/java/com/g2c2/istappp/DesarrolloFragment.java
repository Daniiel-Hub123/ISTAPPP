package com.g2c2.istappp;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.g2c2.istappp.anexos.cuarto.AnexoCFragment;
import com.g2c2.istappp.anexos.decimo.AnexoDIFragment;
import com.g2c2.istappp.anexos.decimoprimero.AnexoDPFragment;
import com.g2c2.istappp.anexos.decimosegundo.AnexoDOCUFragment;
import com.g2c2.istappp.anexos.decimosegundo.AnexoDOFragment;
import com.g2c2.istappp.anexos.decimotercero.AnexoDTFragment;
import com.g2c2.istappp.anexos.noveno.AnexoNFragment;
import com.g2c2.istappp.anexos.primero.AnexoUFragment;
import com.g2c2.istappp.anexos.segundo.AnexoDFragment;
import com.g2c2.istappp.anexos.tercero.AnexoTFragment;
import com.g2c2.istappp.anexos.tercero.AnexoTUFragment;

public class DesarrolloFragment extends Fragment {

    private DesarrolloViewModel mViewModel;
    View root;

    public static DesarrolloFragment newInstance() {
        return new DesarrolloFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        root =  inflater.inflate(R.layout.desarrollo_fragment, container, false);


        //Anexo 9
        TextView textView9 = root.findViewById(R.id.titulo12);
        textView9.setOnClickListener(aceptar9);

        //Anexo 10
        TextView textView10 = root.findViewById(R.id.titulo14);
        textView10.setOnClickListener(aceptar10);

        //Anexo 11
        TextView textView11 = root.findViewById(R.id.titulo15);
        textView11.setOnClickListener(aceptar11);

        //Anexo 12
        TextView textView12 = root.findViewById(R.id.titulo16);
        textView12.setOnClickListener(aceptar12);

        //Anexo 121
        TextView textView121 = root.findViewById(R.id.titulo17);
        textView121.setOnClickListener(aceptar121);


        return root;
    }

    View.OnClickListener aceptar9=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment = new AnexoNFragment();
            ocultarCampos();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .add(R.id.layoutanexo3,fragment,"fragment_tag9")
                    .addToBackStack("fragment_tag9")
                    .setReorderingAllowed(true)
                    .commit();
        }
    };


    View.OnClickListener aceptar10=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment = new AnexoDIFragment();
            ocultarCampos();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .add(R.id.layoutanexo3,fragment,"fragment_tag10")
                    .addToBackStack("fragment_tag10")
                    .setReorderingAllowed(true)
                    .commit();
        }
    };


    View.OnClickListener aceptar11=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment = new AnexoDPFragment();
            ocultarCampos();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .add(R.id.layoutanexo3,fragment,"fragment_tag11")
                    .addToBackStack("fragment_tag11")
                    .setReorderingAllowed(true)
                    .commit();
        }
    };


    View.OnClickListener aceptar12=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment = new AnexoDOFragment();
            ocultarCampos();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .add(R.id.layoutanexo3,fragment,"fragment_tag12")
                    .addToBackStack("fragment_tag12")
                    .setReorderingAllowed(true)
                    .commit();
        }
    };


    View.OnClickListener aceptar121=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment = new AnexoDOCUFragment();
            ocultarCampos();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .add(R.id.layoutanexo3,fragment,"fragment_tag121")
                    .addToBackStack("fragment_tag121")
                    .setReorderingAllowed(true)
                    .commit();
        }
    };


    public void ocultarCampos(){

        TextView textView1 = root.findViewById(R.id.titulo12);
        TextView textView2 = root.findViewById(R.id.text_gallery3);
        TextView textView3 = root.findViewById(R.id.textView12);
        TextView textView4 = root.findViewById(R.id.titulo14);
        TextView textView5 = root.findViewById(R.id.textView13);
        TextView textView6 = root.findViewById(R.id.titulo15);
        TextView textView7 = root.findViewById(R.id.textView15);
        TextView textView8 = root.findViewById(R.id.titulo16);
        TextView textView9 = root.findViewById(R.id.textView16);
        TextView textView10 = root.findViewById(R.id.titulo17);
        TextView textView11 = root.findViewById(R.id.textView17);

        textView1.setVisibility(View.GONE);
        textView2.setText("Vista previa del Anexo");
        textView3.setVisibility(View.GONE);
        textView4.setVisibility(View.GONE);
        textView5.setVisibility(View.GONE);
        textView6.setVisibility(View.GONE);
        textView7.setVisibility(View.GONE);
        textView8.setVisibility(View.GONE);
        textView9.setVisibility(View.GONE);
        textView10.setVisibility(View.GONE);
        textView11.setVisibility(View.GONE);

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DesarrolloViewModel.class);
        // TODO: Use the ViewModel
    }

}