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
    ArrayList<Ejercicio> Ej = new ArrayList<Ejercicio>();
    ArrayList<Ejercicio> id= new ArrayList<Ejercicio>();
    zonaDeEjercicio zona= new zonaDeEjercicio();
    MainActivity main;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista;
        vista = inflater.inflate(R.layout.layout_lista_ejerciocios, container, false);
        lista=vista.findViewById(R.id.listaEjer);
        main= (MainActivity) getActivity();
        zona=main.devolverZona();
        Log.d("Fede", String.valueOf(zona.get_idZonaDeEjercicio()));
        if(zona.get_idZonaDeEjercicio()=="Superior")
        {
          id=main.devolverListaInferior();
        }
        else
        {
            id=main.devolverListaSuperior();
        }
        Ej=main.randomEjerId(id);
        for(int i = 0; i < Ej.size(); ++i)
        {
            Ejercicio ejer= new Ejercicio();
            ejer.set_NombreEjercicio(Ej.get(i).get_NombreEjercicio());
            ejer.set_img(getResources().getDrawable(R.drawable.flexiones_img));
            ejer.set_seg(Ej.get(i).get_Seg());
            ejArrayList.add(ejer);
        }
        ejAdapter = new adaptadorDeEjercicios(ejArrayList,getActivity());
        lista.setAdapter(ejAdapter);
        return vista;
    }


}