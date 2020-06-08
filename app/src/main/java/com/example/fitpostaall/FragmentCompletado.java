package com.example.fitpostaall;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class FragmentCompletado extends Fragment implements View.OnClickListener{
    Button finish;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista;
        vista=inflater.inflate(R.layout.layout_completado,container,false);
        finish=vista.findViewById(R.id.btnFinish);
        return vista;
    }
    public void onClick(View vista) {
        Button botonApretado;
        botonApretado = (Button) vista;
        if(botonApretado.getId()==finish.getId())
        {
            MainActivity main=(MainActivity) getActivity();
            main.pasarAonboraingrango();
        }
    }
}
