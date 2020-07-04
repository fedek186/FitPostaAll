package com.example.fitpostaall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class adaptadorDePlatosRecycle extends RecyclerView.Adapter{
    private ArrayList<plato> arrayPlato;
    private Context miContexto;
    private OnFoodListener onFoodListener;
    public adaptadorDePlatosRecycle(ArrayList<plato> arrayPlato, Context miContexto, OnFoodListener onf) {
        this.arrayPlato = arrayPlato;
        this.miContexto = miContexto;
        this.onFoodListener=onf;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType)
    {
        View vista = LayoutInflater.from(miContexto).inflate(R.layout.layout_una_comida,null);

        return new Holder(vista,onFoodListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        plato miPlato= arrayPlato.get(position);
        Holder Holder=(Holder) holder;
        Holder.nomb.setText(miPlato._nombre);
        Holder.desc.setText(miPlato._desc);
        Holder.nutri.setText(miPlato._nutrientes);
        Holder.Imagen.setImageDrawable(miPlato._imagen);
    }

    @Override
    public int getItemCount() {
        return arrayPlato.size();
    }

    public static class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView nomb,nutri,desc;
        ImageView Imagen;
        OnFoodListener onFoodList;

        public Holder(@NonNull View vista,OnFoodListener onFood) {
            super(vista);
            nomb = vista.findViewById(R.id.NombrePlato);
            nutri = vista.findViewById(R.id.NutrientesPlato);
            desc = vista.findViewById(R.id.DescPlato);
            Imagen = vista.findViewById(R.id.imageViewFotoPlato);
            this.onFoodList=onFood;
            vista.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
        onFoodList.onFoodClick(getAdapterPosition());
        }
    }

    public interface OnFoodListener{
        void onFoodClick(int pos);
    }



}
