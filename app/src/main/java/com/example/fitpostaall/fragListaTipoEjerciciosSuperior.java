package com.example.fitpostaall;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class fragListaTipoEjerciciosSuperior  extends Fragment {
    ListView lista;
    ArrayList<TipoEjercicio> tipoEjerciciosArrayList= new ArrayList<>();
    adaptadorDeTiposEjercicios TypeExAdapter;
    TipoEjercicio typeEx= new TipoEjercicio();
    TipoEjercicio typeEx2= new TipoEjercicio();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista;
        vista = inflater.inflate(R.layout.layout_lista_tipo_ejercicio_superior, container, false);
        lista=vista.findViewById(R.id.listaTipoEjerciciosSuperior);
        typeEx._nombre="Brazos";
        typeEx._imagen=getResources().getDrawable(R.drawable.rutinaprin);
        typeEx._rango=2;
        typeEx2._nombre="plancha";
        typeEx2._imagen=getResources().getDrawable(R.drawable.rutinaprin);
        typeEx2._rango=2;
        tipoEjerciciosArrayList.add(typeEx2);
        tipoEjerciciosArrayList.add(typeEx);

        TypeExAdapter = new adaptadorDeTiposEjercicios(tipoEjerciciosArrayList,getActivity());
        lista.setAdapter(TypeExAdapter);
        return vista;
    }
}
