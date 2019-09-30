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


//---------------------------TABLA CURSO STUTOR
    public static final String TABLA_TUTOR_CURSO="cursotutor";

    public static final String CAMPO_CODIGO_TUTOR="codigotutor";
    public static final String CAMPO_CURSO="curso";

    public static final String CREAR_TABLA_CURSO_TUTOR="CREATE TABLE "+
        ""+ TABLA_TUTOR_CURSO +" ( " + CAMPO_CODIGO_TUTOR +" " +
         "INTEGER, " +CAMPO_CURSO +" TEXT)";



    //--------------------- TABLA EVENTO--------
    public static final String TABLA_EVENTO_TUTOR="evento";

    public static final String CodigoEvento="codigoevento";
    public static final String CAMPO_CODIGO_TUTORE="codigotutor";
    public static final String CAMPO_TITULO_EVENTO="titulo";
    public static final String CAMPO_CURSO_EVENTO="curso";
    public static final String CAMPO_LUGAR_EVENTO="lugarevento";
    public static final String CAMPO_FECHA_EVENTO="fechaevento";
    public static final String CAMPO_DESCRIPCION_EVENTO="descripcion";
    public static final String CAMPO_HORA_EVENTO="horaevento";
    public static final String CAMPO_ESTADO_EVENO="estadoevento";

    public static String CREAR_TABLA_EVENTOS_DE_TUTOR="CREATE TABLE "+
            ""+TABLA_EVENTO_TUTOR +"("+CodigoEvento+" "+
            "INTEGER PRIMARY KEY AUTOINCREMENT , "+ CAMPO_CODIGO_TUTORE+" INTEGER ,"+ CAMPO_TITULO_EVENTO+" "+
            "TEXT, "+CAMPO_CURSO_EVENTO +" TEXT, "+CAMPO_LUGAR_EVENTO +" TEXT ,"+ CAMPO_FECHA_EVENTO +" TEXT, " +CAMPO_DESCRIPCION_EVENTO +" TEXT , "+
            CAMPO_HORA_EVENTO+ " TEXT  ," +CAMPO_ESTADO_EVENO +" TEXT)";

}
