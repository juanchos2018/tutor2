package com.example.tutor2.Fragments;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tutor2.Adaptador.perosonajeadapter;
import com.example.tutor2.Alumno.Principal;
import com.example.tutor2.Clases.claseagregar;
import com.example.tutor2.Clases.personaje;
import com.example.tutor2.Conexion.ConexionSQLiteHelper;
import com.example.tutor2.Helper.MyButtonClickListener;
import com.example.tutor2.Helper.MySwipeHelper;
import com.example.tutor2.Interfaces.Icomunica1;
import com.example.tutor2.Login;
import com.example.tutor2.R;
import com.example.tutor2.Util.Utilidades;
import com.google.android.material.behavior.SwipeDismissBehavior;

import java.util.ArrayList;
import java.util.List;


public class ListaTutorFragment extends Fragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Activity activity;
    Button btnabrir;
    RecyclerView recycler;
   ArrayList<personaje> listaPersonaje;
    Icomunica1 interfas;
    ImageButton img;
        Button btn;

        EditText e1,e2,e3,e4;
        EditText ee1,ee2,ee3,ee4,eciclo;
    ConexionSQLiteHelper conn;
    perosonajeadapter adapter;

    Spinner spinerciclo,spinerciclo1;
    ArrayList<String> Ciclos;
    ArrayAdapter<String> adapterciclos;

    private OnFragmentInteractionListener mListener;

    public ListaTutorFragment() {

    }

    // TODO: Rename and change types and number of parameters
    public static ListaTutorFragment newInstance(String param1, String param2) {
        ListaTutorFragment fragment = new ListaTutorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       final View vista=  inflater.inflate(R.layout.fragment_lista_tutor, container, false);

         conn=new ConexionSQLiteHelper(getContext(),"bd_datos",null,1);
        btnabrir=(Button)vista.findViewById(R.id.idagregarverdad);
        // Eliminar();
        Ciclos=new ArrayList<String>();
        Ciclos.add("1 Ciclo");
        Ciclos.add("2 Ciclo");
        Ciclos.add("3 Ciclo");

        adapterciclos= new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item,Ciclos);

        listaPersonaje = new ArrayList<>();
        recycler = (RecyclerView) vista.findViewById(R.id.recyclerId1);
        recycler.setLayoutManager(new LinearLayoutManager(this.getContext()));
        consultarListaPersonas();
       adapter= new perosonajeadapter(listaPersonaje);
        recycler.setAdapter(adapter);
        btnabrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                LayoutInflater inflater = getActivity().getLayoutInflater();
                View view2 = inflater.inflate(R.layout.dialogo_agregar, null);
                builder.setView(view2)

                        .setPositiveButton("REGISTRAR", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                personaje o = new personaje();
                                o.setCodigo(e1.getText().toString());
                                o.setNombre(e2.getText().toString());
                                o.setApellido(e3.getText().toString());
                                o.setTelefono(e4.getText().toString());
                                o.setCiclo(spinerciclo.getSelectedItem().toString());
                                o.setCanctursos("0");
                                o.setClave(e1.getText().toString());


                                llenarLista(o);
                            }
                        });

                builder.show();
               e1=(EditText)view2.findViewById(R.id.agrega); // codigo
               e2=(EditText)view2.findViewById(R.id.idnom);
               e3=(EditText)view2.findViewById(R.id.idape);
               e4=(EditText)view2.findViewById(R.id.idtelefono);
               spinerciclo=(Spinner)view2.findViewById(R.id.spinerciclo);

                spinerciclo.setAdapter(adapterciclos);
            }
        });

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //    Toast.makeText(getContext(), "Selecciono"+listaPersonaje.get(recycler.getChildAdapterPosition(view)).getNombre(), Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                LayoutInflater inflater = getActivity().getLayoutInflater();
                View view2 = inflater.inflate(R.layout.modificarelimnar, null);
                builder.setView(view2)

                        .setNegativeButton("Eliminar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setPositiveButton("Actualizar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            //    Toast.makeText(getContext(), "hola", Toast.LENGTH_SHORT).show();
                               personaje o = new personaje();
                                o.setCodigo(ee1.getText().toString());
                                o.setNombre(ee2.getText().toString());
                                o.setApellido(ee3.getText().toString());
                                o.setTelefono(ee4.getText().toString());
                     //           Modificar(o);
                                Modificar();
                            //    Toast.makeText(getContext(), "hola"+ ee1.getText().toString(), Toast.LENGTH_SHORT).show();

                            }
                        });


                builder.show();
                ee1=(EditText)view2.findViewById(R.id.agrega1); // codigo
                ee2=(EditText)view2.findViewById(R.id.idnom1);
                ee3=(EditText)view2.findViewById(R.id.idape1);
                ee4=(EditText)view2.findViewById(R.id.idtelefono1);
                eciclo=(EditText)view2.findViewById(R.id.idcicloo1);
             //   spinerciclo1=(Spinner)view2.findViewById(R.id.spinerciclo1);

                ee1.setText(listaPersonaje.get(recycler.getChildAdapterPosition(view)).getCodigo());
                ee2.setText(listaPersonaje.get(recycler.getChildAdapterPosition(view)).getNombre());
                ee3.setText(listaPersonaje.get(recycler.getChildAdapterPosition(view)).getApellido());
                ee4.setText(listaPersonaje.get(recycler.getChildAdapterPosition(view)).getTelefono());
                eciclo.setText(listaPersonaje.get(recycler.getChildAdapterPosition(view)).getCiclo());
            //    spinerciclo1.setT


            }
        });


        return vista;
    }

    private void llenarLista(personaje datos) {

      /*  listaPersonaje.add(datos);
        recycler.setAdapter(adapter);*/
      listaPersonaje.clear();
        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_CODIGO,datos.getCodigo());
        values.put(Utilidades.CAMPO_NOMBRE,datos.getNombre());
        values.put(Utilidades.CAMPO_APELLIDO,datos.getApellido());
        values.put(Utilidades.CAMPO_TELEFONO,datos.getTelefono());
        values.put(Utilidades.CAMPO_CICLO,datos.getCiclo());
        values.put(Utilidades.CAMPO_CURSOS,datos.getCanctursos());
        values.put(Utilidades.CAMPO_CLAVE,datos.getClave());

        //Long idResultante=db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID,values);
        db.insert(Utilidades.TABLA_TUTOR,null,values);

        Toast.makeText(getContext(),"Registrado: ",Toast.LENGTH_SHORT).show();
        db.close();

        consultarListaPersonas();
    /*   listaPersonaje.add(new personaje("20130303","vago",R.drawable.bart));
        listaPersonaje.add(new personaje("20130302","Vago 2",R.drawable.lisa));
        listaPersonaje.add(new personaje("20130301","Vago 3",R.drawable.homero));
*/
    }
    public void consultarListaPersonas() {
        SQLiteDatabase db=conn.getReadableDatabase();

        personaje usuario=null;
        // listaUsuarios=new ArrayList<Usuario>();
        //select * from usuarios
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_TUTOR,null);

        while (cursor.moveToNext()){
            usuario=new personaje();
            usuario.setCodigo(cursor.getString(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setApellido(cursor.getString(2));
            usuario.setTelefono(cursor.getString(3));
            usuario.setCiclo(cursor.getString(4));

            listaPersonaje.add(usuario);
        }
        db.close();
       /* listaPersonaje.add(usuario);
        adapter= new perosonajeadapter(listaPersonaje);
        recycler.setAdapter(adapter);*/
    }

    public void Modificar(){
        listaPersonaje.clear();
        SQLiteDatabase db=conn.getWritableDatabase();

        String codigo =     ee1.getText().toString();
        String nombre = ee2.getText().toString();
        String apellido =     ee3.getText().toString();
        String telefonno =     ee4.getText().toString();

        //if (!codigo.isEmpty() && !descipcion.isEmpty() && !precio.isEmpty()){
            ContentValues registro= new ContentValues();
            registro.put("codigo",codigo);
            registro.put("nombre",nombre);
            registro.put("apellido",apellido);
            registro.put("telefono",telefonno);
            int cantidad =db.update("usuario",registro,"codigo="+codigo,null);
            db.close();

            if (cantidad==1){
                Toast.makeText(getContext(), "Modificado", Toast.LENGTH_SHORT).show();
            //    listener.listar();
            }
            else{
                Toast.makeText(getContext(), "No se modifico", Toast.LENGTH_SHORT).show();
            }
        consultarListaPersonas();
     /*   }
        else{
            Toast.makeText(getContext(), "llena los campos", Toast.LENGTH_SHORT).show();
        }*/
    }
    public void Eliminar(){
       // ConexionSQLiteHelper admin = new ConexionSQLiteHelper(getContext(),"bd_datos",null,1);
        //SQLiteDatabase db=conn.getWritableDatabase();
        SQLiteDatabase BaseDatabase = conn.getWritableDatabase();

        String codigo="fiorella";


            int cantidad=BaseDatabase.delete("usuario ","nombre="+codigo,null);
            BaseDatabase.close();


            if (cantidad==1){
                Toast.makeText(getContext(), "Eliminado", Toast.LENGTH_SHORT).show();

            }
            else{
                Toast.makeText(getContext(), "No se pudo Eliminar", Toast.LENGTH_SHORT).show();
            }




    }

    private void filter(String text) {
        //Nuevo elemento de tipo lista
/*        ArrayList<String> filterdNames = new ArrayList<>();

        //Ciclo que busca los elementos en la lista
        for (Object s : listaPersonaje) {
            //Si existe el elemento en la lista lo mostrara
            if (s.toString().contains(text.toLowerCase())) {
                //Añadir el elemento a la lista
                filterdNames.add(s.toString());
            }
        }

        // Llamar al metodo filtro de la lista
        adapter.filterList(filterdNames)*/
    }
    private CardView textCardView;
    private void implementSwipeDismiss() {
        SwipeDismissBehavior swipeDismissBehavior = new SwipeDismissBehavior();
        swipeDismissBehavior.setSwipeDirection(SwipeDismissBehavior.SWIPE_DIRECTION_ANY);//Swipe direction i.e any direction, here you can put any direction LEFT or RIGHT

        CoordinatorLayout.LayoutParams layoutParams =
                (CoordinatorLayout.LayoutParams) textCardView.getLayoutParams();

        layoutParams.setBehavior(swipeDismissBehavior);//set swipe behaviour to Coordinator layout
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof Activity){
            this.activity=(Activity) context;
            interfas=(Icomunica1) this.activity;

        }
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
