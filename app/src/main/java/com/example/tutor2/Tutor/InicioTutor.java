package com.example.tutor2.Tutor;

import android.net.Uri;
import android.os.Bundle;

import com.example.tutor2.FragmentTutor.Cursos_Tutores_Fragment;
import com.example.tutor2.FragmentTutor.Eventos_Fragment;
import com.example.tutor2.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class InicioTutor extends AppCompatActivity implements Eventos_Fragment.OnFragmentInteractionListener, Cursos_Tutores_Fragment.OnFragmentInteractionListener {

String dato;
    private FragmentManager fragmentManager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.eventos:
                    Eventos_Fragment eventos = new Eventos_Fragment();

                    Bundle bundle = getIntent().getExtras();
                    String texto = bundle.getString("code4");
                    Bundle args = new Bundle();
                    args.putString("code41", texto);
                    eventos.setArguments(args);

                    Cargar(eventos,fragmentManager);
                    return true;
                case R.id.otro1:
                    Cursos_Tutores_Fragment cursos  = new Cursos_Tutores_Fragment();
                    Cargar(cursos,fragmentManager);


                    return true;
                case R.id.otro2:

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_tutor);
        BottomNavigationView navView = findViewById(R.id.nav_view1);
        fragmentManager = getSupportFragmentManager();
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Bundle bundle = getIntent().getExtras();

        String texto = bundle.getString("code4");
        Bundle args = new Bundle();
        args.putString("code41", texto);


        Eventos_Fragment fragment = new Eventos_Fragment();
        fragment.setArguments(args);
        getSupportFragmentManager().beginTransaction().replace(R.id.idcontainerfragment2,fragment).commit();
    }

    public void Cargar(Fragment f1, FragmentManager fm){
        FragmentTransaction ft= fm.beginTransaction();
        ft.replace(R.id.idcontainerfragment2,f1).commit();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
