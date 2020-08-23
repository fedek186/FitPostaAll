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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Locale;

public class fragmentSerieEjercicios extends Fragment implements View.OnClickListener {
    Button sigui,atras;
    TextView txtN,txtI,txtCrono;
    ImageView imgE,paus,play;
    MainActivity main;
    ArrayList<Ejercicio> lisEj;
    int i;
    Boolean pausa=false;
    CountDownTimer countDown,countProgress,CountDownStart;
    long Start,leftTime;
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
        paus=vista.findViewById(R.id.pause);
        play=vista.findViewById(R.id.play);
        sigui.setOnClickListener(this);
        atras.setOnClickListener(this);
        lisEj=main.devolverArrayEj();
        progressBarStatus=0;
        pb.setProgress(0);
        cargarDatos();
        mostrarTiempo();
        comienzo();
        return vista;
    }
    public void onClick(View vista) {
        Button botonApretado;
        botonApretado= (Button) vista;

        if(atras.getId()== botonApretado.getId())
        {
            main.iListaEj = 0;
            main.pasarANav();
        }
        if(sigui.getId()== botonApretado.getId()  && pausa == false){
            paus.setVisibility(View.GONE);
            play.setVisibility(View.VISIBLE);
            pb.clearAnimation();
            countDown.cancel();
            countProgress.cancel();
            pausa=true;
        }
        else if(sigui.getId()== botonApretado.getId()  && pausa == true){
            paus.setVisibility(View.VISIBLE);
            play.setVisibility(View.GONE);
            comenzar();
            run();
        }
    }

    public void comienzo() {
        CountDownStart = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }
            @Override
            public void onFinish() {
                sigui.setEnabled(true);
                CountDownStart.cancel();
                comenzar();
                run();
            }
        }.start();
    }
    public void run() {
        countProgress = new CountDownTimer(leftTime, 1) {
            @Override
            public void onTick(long millisUntilFinished) {

                progress += 100;
                pb.setProgress(progress);
                mostrarTiempo();
                leftTime =millisUntilFinished;
                Log.d("RAF", String.valueOf(Start));
            }

            @Override
            public void onFinish() {
                pb.setProgress((int) Start);

            }
        }.start();

    }
    public void comenzar(){

        countDown= new CountDownTimer(leftTime, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.d("RAF", String.valueOf(leftTime));
                leftTime =millisUntilFinished;
                //progress = (int) (Start-leftTime);
                //progressBarStatus =progress;
                //pb.setProgress(progressBarStatus);
                Log.d("RAF", String.valueOf(leftTime));
            }

            @Override
            public void onFinish() {
               // pb.setProgress((int) Start);
                countDown.cancel();


                if( main.iListaEj<lisEj.size())
                {
                    main.recebirSigEj(lisEj.get(main.iListaEj));
                    main.pasarADescanso();

                }else {
                    countDown.cancel();
                    main.pasarArta();
                }


            }
        }.start();
        pausa=false;
    }
    public void cargarDatos()
    {
        Double time;
        txtI.setText((main.iListaEj+1)+"/"+lisEj.size());
        imgE.setImageDrawable(lisEj.get(main.iListaEj).get_Foto());
        txtN.setText(lisEj.get(main.iListaEj).get_NombreEjercicio());
        time=lisEj.get(main.iListaEj).get_Seg()* 1000;
        Log.d("RAF", String.valueOf(time));
        Start=time.longValue();
        leftTime=Start ;
        pb.setMax(((int) Start ));
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