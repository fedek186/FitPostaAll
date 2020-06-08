package com.example.fitpostaall;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class fragIngresoFoto extends Fragment implements View.OnClickListener {
    ImageView flechaI,flechaD;
    ImageButton foto,mas;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista;
        vista=inflater.inflate(R.layout.layout_ingresarfoto,container,false);
        flechaD=vista.findViewById(R.id.imageViewFlechaDerFot);
        flechaI=vista.findViewById(R.id.imageViewFlechaIzqFot);
        foto=vista.findViewById(R.id.imageButtonFoto);
        mas=vista.findViewById(R.id.imageButtonMas);
        flechaD.setOnClickListener(this);
        flechaI.setOnClickListener(this);
        foto.setOnClickListener(this);
        mas.setOnClickListener(this);
        return vista;
    }

    public void onClick(View vista) {
        Button botonApretado;
        botonApretado= (Button) vista;

        if(flechaD.getId()== botonApretado.getId()){
            MainActivity main=(MainActivity) getActivity();
            main.pasarAcita();
        }
        }
}
