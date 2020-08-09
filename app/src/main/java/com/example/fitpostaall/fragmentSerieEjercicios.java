package com.example.fitpostaall;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class fragmentSerieEjercicios extends Fragment implements View.OnClickListener {
    Button sigui;
    TextView txtN,txtI;
    ImageView imgE;
    MainActivity main;
    ArrayList<Ejercicio> lisEj;
    int i;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista;
        vista=inflater.inflate(R.layout.layout_serie_ejercicios,container,false);
        i=0;
        main= (MainActivity) getActivity();
        sigui=vista.findViewById(R.id.btnEj);
        txtI=vista.findViewById(R.id.cantI);
        txtN=vista.findViewById(R.id.nombEjer);
        imgE=vista.findViewById(R.id.imagenEj);
        sigui.setOnClickListener(this);
        lisEj=main.devolverArrayEj();
        cargarDatos();

        return vista;
    }
    public void onClick(View vista) {
        Button botonApretado;
        botonApretado= (Button) vista;
        if(sigui.getId()== botonApretado.getId() &&  i<lisEj.size()){
            i++;
            if( i<lisEj.size())
            {
                cargarDatos();
            }else {
                txtN.setText("Finalizaste");
            }
        }

    }

        public void cargarDatos()
        {
            txtI.setText((i+1)+"/"+lisEj.size());
            imgE.setImageDrawable(lisEj.get(i).get_Foto());
            txtN.setText(lisEj.get(i).get_NombreEjercicio());
        }
}