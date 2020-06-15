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
    TextView edit ;
    Button log;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista;
        vista=inflater.inflate(R.layout.layout_perfil,container,false);
        edit=vista.findViewById(R.id.txtEdadEnPerfil);
        log=vista.findViewById(R.id.txtLogroEnPerfil);
        log.setOnClickListener(this);
        edit.setOnClickListener(this);
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
