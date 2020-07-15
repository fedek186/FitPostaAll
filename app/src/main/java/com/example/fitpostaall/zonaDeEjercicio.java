package com.example.fitpostaall;


import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

public class zonaDeEjercicio {
    private String _idZonaDeEjercicio;
    private List<String> _listaEjrecicios;
    private String _Foto;
    private Drawable _img;


    public Drawable get_Foto() {
        return _img;
    }


    public List<String> get_listaEjrecicios() {
        return _listaEjrecicios;
    }

    public String get_idZonaDeEjercicio() {
        return _idZonaDeEjercicio;
    }

    public void set_Foto(String _Foto) {
        this._Foto = _Foto;
    }

    public void set_idZonaDeEjercicio(String _idZonaDeEjercicio) {
        this._idZonaDeEjercicio = _idZonaDeEjercicio;
    }

    public void set_listaEjrecicios(List<String> _listaEjrecicios) {
        this._listaEjrecicios = _listaEjrecicios;
    }

    public zonaDeEjercicio(){
        this._Foto = "";
        this._idZonaDeEjercicio = "";
        this._listaEjrecicios = new ArrayList<>();
    }

    public void set_img(Drawable img) {
        this._img=img;
    }
}