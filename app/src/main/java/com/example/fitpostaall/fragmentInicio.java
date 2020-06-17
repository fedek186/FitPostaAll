package com.example.fitpostaall;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class fragmentInicio extends Fragment implements View.OnClickListener {
    Button register, login;
    EditText Mail, Pass;
    String mail;

    private FirebaseAuth mAuth;
    FirebaseFirestore db;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
     View vista;
     vista=inflater.inflate(R.layout.layout_inicio,container,false);
     register=vista.findViewById(R.id.imageViewRegister);
     login=vista.findViewById(R.id.imageViewLogin);
     Mail=vista.findViewById(R.id.edxMail1);
     Pass= vista.findViewById(R.id.edxPass1);


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
            mail = Mail.getText().toString();

            db.collection("usuarios")
                    .whereEqualTo("Mail", mail)
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Log.d("TAG", document.getId() + " => " + document.getData());
                                    MainActivity main=(MainActivity) getActivity();
                                    main.pasarAPrin();
                                }
                            } else {
                                Log.d("TAG", "Error getting documents: " +  task.getException());
                            }
                        }
                    });
/*
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
}
