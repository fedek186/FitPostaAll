package com.example.fitpostaall;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class adaptadorDeTiposEjercicios extends BaseAdapter {
    private ArrayList<TipoEjercicio> arrayTypeEx;
    private Context miContexto;
    TipoEjercicio miTypeEx= new TipoEjercicio();
    TextView Nomb,intro;
    ImageView imgPrin,Icon;
    Button Btn;
    public adaptadorDeTiposEjercicios(ArrayList<TipoEjercicio> arrEx, Context contexto) {
        arrayTypeEx = arrEx;
        miContexto = contexto;
    }

    @Override
    public int getCount() {
        return arrayTypeEx.size();
    }

    @Override
    public TipoEjercicio getItem(int position) {
        TipoEjercicio unTypeEx;
        unTypeEx = arrayTypeEx.get(position);
        return unTypeEx;
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
        vista = inflador.inflate(R.layout.layout_tipo_ejercicio, parent, false);
        Nomb = vista.findViewById(R.id.NombreTipoDeEjercicio);
        intro = vista.findViewById(R.id.textoIntoTipoEjer);
        imgPrin = vista.findViewById(R.id.imagenTipoDeEjercicio);
        Icon= vista.findViewById(R.id.iconoTipoDeEjercicio);
        Btn= vista.findViewById(R.id.btnTipoDeEjercicio);

        miTypeEx=getItem(position);
        Nomb.setText(miTypeEx._nombre);
        imgPrin.setImageDrawable(miTypeEx._imagen);
        Icon.setImageDrawable(miContexto.getResources().getDrawable(R.drawable.icon_ionic_md_fitness));
        if(miTypeEx._finish==false)
        {
            intro.setText("Siguiente");
            if(miTypeEx._rango!=10){
                Btn.setBackgroundResource(R.drawable.login);
                Btn.setText("Listo!");
            }
            else{
                Btn.setBackgroundResource(R.drawable.register);
                Icon.setImageDrawable(miContexto.getResources().getDrawable(R.drawable.icon_ionic_md_fitness));
                Btn.setText("Listo!");
            }
        }
        else {
            intro.setText("Finalizado");
            Btn.setText("Listo!");
            Btn.setBackgroundResource(R.drawable.slected);
        }

        return vista;
}


}
