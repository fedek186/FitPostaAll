package com.example.fitpostaall;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class fragListaComida extends Fragment {
    ListView listaComida1,listaComida2;
    ArrayList<plato> platosArrayList1= new ArrayList<>();
    ArrayList<plato> platosArrayList2= new ArrayList<>();
    adaptadorDePlatos platosAdapter;
    plato unPlato= new plato();
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista;
        vista=inflater.inflate(R.layout.layout_lista_comida_desayuno,container,false);
        listaComida1=vista.findViewById(R.id.listaComida1);
        listaComida2=vista.findViewById(R.id.listaComida2);
        unPlato._nombre="Yogur";
        unPlato._nutrientes="Proteinas";
        unPlato._desc="aaaaaaaaaaaaaa";
        unPlato._imagen=getResources().getDrawable(R.drawable.comida);
        platosArrayList1.add(unPlato);
        platosArrayList2.add(unPlato);
        platosAdapter = new adaptadorDePlatos(platosArrayList1,getActivity());
        listaComida1.setAdapter(platosAdapter);
        platosAdapter = new adaptadorDePlatos(platosArrayList2,getActivity());
        listaComida2.setAdapter(platosAdapter);
        return vista;
    }
}
