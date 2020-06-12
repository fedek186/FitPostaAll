package com.example.fitpostaall;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import java.util.Date;

public class logro {
    String _nombre;
    Date _fecha;
    Boolean _unblocked;
    Drawable _imagen;

    public logro(String nom, Date fech, Boolean val)
    {
    _nombre=nom;
    _fecha=fech;
    _unblocked=val;

    }
    public logro() {
    _unblocked=false;
    }
}



