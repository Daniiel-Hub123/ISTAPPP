package com.g2c2.istappp.login;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.lifecycle.ViewModelProvider;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.g2c2.istappp.R;
import com.g2c2.istappp.SistemaActivity;
import com.g2c2.istappp.intefaces.CarreraAPI;
import com.g2c2.istappp.intefaces.UserCarreraAPI;
import com.g2c2.istappp.intefaces.UsuarioAPI;
import com.g2c2.istappp.model.Carrera;
import com.g2c2.istappp.model.Usuario;
import com.g2c2.istappp.model.UsuarioCarrera;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.concurrent.Executor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginFragment extends Fragment {

    private LoginViewModel mViewModel;
    View view;
    GoogleSignInClient mGoogleSignInClient;
    private static int RC_SIGN_IN = 100;

    Button logout,exit;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.login_fragment, container, false);

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(getActivity(), gso);

        // Check for existing Google Sign In account, if the user is already signed in
        // the GoogleSignInAccount will be non-null.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getContext());

        logout = view.findViewById(R.id.buttonExit);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
            }
        });

        SignInButton signInButton = view.findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });

        return view;

    }

    private void signOut() {
        mGoogleSignInClient.signOut();
        Toast.makeText(getActivity(),"Ha salido de su cuenta correctamente!",Toast.LENGTH_SHORT).show();

    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {

            String ced;

            //Login Google
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(getActivity());

            if (acct != null) {

                String personName = acct.getDisplayName();
                String personGivenName = acct.getGivenName();
                String personFamilyName = acct.getFamilyName();
                String personEmail = acct.getEmail();
                String personId = acct.getId();
                Uri personPhoto = acct.getPhotoUrl();


                if(personEmail.contains("est@tecazuay.edu.ec")){

                    //Modificable dependiendo de la dirección IP de la PC
                    //Necesario para servicios Back-End y Fenix
                    Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.174.24:8080/")
                            .addConverterFactory(GsonConverterFactory.create()).build();

                    UsuarioAPI usuarioAPI = retrofit.create(UsuarioAPI.class);
                    Call<Usuario> call = usuarioAPI.find(personEmail);

                    call.enqueue(new Callback<Usuario>() {
                        @Override
                        public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                            try {
                                if(response.isSuccessful()){

                                    Usuario u = response.body();

                                    String cedula = u.getCedula();
                                    String nombre = u.getNombrescompletos();
                                    Log.i("NumberGenerated",cedula);

                                    if(u.getRol().equals("EST")){
                                        u.setRol("Estudiante");
                                    } else{
                                        u.setRol("Docente");
                                    }

                                    //Modificable dependiendo de la dirección IP de la PC
                                    //Necesario para servicios Back-End y Fenix

                                    Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.174.24:8080/")
                                            .addConverterFactory(GsonConverterFactory.create()).build();

                                    UserCarreraAPI userCarreraAPI = retrofit.create(UserCarreraAPI.class);
                                    Call<UsuarioCarrera> calluc = userCarreraAPI.find(cedula);

                                    calluc.enqueue(new Callback<UsuarioCarrera>() {
                                        @Override
                                        public void onResponse(Call<UsuarioCarrera> call, Response<UsuarioCarrera> response) {

                                            if(response.isSuccessful()){

                                                UsuarioCarrera uc = response.body();
                                                String cedula = uc.getCedula();
                                                String codigo = uc.getCodigoCarrera();


                                                Intent intent = new Intent(getActivity(), SistemaActivity.class);
                                                intent.putExtra("cedula",cedula);
                                                intent.putExtra("codigo",codigo);


                                                startActivity(intent);
                                                Toast.makeText(getContext(), "Bienvenido " +personName, Toast.LENGTH_SHORT).show();

                                            }

                                        }

                                        @Override
                                        public void onFailure(Call<UsuarioCarrera> call, Throwable t) {

                                            Toast.makeText(getContext(), "Ha ocurrido un error, intentelo de nuevo ", Toast.LENGTH_SHORT).show();

                                        }
                                    });




                                }


                            } catch (Exception ex){
                                Toast.makeText(getActivity(),"Usuario no registrado",Toast.LENGTH_SHORT).show();
                            }


                        }

                        @Override
                        public void onFailure(Call<Usuario> call, Throwable t) {
                            Toast.makeText(getActivity(),"Usuario no registrado / Sin conexión a Internet",Toast.LENGTH_SHORT).show();
                        }
                    });




                }else{

                    mGoogleSignInClient.signOut();
                    Toast.makeText(getContext(),"El correo ingresado no pertenece al ISTA",Toast.LENGTH_SHORT).show();

                }
            } else{
                Toast.makeText(getActivity(),"Cuenta no registrada",Toast.LENGTH_SHORT).show();
            }

        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.

            Toast.makeText(getActivity(),"Elija una cuenta para ingresar",Toast.LENGTH_SHORT).show();

        }
    }




    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

    }

}