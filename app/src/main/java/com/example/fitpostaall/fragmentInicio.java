package com.example.fitpostaall;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;




import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.firestore.FirebaseFirestore;


import java.util.Arrays;
import java.util.List;

public class fragmentInicio extends Fragment implements View.OnClickListener {
    Button register, login;
    EditText Mail, Pass;
    String mailLargo, sContra;
    // Choose an arbitrary request code value
    private static final int RC_SIGN_IN = 123;

    private FirebaseAuth mAuth;
    FirebaseFirestore db;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista;
        vista = inflater.inflate(R.layout.layout_inicio, container, false);
        register = vista.findViewById(R.id.imageViewRegister);
        login = vista.findViewById(R.id.imageViewLogin);



        register.setOnClickListener(this);
        login.setOnClickListener(this);





        return vista;
    }

    public void onClick(View vista) {
        Button botonApretado;
        botonApretado = (Button) vista;
        if (botonApretado.getId() == register.getId()) {
            MainActivity main = (MainActivity) getActivity();
            main.pasarAregister();
        }

        if (botonApretado.getId() == login.getId()) {

            MainActivity main = (MainActivity) getActivity();
            main.createSignInIntent();













/*
            mailLargo = Mail.getText().toString();
            sContra = Pass.getText().toString();



            if (mailLargo.length() == 0 || sContra.length() == 0) {



                MainActivity main = (MainActivity) getActivity();
                main.alertaIngresoIncorrecto();

            }else {

                String [] arregloDeMail = cortarCadenaPorArroba(mailLargo);
                for (int i = 0; i < arregloDeMail.length; i++){
                    Log.d("ConversionMail",arregloDeMail[i]);
                }

                db.collection("usuarios")
                        .whereEqualTo("Mail",arregloDeMail[0])
                        .whereEqualTo("Dominio",arregloDeMail[1])
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    //cuando es correcto el ingreso
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        Log.d("TAG", document.getId() + " => " + document.getData());
                                        MainActivity main=(MainActivity) getActivity();
                                        main.pasarAPrin();
                                    }
                                } else {
                                    MainActivity main=(MainActivity) getActivity();
                                    main.alertaIngresoIncorrecto();

                                    Log.d("TAG", "Error getting documents: " +  task.getException());
                                }
                            }
                        });

            }












            DocumentReference docRef = db.collection("Usuarios").document("BJ");
            docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    Usuario usr = documentSnapshot.toObject(Usuario.class);
                }
            });

            */


        }



    }

    public String[] cortarCadenaPorArroba(String cadena) {
        return cadena.split("\\@");
    }







}