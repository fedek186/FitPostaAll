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
    Button comida,sup,rut;
    TextView txtNombre;
    Usuario usr;
    MainActivity main;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista;
        vista = inflater.inflate(R.layout.layout_paginaprincipal, container, false);
        main =(MainActivity) getActivity();
        comida=vista.findViewById(R.id.btnPrinCom);
        sup=vista.findViewById(R.id.imageViewMusculoPrincipal);
        rut=vista.findViewById(R.id.btnPrinFit);
        txtNombre = vista.findViewById(R.id.txtNombreEnPagPrincipal);
        usr = main.devolverUsuarioActivo();
        if( usr.get_Nombre()==null)
        {
            txtNombre.setText("Hola Fede");

        }
        else{
            txtNombre.setText("Hola " + usr.get_Nombre());
        }

        comida.setOnClickListener(this);
        sup.setOnClickListener(this);
        rut.setOnClickListener(this);
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
        if(botonApretado.getId() == rut.getId()){

            main.pasarARutina();
        }

    }
}
