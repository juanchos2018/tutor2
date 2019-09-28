package com.example.tutor2.Util;

public class Utilidades {
    public static final String TABLA_TUTOR="usuario";

    public static final String CAMPO_CODIGO="codigo";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_APELLIDO="apellido";
    public static final String CAMPO_TELEFONO="telefono";
    public static final String CAMPO_CICLO="ciclo";
    public static final String CAMPO_CURSOS="cursos";
    public static final String CAMPO_CLAVE="clave";

    public static final String CREAR_TABLA_USUARIO="CREATE TABLE " +
            ""+TABLA_TUTOR+" ("+CAMPO_CODIGO+" " +
            "INTEGER, "+CAMPO_NOMBRE+" TEXT,"+CAMPO_APELLIDO+" TEXT ," + CAMPO_TELEFONO+ " TEXT ,"+ CAMPO_CICLO +" TEXT ,"+ CAMPO_CURSOS +" TEXT , " + CAMPO_CLAVE +" TEXT )";
}
