package com.example.tutor2.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.tutor2.R;

import java.util.ArrayList;

public class AgregarAlumno extends AppCompatActivity {


    private Spinner spinnerciclo;
    private Spinner spinnercursos;
    ArrayAdapter<String> adapterciclo;
    ArrayAdapter<String> adaperspinner2;
    public static ArrayList<String> Ciclo;
    public static ArrayAdapter<String> tutores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_alumno);

        Ciclo=new ArrayList<String>();
        Ciclo.add("1 Ciclo");
        Ciclo.add("2 Ciclo");
        Ciclo.add("3 Ciclo");
        spinnerciclo=findViewById(R.id.spinner);
        spinnercursos=findViewById(R.id.spinner2);

        adapterciclo= new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,Ciclo);
    //    adaperspinner= new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,Cursos);


        spinnerciclo.setAdapter(adapterciclo);
      //  spinnercursos.setAdapter(adaperspinner);
    }
}
