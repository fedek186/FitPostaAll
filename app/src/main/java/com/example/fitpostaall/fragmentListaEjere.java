package com.example.fitpostaall;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class fragmentListaEjere extends Fragment implements View.OnClickListener{
    ListView lista;
    ArrayList<Ejercicio> ejArrayList= new ArrayList<>();
    adaptadorDeEjercicios ejAdapter;
    ArrayList<Ejercicio> Ej = new ArrayList<Ejercicio>();
    ArrayList<Ejercicio> id= new ArrayList<Ejercicio>();
    zonaDeEjercicio zona= new zonaDeEjercicio();
    Button btn;
    MainActivity main;
    ArrayList<String> Listade3Ejs;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista;
        vista = inflater.inflate(R.layout.layout_lista_ejerciocios, container, false);
        lista=vista.findViewById(R.id.listaEjer);
        btn=vista.findViewById(R.id.btnComRut);
        btn.setOnClickListener(this);
        main= (MainActivity) getActivity();
        zona=main.devolverZona();
        Log.d("Fede", String.valueOf(zona.get_idZonaDeEjercicio()));

        if (!main.compararUltFecha()){
            main.reiniciarListaDeEjs();
        }


        if(zona.get_idZonaDeEjercicio()=="Superior")
        {
            id=main.devolverListaInferior();
        }
        else
        {
            id=main.devolverListaSuperior();
        }



        Listade3Ejs = main.ListaDe3Ejs();
        if (Listade3Ejs == null || Listade3Ejs.size() <1){
            Ej=main.randomEjerId(id);
        }
        else {
            //Aca va el traer ejercicio segun id
            for (int i = 0; i < Listade3Ejs.size(); i++){

                Ejercicio j = main.traerEjSegunId(Listade3Ejs.get(i));
                String s = j.get_NombreEjercicio();
                Ej.add(j);
                Log.d("traerEjSegunId", s);

            }
        }

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


    @Override
    public void onClick(View v) {
        Button botonApretado;
        botonApretado= (Button) v;

        if(btn.getId()== botonApretado.getId()){
            main.recibiArrayEj(ejArrayList);
            main.pasarASerieEjer();
        } }

}