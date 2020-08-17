package com.example.fitpostaall;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class fragmentSerieEjercicios extends Fragment implements View.OnClickListener {
    Button sigui,atras;
    TextView txtN,txtI,txtCrono;
    ImageView imgE;
    MainActivity main;
    ArrayList<Ejercicio> lisEj;
    int i;
    Boolean pausa=true;
    CountDownTimer countDown;
    long Start=10100,leftTime= Start;
    ProgressBar pb;
    int progress,progressBarStatus;








    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista;
        vista=inflater.inflate(R.layout.layout_serie_ejercicios,container,false);
        i=0;

        main= (MainActivity) getActivity();
        sigui=vista.findViewById(R.id.btnEj);
        atras=vista.findViewById(R.id.atrasEJEnSer);
        txtI=vista.findViewById(R.id.cantI);
        txtN=vista.findViewById(R.id.nombEjer);
        imgE=vista.findViewById(R.id.imagenEj);
        txtCrono = vista.findViewById(R.id.cronometro);
        pb= vista.findViewById(R.id.determinateBar);
        sigui.setOnClickListener(this);
        atras.setOnClickListener(this);
        lisEj=main.devolverArrayEj();
        progressBarStatus=0;
        pb.setProgress(0);
        pb.setMax(((int) Start));
        pb.setVisibility(View.VISIBLE);
        mostrarTiempo();
        cargarDatos();
        return vista;
    }
    public void onClick(View vista) {
        Button botonApretado;
        botonApretado= (Button) vista;
        if(atras.getId()== botonApretado.getId())
        {
            countDown.cancel();
            main.iListaEj = 0;
            main.pasarANav();
        }

        if(sigui.getId()== botonApretado.getId() && pausa == false){
            countDown.cancel();
            pb.clearAnimation();
            pausa=true;
        }
        else if(sigui.getId()== botonApretado.getId() && pausa == true){
            comenzar();


        }
    }

    public void comenzar(){

        countDown= new CountDownTimer(leftTime, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                leftTime =millisUntilFinished;
                mostrarTiempo();
                progress = (int) (Start-leftTime);
                progressBarStatus =progress;
                pb.setProgress(progressBarStatus);
            }

            @Override
            public void onFinish() {
                pb.setProgress((int) Start);
                countDown.cancel();


                if( main.iListaEj<lisEj.size())
                {
                    main.recebirSigEj(lisEj.get(main.iListaEj));
                    main.pasarADescanso();

                }else {
                    txtN.setText("Finalizaste");
                    countDown.cancel();
                    main.pasarArta();
                }


            }
        }.start();
        pausa=false;
    }
    public void cargarDatos()
    {
        txtI.setText((main.iListaEj+1)+"/"+lisEj.size());
        imgE.setImageDrawable(lisEj.get(main.iListaEj).get_Foto());
        txtN.setText(lisEj.get(main.iListaEj).get_NombreEjercicio());
        leftTime=Start;
        //comenzar();
        main.iListaEj++;

    }
    public void mostrarTiempo()
    {
        int minutes = (int) (leftTime/1000)/60;
        int seconds = (int) (leftTime/1000)%60;
        String der= String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        txtCrono.setText(der);
    }



}