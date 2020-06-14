package com.example.fitpostaall;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class fragmentInicio extends Fragment implements View.OnClickListener {
    Button register;
    private FirebaseAuth mAuth;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
     View vista;
     vista=inflater.inflate(R.layout.layout_inicio,container,false);
     register=vista.findViewById(R.id.imageViewRegister);
     register.setOnClickListener(this);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();


        

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

    public void onClick(View v) {
        MainActivity main=(MainActivity) getActivity();
        main.pasarAregister();

    }
}
