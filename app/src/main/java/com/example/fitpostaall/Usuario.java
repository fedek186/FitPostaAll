package com.example.fitpostaall;

import java.util.Date;

public class Usuario {
    private String _idUsuario;
    private String _Nombre;
    private String _Apellido;
    private String _Mail;
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




    //setters
    public void set_idUsuario(String newID){this._idUsuario = newID;}


}
