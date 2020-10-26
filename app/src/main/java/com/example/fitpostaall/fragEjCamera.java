package com.example.fitpostaall;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class fragEjCamera  extends Fragment {
    TextView txtTiempo,txtNombre;
    ImageView imgE;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista;
        vista=inflater.inflate(R.layout.layout_ejcamara,container,false);
        txtTiempo=vista.findViewById(R.id.cronometroEjCam);
        txtNombre=vista.findViewById(R.id.cronometroEjCam);
        imgE=vista.findViewById(R.id.imagenEjCam);
        return vista;
    }

}
