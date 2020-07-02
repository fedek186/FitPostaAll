package com.example.fitpostaall;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class fragPerfilEditar extends Fragment implements View.OnClickListener{
    Button right,left,conf;
    EditText edxP,edxA,edxsex,edxfech,edxMail;
    TextView txtDed,txtNom,txtCita;
    Usuario usr=new Usuario();
    MainActivity main;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista;
        vista=inflater.inflate(R.layout.layout_perfileditar,container,false);
        main =(MainActivity) getActivity();
        usr = main.devolverUsuarioActivo();
        right=vista.findViewById(R.id.imgbArrowRightDedicacion);
        left=vista.findViewById(R.id.imgbArrowLeftDedicacion);
        edxP=vista.findViewById(R.id.edxPeso);
        edxA=vista.findViewById(R.id.edxAltura);
        txtDed=vista.findViewById(R.id.txtDedicacionEnEditText);
        txtNom=vista.findViewById(R.id.nombreEditPerfil);
        txtCita=vista.findViewById(R.id.txtCitaEnEditPerfil);
        edxsex=vista.findViewById(R.id.edxSexo);
        edxfech=vista.findViewById(R.id.edxFecha);
        edxMail=vista.findViewById(R.id.edxMailnEditText);
        conf=vista.findViewById(R.id.btnConfCambio);
        right.setOnClickListener(this);
        left.setOnClickListener(this);
        conf.setOnClickListener(this);
        txtNom.setText(usr.get_Nombre() +" " + usr.get_Apellido());
        txtCita.setText(usr.get_Cita());
        edxsex.setText(usr.get_Sexo());
        edxfech.setText(usr.get_Edad().toString());
        edxP.setText(usr.get_Peso().toString());
        edxA.setText(usr.get_Altura().toString());
        txtDed.setText(usr.get_Dedicacion().toString() + " veces por semana");

        return vista;
    }


    public void onClick(View vista) {
        Button botonApretado;
        botonApretado= (Button) vista;
        if(right.getId()== botonApretado.getId()){
            if(txtDed.getText().toString().equals("3.0 veces por semana"))
            {
                txtDed.setText("4.0 veces por semana");
            }
            else if(txtDed.getText()=="4.0 veces por semana")
            {
                txtDed.setText("5.0 veces por semana");
            }
           else if(txtDed.getText()=="2 veces por semana")
            {
                txtDed.setText("3.0 veces por semana");
            }
           else if(txtDed.getText()=="1.0 veces por semana")
            {
                txtDed.setText("2.0 veces por semana");
            }
        }
        if(left.getId()== botonApretado.getId()){
            if(txtDed.getText().toString().equals("3.0 veces por semana"))
            {
                txtDed.setText("2.0 veces por semana");
            }
           else if(txtDed.getText()=="4.0 veces por semana")
            {
                txtDed.setText("3.0 veces por semana");

            }
            else if(txtDed.getText()=="2.0 veces por semana")
            {
                txtDed.setText("1.0 veces por semana");
            }
            else if(txtDed.getText().toString().equals("5.0 veces por semana"))
            {
                txtDed.setText("4.0 veces por semana");
            }
        }

        if(conf.getId()==botonApretado.getId())
        {
            main =(MainActivity) getActivity();
            usr = main.devolverUsuarioActivo();
        }
    }



}
