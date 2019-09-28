package com.example.tutor2.Tutor;

import android.net.Uri;
import android.os.Bundle;

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

public class InicioTutor extends AppCompatActivity implements Eventos_Fragment.OnFragmentInteractionListener {


    private FragmentManager fragmentManager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.eventos:
                    Eventos_Fragment eventos = new Eventos_Fragment();
                    Cargar(eventos,fragmentManager);
                    return true;
                case R.id.otro1:

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
    }

    public void Cargar(Fragment f1, FragmentManager fm){
        FragmentTransaction ft= fm.beginTransaction();
        ft.replace(R.id.idcontainerfragment2,f1).commit();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
