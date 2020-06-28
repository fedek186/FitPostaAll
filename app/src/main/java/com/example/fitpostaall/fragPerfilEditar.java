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
    Button right,left;
    EditText edxP,edxA;
    TextView txtDed;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista;
        vista=inflater.inflate(R.layout.layout_perfileditar,container,false);
        right=vista.findViewById(R.id.imgbArrowRightDedicacion);
        left=vista.findViewById(R.id.imgbArrowLeftDedicacion);
        edxP=vista.findViewById(R.id.edxPeso);
        edxA=vista.findViewById(R.id.edxAltura);
        txtDed=vista.findViewById(R.id.txtDedicacionEnEditText);
        right.setOnClickListener(this);
        left.setOnClickListener(this);
        return vista;
    }


    public void onClick(View vista) {
        Button botonApretado;
        botonApretado= (Button) vista;
        if(right.getId()== botonApretado.getId()){
            if(txtDed.getText().toString().equals("3 veces por semana"))
            {
                txtDed.setText("4 veces por semana");
            }
            if(txtDed.getText()=="4 veces por semana")
            {
                txtDed.setText("5 veces por semana");
                right.setVisibility(View.GONE);
            }
            if(txtDed.getText()=="2 veces por semana")
            {
                txtDed.setText("3 veces por semana");
            }
            if(txtDed.getText()=="1 veces por semana")
            {
                txtDed.setText("2 veces por semana");
            }
        }
        if(left.getId()== botonApretado.getId()){
            if(txtDed.getText().toString().equals("3 veces por semana"))
            {
                txtDed.setText("2 veces por semana");
            }
            if(txtDed.getText()=="4 veces por semana")
            {
                txtDed.setText("3 veces por semana");

            }
            if(txtDed.getText()=="2 veces por semana")
            {
                txtDed.setText("1 veces por semana");
                left.setVisibility(View.GONE);
            }
            if(txtDed.getText().toString().equals("5 veces por semana"))
            {
                txtDed.setText("4 veces por semana");
            }
        }
    }
}
