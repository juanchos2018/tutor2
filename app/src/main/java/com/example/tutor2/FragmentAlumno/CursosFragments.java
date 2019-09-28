package com.example.tutor2.FragmentAlumno;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tutor2.AdapterAlumno.CursoAdapter;
import com.example.tutor2.ClasesAlumno.Cursos;
import com.example.tutor2.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CursosFragments.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CursosFragments#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CursosFragments extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



        RecyclerView recyclerCursos;
    ArrayList<Cursos> listaCursos;

    private OnFragmentInteractionListener mListener;

    public CursosFragments() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CursosFragments.
     */
    // TODO: Rename and change types and number of parameters
    public static CursosFragments newInstance(String param1, String param2) {
        CursosFragments fragment = new CursosFragments();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View vista =inflater.inflate(R.layout.fragment_cursos_fragments, container, false);
        listaCursos= new ArrayList<>();
        recyclerCursos=(RecyclerView)vista.findViewById(R.id.recyclerId3);
        recyclerCursos.setLayoutManager(new LinearLayoutManager(getContext()));
        llenarLista();
        CursoAdapter adapter = new CursoAdapter(listaCursos);
        recyclerCursos.setAdapter(adapter);
        return  vista;
    }
    private void llenarLista() {

        listaCursos.add(new Cursos("CU-123","programacion 1",R.drawable.matematica));
        listaCursos.add(new Cursos("CU-124","programacion 2",R.drawable.matematica));
        listaCursos.add(new Cursos("CU-125","programacion 3",R.drawable.matematica));

        //listaCursos.add(new Cursos(R.drawable.programacion_1,"Programacion",1));


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
