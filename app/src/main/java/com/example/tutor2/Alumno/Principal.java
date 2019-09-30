package com.example.tutor2.Alumno;

import android.net.Uri;
import android.os.Bundle;

import com.example.tutor2.FragmentAlumno.ContenedorFragment;
import com.example.tutor2.FragmentAlumno.CursosFragments;
import com.example.tutor2.FragmentAlumno.InformacionFragment;
import com.example.tutor2.FragmentAlumno.PerfilAlumnoFragment;
import com.example.tutor2.FragmentAlumno.TutoresFragments;
import com.example.tutor2.Fragments.NotificacionFragment;
import com.example.tutor2.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.MenuItem;
import android.widget.TextView;

public class Principal extends AppCompatActivity implements CursosFragments.OnFragmentInteractionListener, TutoresFragments.OnFragmentInteractionListener, PerfilAlumnoFragment.OnFragmentInteractionListener, ContenedorFragment.OnFragmentInteractionListener, InformacionFragment.OnFragmentInteractionListener {
    private TextView mTextMessage;


    private FragmentManager fragmentManager;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.idcursos:
             //       CursosFragments fragment = new CursosFragments();
                    PerfilAlumnoFragment fragment = new PerfilAlumnoFragment();
                   Cargar(fragment,fragmentManager);
                    return true;
                case R.id.idtutores:
                    TutoresFragments fragment1 = new TutoresFragments();
                   Cargar(fragment1,fragmentManager);



                    return true;
                case R.id.idnotification:
                 // fragment2 = new TutoresFragments();
               //     NotificacionFragment  fragment2= new NotificacionFragment();
                 //   Cargar(fragment2,fragmentManager);
                //    getSupportFragmentManager().beginTransaction().replace(R.id.conte_main,fragment2).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        BottomNavigationView navView = findViewById(R.id.nav_view2);

     navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fragmentManager = getSupportFragmentManager();
        PerfilAlumnoFragment curso = new PerfilAlumnoFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.idcontainerfragment3,curso).commit();


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
    public void Cargar(Fragment f1, FragmentManager fm){
        FragmentTransaction ft= fm.beginTransaction();
        ft.replace(R.id.idcontainerfragment3,f1).commit();

    }


}
