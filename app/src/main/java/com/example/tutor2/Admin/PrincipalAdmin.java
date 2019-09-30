package com.example.tutor2.Admin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.tutor2.Clases.Notificacion;
import com.example.tutor2.Clases.personaje;
import com.example.tutor2.Fragments.FragmentAgregar;
import com.example.tutor2.Fragments.ListaTutorFragment;
import com.example.tutor2.Fragments.NotificacionFragment;
import com.example.tutor2.Fragments.RegistrarTutorFragment;
import com.example.tutor2.Interfaces.Icomunica1;
import com.example.tutor2.Interfaces.Icomunica2;
import com.example.tutor2.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.MenuItem;
import android.widget.ImageView;

public class PrincipalAdmin extends AppCompatActivity implements RegistrarTutorFragment.OnFragmentInteractionListener,ListaTutorFragment.OnFragmentInteractionListener,NotificacionFragment.OnFragmentInteractionListener, FragmentAgregar.OnFragmentInteractionListener, Icomunica1, Icomunica2 {



    private FragmentManager fragmentManager;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    RegistrarTutorFragment fragment = new RegistrarTutorFragment();

                    Cargar(fragment,fragmentManager);
                    return true;
                case R.id.navigation_dashboard:
                  ListaTutorFragment fragment1 = new ListaTutorFragment();
                  //  Cargar(fragment1,fragmentManager);

                  //  RegistrarTutorFragment fragment1 = new RegistrarTutorFragment();


                    //  Cargar(R.id.idcontainerfragment,fragmentManager);
                    getSupportFragmentManager().beginTransaction().replace(R.id.idcontainerfragment,fragment1).commit();
                   return true;
                case R.id.navigation_notifications:
                    NotificacionFragment fragment2 = new NotificacionFragment();

                    Cargar(fragment2,fragmentManager);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_admin);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fragmentManager = getSupportFragmentManager();

        ListaTutorFragment fragment = new ListaTutorFragment();

      //  Cargar(R.id.idcontainerfragment,fragmentManager);
        getSupportFragmentManager().beginTransaction().replace(R.id.idcontainerfragment,fragment).commit();

    }

    public void Cargar(Fragment f1, FragmentManager fm){
            FragmentTransaction ft= fm.beginTransaction();
            ft.replace(R.id.idcontainerfragment,f1).commit();

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    @Override
    public void EnviarDetalle(personaje per) {
//        DetalleTutoresFragments curso = new DetalleTutoresFragments();

      //  Bundle  bundle= new Bundle();
        //bundle.putString("codio",);
      //  Toast.makeText(this, "llego aqui", Toast.LENGTH_SHORT).show();
    //   getSupportFragmentManager().beginTransaction().replace(R.id.idcontainerfragment,curso).commit();
    }

    @Override
    public void EnviarDetalle(Notificacion noti) {
        String nombre,nombreestu;
        ImageView foto;
        nombre=noti.getNombrecurso();
        nombreestu=noti.getNombreestudainte();
        //  foto.setImageResource(personaje.getFoto());

     //   int img;
       // img=noti.getFoto();

        Intent intent = new Intent(PrincipalAdmin.this,DetalleNotificacion.class);
        Bundle bundle = new Bundle();
        bundle.putString("name",nombre);
        bundle.putString("foto",nombreestu);

        intent.putExtras(bundle);
        startActivity(intent);
    }
}
