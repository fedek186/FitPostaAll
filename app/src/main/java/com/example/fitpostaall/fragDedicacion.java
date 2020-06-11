package com.example.fitpostaall;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class fragDedicacion extends Fragment implements View.OnClickListener {
    ImageButton flechaD;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista;
        vista=inflater.inflate(R.layout.layout_dedicacion,container,false);
        flechaD=vista.findViewById(R.id.imageButtonFlechaDerDedicacion);
        flechaD.setOnClickListener(this);
        return vista;
    }
    public void onClick(View vista) {
        Button botonApretado;
        botonApretado= (Button) vista;

        if(flechaD.getId()== botonApretado.getId()){
            MainActivity main=(MainActivity) getActivity();
            main.pasarAobjetivo();
        }
    }
}