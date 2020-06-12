package com.example.fitpostaall;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class adaptadorDeLogros extends BaseAdapter {
    private ArrayList<logro> arrayLogros;
    logro miLogro= new logro();
    private Context miContexto;
    TextView fecha,Nomb;
    ImageView img;
    public adaptadorDeLogros (ArrayList<logro> arrLog, Context contexto) {
        arrayLogros = arrLog;
        miContexto = contexto;
    }

    @Override
    public int getCount() {
        return arrayLogros.size();
    }

    @Override
    public logro getItem(int position) {
        logro unLogro;
        unLogro = arrayLogros.get(position);
        return unLogro;
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
        vista = inflador.inflate(R.layout.layout_logro, parent, false);
        Nomb = vista.findViewById(R.id.nombreLogro);
        fecha = vista.findViewById(R.id.fechaLogro);
        img = vista.findViewById(R.id.imagenLogro);

        miLogro=getItem(position);
        if(miLogro._unblocked==true) {
            Nomb.setText(miLogro._nombre);
            fecha.setText(miLogro._fecha.toString());
            img.setImageDrawable(miLogro._imagen);
        }

        return vista;
    }


}
