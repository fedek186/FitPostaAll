package com.example.fitpostaall;

import java.util.Calendar;
import java.util.Date;

public class tipoEvento {
    private Calendar _fecha;
    private Boolean _tipo;

    public void setDate(Calendar fecha) {
        this._fecha = fecha;
    }

    public void setTipo(Boolean tipo) {
        this._tipo = tipo;
    }

    public Calendar getDate() {return _fecha;}
}
