package com.example.fitpostaall;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

public class fragPerfilLogros extends Fragment {
    ListView lista;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista;
        vista = inflater.inflate(R.layout.layout_perfillogoros, container, false);
        lista=vista.findViewById(R.id.lista);
        return vista;
    }
}
