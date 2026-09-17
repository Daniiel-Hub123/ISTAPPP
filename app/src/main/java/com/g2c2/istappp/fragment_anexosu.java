package com.g2c2.istappp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.g2c2.istappp.anexos.cuarto.AnexoCFragment;

import com.g2c2.istappp.anexos.octavo.AnexoOFragment;
import com.g2c2.istappp.anexos.octavo.AnexoOUFragment;
import com.g2c2.istappp.anexos.quinto.AnexoQFragment;

import com.g2c2.istappp.anexos.septimo.AnexoSEVFragment;
import com.g2c2.istappp.anexos.sexto.AnexoSEFragment;
import com.g2c2.istappp.anexos.tercero.AnexoTFragment;
import com.g2c2.istappp.anexos.tercero.AnexoTUFragment;


public class fragment_anexosu extends Fragment {

 
  
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    View root;
    
    public fragment_anexosu() {
        // Required empty public constructor
    }



    public static fragment_anexosu newInstance(String param1, String param2) {
        fragment_anexosu fragment = new fragment_anexosu();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       
        root = inflater.inflate(R.layout.fragment_anexosu, container, false);

        //Anexo 5
        TextView textView1 = root.findViewById(R.id.titulo8);
        textView1.setOnClickListener(aceptar5);

        //Anexo 6
        TextView textView2 = root.findViewById(R.id.titulo9);
        textView2.setOnClickListener(aceptar6);

        //Anexo 7
        TextView textView3 = root.findViewById(R.id.titulo10);
        textView3.setOnClickListener(aceptar7);

        //Anexo 8
        TextView textView4 = root.findViewById(R.id.titulo11);
        textView4.setOnClickListener(aceptar8);

        //Anexo 8.1
        TextView textView5 = root.findViewById(R.id.titulo13);
        textView5.setOnClickListener(aceptar81);


        return root;

        
    }

    View.OnClickListener aceptar5 =new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment = new AnexoQFragment();
            ocultarCampos();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .add(R.id.layoutanexo2,fragment,"fragment_tag5")
                    .addToBackStack("fragment_tag5")
                    .setReorderingAllowed(true)
                    .commit();
        }
    };


    View.OnClickListener aceptar6 =new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment = new AnexoSEFragment();
            ocultarCampos();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .add(R.id.layoutanexo2,fragment,"fragment_tag6")
                    .addToBackStack("fragment_tag6")
                    .setReorderingAllowed(true)
                    .commit();
        }
    };


    View.OnClickListener aceptar7 =new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment = new AnexoSEVFragment();

            ocultarCampos();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .add(R.id.layoutanexo2,fragment,"fragment_tag7")
                    .addToBackStack("fragment_tag7")
                    .setReorderingAllowed(true)
                    .commit();
        }
    };



    View.OnClickListener aceptar8=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment = new AnexoOFragment();
            ocultarCampos();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .add(R.id.layoutanexo2,fragment,"fragment_tag8")
                    .addToBackStack("fragment_tag8")
                    .setReorderingAllowed(true)
                    .commit();
        }
    };

    View.OnClickListener aceptar81=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment = new AnexoOUFragment();
            ocultarCampos();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .add(R.id.layoutanexo2,fragment,"fragment_tag81")
                    .addToBackStack("fragment_tag81")
                    .setReorderingAllowed(true)
                    .commit();
        }
    };

    public void ocultarCampos(){

        TextView textView1 = root.findViewById(R.id.titulo8);
        TextView textView2 = root.findViewById(R.id.text_gallery2);
        TextView textView3 = root.findViewById(R.id.textView7);
        TextView textView4 = root.findViewById(R.id.titulo9);
        TextView textView5 = root.findViewById(R.id.textView8);
        TextView textView6 = root.findViewById(R.id.titulo10);
        TextView textView7 = root.findViewById(R.id.textView9);
        TextView textView8 = root.findViewById(R.id.titulo11);
        TextView textView9 = root.findViewById(R.id.textView10);
        TextView textView10 = root.findViewById(R.id.titulo13);
        TextView textView11 = root.findViewById(R.id.textView11);

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


}