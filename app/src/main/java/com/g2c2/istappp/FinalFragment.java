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

import com.g2c2.istappp.anexos.decimo.AnexoDIFragment;
import com.g2c2.istappp.anexos.decimocuarto.AnexoDCFragment;
import com.g2c2.istappp.anexos.decimoprimero.AnexoDPFragment;
import com.g2c2.istappp.anexos.decimoquinto.AnexoDQFragment;
import com.g2c2.istappp.anexos.decimotercero.AnexoDTFragment;
import com.g2c2.istappp.anexos.noveno.AnexoNFragment;

public class FinalFragment extends Fragment {

    private FinalViewModel mViewModel;
    View root;

    public static FinalFragment newInstance() {
        return new FinalFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.final_fragment, container, false);


        //Anexo 13
        TextView textView13 = root.findViewById(R.id.titulo18);
        textView13.setOnClickListener(aceptar13);

        //Anexo 14
        TextView textView14 = root.findViewById(R.id.titulo20);
        textView14.setOnClickListener(aceptar14);

        //Anexo 15
        TextView textView15 = root.findViewById(R.id.titulo19);
        textView15.setOnClickListener(aceptar15);



        return root;
    }

    View.OnClickListener aceptar13=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment = new AnexoDTFragment();
            ocultarCampos();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .add(R.id.layoutanexo4,fragment,"fragment_tag13")
                    .addToBackStack("fragment_tag13")
                    .setReorderingAllowed(true)
                    .commit();
        }
    };


    View.OnClickListener aceptar14=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment = new AnexoDCFragment();
            ocultarCampos();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .add(R.id.layoutanexo4,fragment,"fragment_tag14")
                    .addToBackStack("fragment_tag14")
                    .setReorderingAllowed(true)
                    .commit();
        }
    };


    View.OnClickListener aceptar15=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment = new AnexoDQFragment();
            ocultarCampos();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .add(R.id.layoutanexo4,fragment,"fragment_tag15")
                    .addToBackStack("fragment_tag15")
                    .setReorderingAllowed(true)
                    .commit();
        }
    };

    public void ocultarCampos(){


        TextView textView1 = root.findViewById(R.id.titulo18);
        TextView textView2 = root.findViewById(R.id.text_gallery4);
        TextView textView3 = root.findViewById(R.id.textView14);
        TextView textView4 = root.findViewById(R.id.titulo20);
        TextView textView5 = root.findViewById(R.id.textView18);
        TextView textView6 = root.findViewById(R.id.titulo19);
        TextView textView7 = root.findViewById(R.id.textView19);

        textView1.setVisibility(View.GONE);
        textView2.setText("Vista previa del Anexo");
        textView3.setVisibility(View.GONE);
        textView4.setVisibility(View.GONE);
        textView5.setVisibility(View.GONE);
        textView6.setVisibility(View.GONE);
        textView7.setVisibility(View.GONE);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FinalViewModel.class);
        // TODO: Use the ViewModel
    }

}