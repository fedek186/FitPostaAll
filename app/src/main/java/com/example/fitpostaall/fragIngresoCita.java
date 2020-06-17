package com.example.fitpostaall;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class fragIngresoCita extends Fragment implements View.OnClickListener {
    Button flechaD;
    ImageView flechaI;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista;
        vista=inflater.inflate(R.layout.layout_ingresocita,container,false);
        flechaD=vista.findViewById(R.id.btnFlechaDerCita);
        flechaI=vista.findViewById(R.id.imageViewFlechaIzqCita);
        flechaD.setOnClickListener(this);
        flechaI.setOnClickListener(this);

        return vista;
    }
    public void onClick(View vista) {
        Button botonApretado;
        botonApretado= (Button) vista;

        if(flechaD.getId()== botonApretado.getId()){
            MainActivity main=(MainActivity) getActivity();
            main.pasarAregistroDatos();
        }
    }
}



