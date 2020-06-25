package com.example.fitpostaall;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class fragmentPaginaPrincipal extends Fragment implements View.OnClickListener {
    Button comida,sup;
    TextView txtNombre;
    Usuario usr;
    MainActivity main;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista;
        vista = inflater.inflate(R.layout.layout_paginaprincipal, container, false);
        main =(MainActivity) getActivity();
        comida=vista.findViewById(R.id.btnPrinCom);
        sup=vista.findViewById(R.id.imageViewMusculoPrincipal);
        txtNombre = vista.findViewById(R.id.txtNombreEnPagPrincipal);
        usr = main.devolverUsuarioActivo();
        txtNombre.setText("Hola " + usr.get_Nombre());
        comida.setOnClickListener(this);
        sup.setOnClickListener(this);
        return vista;
    }
    public void onClick(View vista) {
        Button botonApretado;
        botonApretado= (Button) vista;

        if(botonApretado.getId() == comida.getId()){
            main.pasarAcomida();
        }
        if(botonApretado.getId() == sup.getId()){

            main.pasarATrenSuperior();
        }

    }
}
