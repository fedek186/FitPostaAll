package com.example.fitpostaall;

import java.util.Date;

public class Usuario {
    private String _idUsuario;
    private String _Nombre;
    private String _Apellido;
    private String _Mail;
    private String _Contrasenia;
    private String _Sexo;
    private Date _Edad;
    private Integer _Altura;
    private Integer _Peso;
    private String _TipoAlimentacion;
    private String _idExperiencia;
    private Boolean _ModoLesion;
    private String _Foto;
    private String _Cita;
    private String _idCalendario;
    private String _Logros[];



    //getters
    public String get_idUsuario(){return _idUsuario;}
    public String get_Nombre(){return _Nombre;}
    public String get_Apellido(){return _Apellido;}
    public String get_Mail(){return _Mail;}
    public String get_Sexo(){return _Sexo;}
    public Date get_Edad(){return _Edad;}
    public Integer get_Altura(){return _Altura;}
    public Integer get_Peso(){return _Peso;}
    public String get_TipoAlimentacion(){return _TipoAlimentacion;}
    public String get_idExperiencia(){return _idExperiencia;}
    public Boolean get_ModoLesion(){return _ModoLesion;}
    public String get_Foto(){return _Foto;}
    public String get_Cita(){return _Cita;}
    public String get_idCalendario(){return _idCalendario;}
    public String get_Contrasenia() { return _Contrasenia;}
    public String[] get_Logros() {return _Logros; }

    //setters
    public void set_idUsuario(String newID){this._idUsuario = newID;}

    public void set_Apellido(String Apellido) {
        this._Apellido = Apellido;
    }

    public void set_Altura(Integer _Altura) {
        this._Altura = _Altura;
    }

    public void set_Cita(String _Cita) {
        this._Cita = _Cita;
    }

    public void set_Edad(Date _Edad) {
        this._Edad = _Edad;
    }

    public void set_Foto(String _Foto) {
        this._Foto = _Foto;
    }

    public void set_idCalendario(String _idCalendario) {
        this._idCalendario = _idCalendario;
    }

    public void set_idExperiencia(String _idExperiencia) {
        this._idExperiencia = _idExperiencia;
    }

    public void set_Mail(String _Mail) {
        this._Mail = _Mail;
    }

    public void set_ModoLesion(Boolean _ModoLesion) {
        this._ModoLesion = _ModoLesion;
    }

    public void set_Nombre(String _Nombre) {
        this._Nombre = _Nombre;
    }

    public void set_Peso(Integer _Peso) {
        this._Peso = _Peso;
    }

    public void set_Sexo(String _Sexo) {
        this._Sexo = _Sexo;
    }

    public void set_TipoAlimentacion(String _TipoAlimentacion) {
        this._TipoAlimentacion = _TipoAlimentacion;
    }

    public void set_Contrasenia(String _Contrasenia) {
        this._Contrasenia = _Contrasenia;
    }

    public void set_Logros(String[] _Logros) {
        this._Logros = _Logros;
    }

    //Constructor
    public Usuario(){
    this._idUsuario = "";
    this._Altura = 0;
    this._Apellido = "";
    this._Cita = "";
    this._Contrasenia = "";
    this._Edad = null;
    this._Foto = "";
    this._idCalendario = "";
    this._idExperiencia = "";
    this._Logros = null;
    this._Mail = "";
    this._ModoLesion = null;
    this._Nombre = "";
    this._Peso = 0;
    this._Sexo = "";
    this._TipoAlimentacion = "";

    }
}


