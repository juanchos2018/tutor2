package com.example.tutor2.Conexion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.tutor2.Util.Utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {
    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_USUARIO);
        db.execSQL(Utilidades.CREAR_TABLA_CURSO_TUTOR);
        db.execSQL(Utilidades.CREAR_TABLA_EVENTOS_DE_TUTOR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_TUTOR);
        db.execSQL("DROP TABLE IF EXISTS " +Utilidades.TABLA_TUTOR_CURSO);
        db.execSQL("DROP TABLE IF EXISTS " + Utilidades.TABLA_EVENTO_TUTOR);
        onCreate(db);


    }
}
