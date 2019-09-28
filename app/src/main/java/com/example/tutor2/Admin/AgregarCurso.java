package com.example.tutor2.Admin;

import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tutor2.R;

import java.util.ArrayList;

public class AgregarCurso extends AppCompatActivity {


    private Spinner spinnerciclo;
    private Spinner spinnercursos;
    ArrayAdapter<String> adaperspinner;
    ArrayAdapter<String> adaperspinner2;

    public static ArrayList<String> Cursos;
    public static ArrayAdapter<String> adapter;

    TextView txtcode,txtname;
    ListView lisview;
    ImageView img;

    private ArrayList<String> liscursos;
    private ArrayAdapter adaperliscursos;
    private static final String[] ciclos = new String []{"1er Ciclo","2do Ciclo","3er Ciclo","4 Ciclo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_curso);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtname=(TextView)findViewById(R.id.idnombrestutor);
        img=(ImageView)findViewById(R.id.idfototutor);

        txtcode=(TextView)findViewById(R.id.codigotutor);
        String dato=getIntent().getStringExtra("code" );
        String dato2=getIntent().getStringExtra("name" );
        txtcode.setText(dato);
        txtname.setText(dato2);
        Bundle bundle = this.getIntent().getExtras();
        int fo = bundle.getInt("foto");
      img.setImageResource(fo);

        lisview=(ListView)findViewById(R.id.idlisviewlista1);
        liscursos= new ArrayList<String>();
        adaperliscursos= new ArrayAdapter(this,android.R.layout.simple_list_item_1,liscursos);
        lisview.setAdapter(adaperliscursos);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)

                //.setAction("Action", null).show();
                mostrarDialogOpcione2();
            }
        });
    }

    public void mostrarDialogOpcione2(){

        Cursos=new ArrayList<String>();
        Cursos.add("Programacion 1");
        Cursos.add("Programacion 2");
        Cursos.add("Programacion 3");

        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Importante");

        adaperspinner2= new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,ciclos);
        adaperspinner= new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,Cursos);

        LayoutInflater inflater =this.getLayoutInflater();
        View view = inflater.inflate(R.layout.dialogo, null);

        dialogo1.setView(view)
                .setTitle("Agregar Curso")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String curso = spinnercursos.getSelectedItem().toString();
                        Toast.makeText(AgregarCurso.this, "Hola"+curso, Toast.LENGTH_SHORT).show();
                       Agregar(curso);
                    }
                });
        spinnerciclo=view.findViewById(R.id.idcicloo);
        spinnercursos=view.findViewById(R.id.idcursos);

        spinnerciclo.setAdapter(adaperspinner2);
        spinnercursos.setAdapter(adaperspinner);

        dialogo1.show();
    }

    public void Agregar(String curso){
        liscursos.add(curso);
        adaperliscursos.notifyDataSetChanged();
    }
}
