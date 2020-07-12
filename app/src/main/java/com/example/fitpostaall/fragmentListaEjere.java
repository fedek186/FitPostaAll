package com.example.fitpostaall;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class fragmentListaEjere extends Fragment {
    ListView lista;
    ArrayList<Ejercicio> ejArrayList= new ArrayList<>();
    adaptadorDeEjercicios ejAdapter;
    ArrayList<String> Ej = new ArrayList<String>();
    ArrayList<String> id= new ArrayList<String>();
    Ejercicio ejer= new Ejercicio();
    MainActivity main;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista;
        vista = inflater.inflate(R.layout.layout_lista_ejerciocios, container, false);
        lista=vista.findViewById(R.id.listaEjer);
        main= (MainActivity) getActivity();
        id.add("1");
        id.add("2");
        id.add("3");
        id.add("Patata");
        Ej=main.randomEjerId(id);
        Log.d("FEDE", String.valueOf(Ej));
        ejer.set_NombreEjercicio("Flexiones");
        ejer.set_img(getResources().getDrawable(R.drawable.flexiones_img));
        ejer.set_seg(10);
        ejArrayList.add(ejer);
        ejArrayList.add(ejer);
        ejArrayList.add(ejer);
        ejAdapter = new adaptadorDeEjercicios(ejArrayList,getActivity());
        lista.setAdapter(ejAdapter);
        return vista;
    }


}
