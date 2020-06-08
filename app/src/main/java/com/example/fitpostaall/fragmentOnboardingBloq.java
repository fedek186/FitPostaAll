package com.example.fitpostaall;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
public class fragmentOnboardingBloq extends Fragment implements View.OnClickListener {
    ImageView flecha;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista;
        vista = inflater.inflate(R.layout.layout_onboardingbloqueado, container, false);
        flecha = vista.findViewById(R.id.imageViewFlechaOrang);
        return vista;
    }

    public void onClick(View vista) {
        Button botonApretado;
        botonApretado = (Button) vista;
        if (botonApretado.getId() == flecha.getId()) {
            MainActivity main = (MainActivity) getActivity();
            main.pasarAonboraingBloq();
        }
    }
}
