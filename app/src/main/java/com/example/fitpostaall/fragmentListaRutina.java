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

public class fragmentListaRutina extends Fragment {
    ListView lista;
    ArrayList<zonaDeEjercicio> zonaArrayList= new ArrayList<>();
    adaptadorDeZonas zonasAdapter;
    zonaDeEjercicio unaZona= new zonaDeEjercicio();
    MainActivity main;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista;
        vista = inflater.inflate(R.layout.layout_rutina_menu, container, false);
        lista=vista.findViewById(R.id.listaRutina);
        main= (MainActivity) getActivity();
        String Zona=main.randomSupInf();
        unaZona.set_idZonaDeEjercicio(Zona);
        unaZona.set_img(getResources().getDrawable(R.drawable.rutinaprin));
        zonaArrayList.add(unaZona);
        zonasAdapter = new adaptadorDeZonas(zonaArrayList,getActivity());
        lista.setClickable(true);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MainActivity main=(MainActivity) getActivity();
                main.recebirZona(zonaArrayList.get(position));
                main.pasarAejercicio();
            }
        });
        lista.setAdapter(zonasAdapter);
        return vista;
    }
}
