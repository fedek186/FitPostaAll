package com.example.fitpostaall;

import android.app.Fragment;
import android.os.Bundle;
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
    Ejercicio ejer= new Ejercicio();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista;
        vista = inflater.inflate(R.layout.layout_lista_ejerciocios, container, false);
        lista=vista.findViewById(R.id.listaEjer);
        ejer.set_NombreEjercicio("Tren Superior");
      //  ejer._imagen=getResources().getDrawable(R.drawable.flexiones_img);
      //  ejer._repeticiones=8;
        ejArrayList.add(ejer);
        ejArrayList.add(ejer);
        ejArrayList.add(ejer);
        ejAdapter = new adaptadorDeEjercicios(ejArrayList,getActivity());
        lista.setAdapter(ejAdapter);
        return vista;
    }


}
