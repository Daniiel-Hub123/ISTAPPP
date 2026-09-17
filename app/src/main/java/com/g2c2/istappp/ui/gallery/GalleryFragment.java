package com.g2c2.istappp.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.g2c2.istappp.anexos.cuarto.AnexoCFragment;
import com.g2c2.istappp.anexos.primero.AnexoUFragment;
import com.g2c2.istappp.R;
import com.g2c2.istappp.anexos.segundo.AnexoDFragment;
import com.g2c2.istappp.anexos.tercero.AnexoTFragment;
import com.g2c2.istappp.anexos.tercero.AnexoTUFragment;
import com.g2c2.istappp.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private FragmentGalleryBinding binding;
    private View root;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
         root = binding.getRoot();

        final TextView textView = binding.textGallery;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        //Anexo 1
        TextView textView1 = root.findViewById(R.id.titulo3);
        textView1.setOnClickListener(aceptar1);

        //Anexo 2
        TextView textView2 = root.findViewById(R.id.titulo4);
        textView2.setOnClickListener(aceptar2);

        //Anexo 3
        TextView textView3 = root.findViewById(R.id.titulo5);
        textView3.setOnClickListener(aceptar3);

        //Anexo 3.1
        TextView textView4 = root.findViewById(R.id.titulo6);
        textView4.setOnClickListener(aceptar31);

        //Anexo 4
        TextView textView5 = root.findViewById(R.id.titulo7);
        textView5.setOnClickListener(aceptar4);


        return root;


    }



    View.OnClickListener aceptar1=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                     Fragment fragment = new AnexoUFragment();
                     ocultarCampos();
                     getActivity().getSupportFragmentManager().beginTransaction()
                    .add(R.id.layoutanexo1,fragment,"fragment_tag1")
                    .addToBackStack("fragment_tag1")
                    .setReorderingAllowed(true)
                    .commit();
            }
        };


    View.OnClickListener aceptar2=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment = new AnexoDFragment();
            ocultarCampos();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .add(R.id.layoutanexo1,fragment,"fragment_tag2")
                    .addToBackStack("fragment_tag2")
                    .setReorderingAllowed(true)
                    .commit();
        }
    };


    View.OnClickListener aceptar3=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment = new AnexoTFragment();
            ocultarCampos();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .add(R.id.layoutanexo1,fragment,"fragment_tag3")
                    .addToBackStack("fragment_tag3")
                    .setReorderingAllowed(true)
                    .commit();
        }
    };



    View.OnClickListener aceptar31=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment = new AnexoTUFragment();
            ocultarCampos();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .add(R.id.layoutanexo1,fragment,"fragment_tag31")
                    .addToBackStack("fragment_tag31")
                    .setReorderingAllowed(true)
                    .commit();
        }
    };

    View.OnClickListener aceptar4=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment = new AnexoCFragment();
            ocultarCampos();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .add(R.id.layoutanexo1,fragment,"fragment_tag4")
                    .addToBackStack("fragment_tag4")
                    .setReorderingAllowed(true)
                    .commit();
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void ocultarCampos(){

        TextView textView1 = root.findViewById(R.id.titulo3);
        TextView textView2 = root.findViewById(R.id.text_gallery);
        TextView textView3 = root.findViewById(R.id.textView2);
        TextView textView4 = root.findViewById(R.id.titulo4);
        TextView textView5 = root.findViewById(R.id.textView3);
        TextView textView6 = root.findViewById(R.id.titulo5);
        TextView textView7 = root.findViewById(R.id.textView4);
        TextView textView8 = root.findViewById(R.id.titulo6);
        TextView textView9 = root.findViewById(R.id.textView5);
        TextView textView10 = root.findViewById(R.id.titulo7);
        TextView textView11 = root.findViewById(R.id.textView6);

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