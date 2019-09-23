package com.example.tutor2.Alumno;

import android.net.Uri;
import android.os.Bundle;

import com.example.tutor2.Clases.personaje;
import com.example.tutor2.Fragments.CursosFragments;
import com.example.tutor2.Fragments.DetalleTutoresFragments;
import com.example.tutor2.Fragments.ListaTutorFragment;
import com.example.tutor2.Fragments.RegistrarTutorFragment;
import com.example.tutor2.Fragments.TutoresFragments;
import com.example.tutor2.Interfaces.Icomunica1;
import com.example.tutor2.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.MenuItem;
import android.widget.TextView;

public class Principal extends AppCompatActivity implements CursosFragments.OnFragmentInteractionListener, TutoresFragments.OnFragmentInteractionListener{
    private TextView mTextMessage;


    private FragmentManager fragmentManager;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.idcursos:
                    CursosFragments fragment = new CursosFragments();

                   Cargar(fragment,fragmentManager);
                    return true;
                case R.id.idtutores:
                    TutoresFragments fragment1 = new TutoresFragments();
                   Cargar(fragment1,fragmentManager);

                //    CursosFragments curso = new CursosFragments();
                 //   getSupportFragmentManager().beginTransaction().replace(R.id.idcontainerfragment2,fragment1).commit();

                    return true;
                case R.id.idnotification:

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
        CursosFragments curso = new CursosFragments();
        getSupportFragmentManager().beginTransaction().replace(R.id.idcontainerfragment2,curso).commit();


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
    public void Cargar(Fragment f1, FragmentManager fm){
        FragmentTransaction ft= fm.beginTransaction();
        ft.replace(R.id.idcontainerfragment2,f1).commit();

    }


}
