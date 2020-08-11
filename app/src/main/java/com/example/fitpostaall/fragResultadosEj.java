package com.example.fitpostaall;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class fragResultadosEj  extends Fragment implements View.OnClickListener {
    Button btnSalir;
    MainActivity main;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista;
        vista=inflater.inflate(R.layout.layout_resultados_train,container,false);
        main= (MainActivity) getActivity();
        btnSalir= vista.findViewById(R.id.volverPrin);
        btnSalir.setOnClickListener(this);
        return  vista;
    }

    @Override
    public void onClick(View v) {
        Button botonApretado;
        botonApretado= (Button) v;
        if(botonApretado.getId()==btnSalir.getId()){
          main.pasarAPrin();
        }
    }
}
