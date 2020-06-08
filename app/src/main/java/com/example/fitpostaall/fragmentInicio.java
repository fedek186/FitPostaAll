package com.example.fitpostaall;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class fragmentInicio extends Fragment implements View.OnClickListener {
    Button register;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
     View vista;
     vista=inflater.inflate(R.layout.layout_inicio,container,false);
     register=vista.findViewById(R.id.imageViewRegister);
     register.setOnClickListener(this);
    return vista;
    }
    public void onClick(View v) {
        MainActivity main=(MainActivity) getActivity();
        main.pasarAregister();

    }
}
