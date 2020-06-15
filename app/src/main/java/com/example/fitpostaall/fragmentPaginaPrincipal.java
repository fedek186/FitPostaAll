package com.example.fitpostaall;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
public class fragmentPaginaPrincipal extends Fragment implements View.OnClickListener {
    Button comida;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista;
        vista = inflater.inflate(R.layout.layout_paginaprincipal, container, false);
        comida=vista.findViewById(R.id.btnPrinCom);
        comida.setOnClickListener(this);
        return vista;
    }
    public void onClick(View vista) {
        Button botonApretado;
        botonApretado= (Button) vista;

        if(botonApretado.getId() == comida.getId()){
            MainActivity main=(MainActivity) getActivity();
            main.pasarAcomida();
        }
    }
}
