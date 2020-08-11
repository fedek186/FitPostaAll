package com.example.fitpostaall;

import android.app.Fragment;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Locale;

public class fragDescanso extends Fragment implements View.OnClickListener {
    TextView txtSigEj,cron;
    long Start=20000,leftTime= Start;
    CountDownTimer countDown;
    MainActivity main;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista;
        vista=inflater.inflate(R.layout.layout_descanso,container,false);
        main= (MainActivity) getActivity();
        cron=vista.findViewById(R.id.cronometroDes);
        txtSigEj=vista.findViewById(R.id.SigEjer);
        comenzar();
        return vista;
    }

    public void comenzar()
    {
        countDown= new CountDownTimer(leftTime, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                leftTime=millisUntilFinished;
                mostrarTiempo();
            }

            @Override
            public void onFinish() {
                countDown.cancel();
                    main.pasarASerieEjer();
            }
        }.start();
    }
    public void mostrarTiempo()
    {
        int minutes = (int) (leftTime/1000)/60;
        int seconds = (int) (leftTime/1000)%60;
        String der= String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        cron.setText(der);
    }
    @Override
    public void onClick(View v) {
    }
}
