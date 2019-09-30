package com.example.tutor2.FragmentTutor;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tutor2.AdapterTutor.AdapterCursoTutor;
import com.example.tutor2.ClasesTutor.CursoTutor;
import com.example.tutor2.Conexion.ConexionSQLiteHelper;
import com.example.tutor2.R;
import com.example.tutor2.Util.Utilidades;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Cursos_Tutores_Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Cursos_Tutores_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Cursos_Tutores_Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;


    ArrayList<CursoTutor> listacursotutor;
    RecyclerView recyclerView;
    ConexionSQLiteHelper conn;
    AdapterCursoTutor adapterCursoTutor;


    private OnFragmentInteractionListener mListener;

    public Cursos_Tutores_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Cursos_Tutores_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Cursos_Tutores_Fragment newInstance(String param1, String param2) {
        Cursos_Tutores_Fragment fragment = new Cursos_Tutores_Fragment();
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
      View vista =inflater.inflate(R.layout.fragment_cursos__tutores_, container, false);
        conn=new ConexionSQLiteHelper(getContext(),"bd_datos",null,1);
        recyclerView =(RecyclerView)vista.findViewById(R.id.recyclercursostutores);

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        listacursotutor = new ArrayList<>();

       ListarCurssos();
        adapterCursoTutor  = new AdapterCursoTutor(listacursotutor);
        recyclerView.setAdapter(adapterCursoTutor);




        return vista;
    }

    private void ListarCurssos() {

        SQLiteDatabase db=conn.getReadableDatabase();
        CursoTutor even=null;


        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_TUTOR_CURSO,null);

        while (cursor.moveToNext()){
            even=new CursoTutor();
            even.setNombrecurso (cursor.getString(1));

            listacursotutor.add(even);
        }
        db.close();

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
