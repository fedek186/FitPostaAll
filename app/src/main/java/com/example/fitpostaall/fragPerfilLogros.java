package com.example.fitpostaall;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;import android.widget.AdapterView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class fragPerfilLogros extends Fragment {
    ListView lista;
    ArrayList<logro> logroArrayList= new ArrayList<>();
    adaptadorDeLogros logrosAdapter;
    Drawable img;
    logro unLogro= new logro();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista;
        vista = inflater.inflate(R.layout.layout_perfillogoros, container, false);
        lista=vista.findViewById(R.id.lista);
        unLogro._nombre="Llega al nivel X en Tren Superior";
        unLogro._fecha=parseDate("2014-02-14");
        unLogro._unblocked=true;
        unLogro._imagen=getResources().getDrawable(R.drawable.logro_max_brazo);
        logroArrayList.add(unLogro);
        logrosAdapter = new  adaptadorDeLogros(logroArrayList,getActivity());
        return vista;
    }

    private Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }


}
