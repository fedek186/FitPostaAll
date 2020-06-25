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

public class fragPerfil extends Fragment implements View.OnClickListener  {
    TextView edit, sexo, edad, peso, altura, ded, obj, nom;
    Button log;
    Usuario usr;
    MainActivity main;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista;
        vista=inflater.inflate(R.layout.layout_perfil,container,false);
        main =(MainActivity) getActivity();
        usr = main.devolverUsuarioActivo();
        edit=vista.findViewById(R.id.txtEditarEnPerfil);
        log=vista.findViewById(R.id.txtLogroEnPerfil);
        log.setOnClickListener(this);
        edit.setOnClickListener(this);

        nom=vista.findViewById(R.id.nombrePerfil);
        sexo=vista.findViewById(R.id.txtSexoEnPerfil);
        edad=vista.findViewById(R.id.txtEdadEnPerfil);
        peso=vista.findViewById(R.id.txtPesoEnPerfil);
        altura=vista.findViewById(R.id.txtAlturaEnPerfil);
        ded=vista.findViewById(R.id.txtDedicacionEnPerfil);
        obj=vista.findViewById(R.id.txtObjetivoEnPerfil);

        nom.setText(usr.get_Nombre() +" " + usr.get_Apellido());
        sexo.setText("Sexo: " + usr.get_Sexo());
        edad.setText("Edad: " + usr.get_Edad().toString());
        peso.setText("Peso: " + usr.get_Peso().toString());
        altura.setText("Altura: " + usr.get_Altura().toString());
        ded.setText("Dedicacion: " + usr.get_Dedicacion().toString() + " veces por semana");
        obj.setText("Objetivo: " + usr.get_Objetivo());


        return vista;
    }


    public void onClick(View vista) {
        Button botonApretado;
        botonApretado= (Button) vista;
        if(edit.getId()== botonApretado.getId()){
            MainActivity main=(MainActivity) getActivity();
            main.pasarAEditar();
        }
        if(log.getId()== botonApretado.getId()){
            MainActivity main=(MainActivity) getActivity();
            main.pasarALogros();
        }

    }
}
