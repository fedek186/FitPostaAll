package com.example.fitpostaall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class adaptadorDePlatos extends BaseAdapter {
    private ArrayList<plato> arrayPlato;
    private Context miContexto;
    TextView nomb,nutri,desc;
    ImageView Imagen;
    plato miPlato= new plato();

    public adaptadorDePlatos (ArrayList<plato> arrPlat, Context contexto) {
        arrayPlato= arrPlat;
        miContexto = contexto;
    }
    @Override
    public int getCount() {
        return arrayPlato.size();
    }

    @Override
    public plato getItem(int position) {
        plato unPlato;
        unPlato = arrayPlato.get(position);
        return unPlato;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vista;
        LayoutInflater inflador;
        inflador = (LayoutInflater) miContexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        vista = inflador.inflate(R.layout.layout_una_comida, parent, false);
        nomb = vista.findViewById(R.id.NombrePlato);
        nutri = vista.findViewById(R.id.NutrientesPlato);
        desc = vista.findViewById(R.id.DescPlato);
        Imagen = vista.findViewById(R.id.imageViewFotoPlato);

        miPlato=getItem(position);
        nomb.setText(miPlato._nombre);
        nutri.setText(miPlato._nutrientes);
        desc.setText(miPlato._desc);
        Imagen.setImageDrawable(miPlato._imagen);
        return vista;
    }

}
