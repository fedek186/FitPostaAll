package com.example.fitpostaall;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class fragmentInicio extends Fragment implements View.OnClickListener {
    Button register, login;
    private FirebaseAuth mAuth;
    FirebaseFirestore db;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
     View vista;
     vista=inflater.inflate(R.layout.layout_inicio,container,false);
     register=vista.findViewById(R.id.imageViewRegister);
     login=vista.findViewById(R.id.imageViewLogin);
     register.setOnClickListener(this);
     login.setOnClickListener(this);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        //database
        db = FirebaseFirestore.getInstance();

        

    return vista;
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);



    }



    private void updateUI(FirebaseUser currentUser) {
    }

    public void onClick(View vista) {
        Button botonApretado;
        botonApretado= (Button) vista;
        if(botonApretado.getId()==register.getId())
        {
            MainActivity main=(MainActivity) getActivity();
            main.pasarAregister();
        }
        if(botonApretado.getId()==login.getId())
        {

            // Leer info de BD
            db.collection("usuarios")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {

                                    Log.d("TAG", document.getId() + " => " + document.getData());
                                }
                            } else {
                                Log.d("TAG", "Error getting documents.", task.getException());
                            }
                        }
                    });


            MainActivity main=(MainActivity) getActivity();
            main.pasarAPrin();
        }


    }
}
