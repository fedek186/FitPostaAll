package com.example.fitpostaall;

import android.app.Fragment;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class fragmentSerieEjercicios extends Fragment implements View.OnClickListener {
    Button sigui;
    TextView txtN,txtI,txtCrono;
    ImageView imgE;
    MainActivity main;
    ArrayList<Ejercicio> lisEj;
    int i;
    Boolean pausa=false;
    CountDownTimer countDown;








    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista;
        vista=inflater.inflate(R.layout.layout_serie_ejercicios,container,false);
        i=0;
        main= (MainActivity) getActivity();
        sigui=vista.findViewById(R.id.btnEj);
        txtI=vista.findViewById(R.id.cantI);
        txtN=vista.findViewById(R.id.nombEjer);
        imgE=vista.findViewById(R.id.imagenEj);
        txtCrono = vista.findViewById(R.id.cronometro);
        sigui.setOnClickListener(this);
        lisEj=main.devolverArrayEj();
        //pauseOffset= SystemClock.elapsedRealtime()-cronometro.getBase();
        main.cargarDatos(txtN, txtI, txtCrono, imgE, lisEj);
        countDown = main.countDown;
        return vista;
    }
    public void onClick(View vista) {
        Button botonApretado;
        botonApretado= (Button) vista;
        if(sigui.getId()== botonApretado.getId() && pausa == false){
            countDown.cancel();
            pausa=true;
        }
        else if(sigui.getId()== botonApretado.getId() && pausa == true){
            main.comenzar(txtCrono, lisEj, txtN);


        }


    }


}