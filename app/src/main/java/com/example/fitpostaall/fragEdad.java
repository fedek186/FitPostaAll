package com.example.fitpostaall;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Toast;

public class fragEdad extends Fragment implements View.OnClickListener {
    ImageButton flechaD;
    DatePicker DP;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista;
        vista=inflater.inflate(R.layout.layout_edad,container,false);
        flechaD=vista.findViewById(R.id.imageButtonFlechaDerEdad);
        DP=vista.findViewById(R.id.DateFecha);
        // init
        // dpDate.init(2002, 10, 27, null);
        flechaD.setOnClickListener(this);
        return vista;
    }
    public void onClick(View vista) {
        Button botonApretado;
        botonApretado= (Button) vista;

        if(flechaD.getId()== botonApretado.getId()){
            StringBuilder builder=new StringBuilder();
            builder.append("Current Date: ");
            builder.append((DP.getMonth() + 1)+"/");//month is 0 based
            builder.append(DP.getDayOfMonth()+"/");
            builder.append(DP.getYear());
            Log.d("Conexion", builder.toString());
            MainActivity main=(MainActivity) getActivity();
            main.pasarAdedicacion();
        }
    }
}
