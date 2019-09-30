package com.example.tutor2.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import com.example.tutor2.Adaptador.VerCursosAdapter;
import com.example.tutor2.Clases.VerCurso;
import com.example.tutor2.Clases.cursotutor;
import com.example.tutor2.Clases.personaje;
import com.example.tutor2.Conexion.ConexionSQLiteHelper;
import com.example.tutor2.R;
import com.example.tutor2.Util.Utilidades;

import java.util.ArrayList;

public class VerCursos extends AppCompatActivity {

    ArrayList<cursotutor> listavercursos;
    VerCursosAdapter adapter;

    RecyclerView recycler;
TextView nombre;
    ConexionSQLiteHelper conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_cursos);
        conn=new ConexionSQLiteHelper(getBaseContext(),"bd_datos",null,1);

        nombre=(TextView)findViewById(R.id.idnombres3);
        String apellido;
        apellido=getIntent().getStringExtra("ape2");
        nombre.setText(getIntent().getStringExtra("name2")+ " " +apellido);

        listavercursos= new ArrayList<>();

        recycler=(RecyclerView)findViewById(R.id.recyclerdetalle);
        recycler.setLayoutManager(new LinearLayoutManager(this));


        llenarlista();

         adapter= new VerCursosAdapter(listavercursos);
        recycler.setAdapter(adapter);

    }

    public void llenarlista() {

        SQLiteDatabase db=conn.getReadableDatabase();

        cursotutor cursutu=null;
        // listaUsuarios=new ArrayList<Usuario>();
        //select * from usuarios
        Cursor cursor=db.rawQuery("SELECT * FROM cursotutor ",null);

        while (cursor.moveToNext()){
            cursutu=new cursotutor();
            cursutu.setCurso(cursor.getString(1));

            listavercursos.add(cursutu);
        }
        db.close();
//        listavercursos.add(new cursotutor(R.drawable.cc,"Tecnias de Programacion"));


    }
}
