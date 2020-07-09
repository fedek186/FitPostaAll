package com.example.fitpostaall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class adaptadorDeEjercicios extends BaseAdapter {
    private ArrayList<ejercicios> arrrayEj;
    ejercicios ejer= new ejercicios();
    private Context miContexto;
    TextView Nomb,rep;
    ImageView imgPrin;
    public adaptadorDeEjercicios (ArrayList<ejercicios> arrLog, Context contexto) {
        arrrayEj = arrLog;
        miContexto = contexto;
    }

    @Override
    public int getCount() {
        return arrrayEj.size();
    }

    @Override
    public ejercicios getItem(int position) {
        ejercicios ej;
        ej = arrrayEj.get(position);
        return ej;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vista;
        LayoutInflater inflador;
        inflador = (LayoutInflater) miContexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        vista = inflador.inflate(R.layout.layout_lista_ejerciocios, parent, false);
        Nomb = vista.findViewById(R.id.nomEj);
        rep = vista.findViewById(R.id.txtRep);
        imgPrin = vista.findViewById(R.id.imgEj);
        ejer=getItem(position);
        Nomb.setText(ejer._nombre);
        imgPrin.setImageDrawable(ejer._imagen);
        rep.setText("Repeticiones:"+ ejer._repeticiones);
        return vista;
    }


}