package com.example.tutor2.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.tutor2.Adaptador.VerCursosAdapter;
import com.example.tutor2.Clases.VerCurso;
import com.example.tutor2.R;

import java.util.ArrayList;

public class VerCursos extends AppCompatActivity {

    ArrayList<VerCurso> listavercursos;


    RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_cursos);

        listavercursos= new ArrayList<>();
        recycler=(RecyclerView)findViewById(R.id.recyclerdetalle);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        llenarlista();

        VerCursosAdapter adapter= new VerCursosAdapter(listavercursos);
        recycler.setAdapter(adapter);

    }

    private void llenarlista() {
        listavercursos.add(new VerCurso("Tecnias de Programacion",R.drawable.cc));
        listavercursos.add(new VerCurso("Tecnias de Programacion",R.drawable.cegato));

    }
}
