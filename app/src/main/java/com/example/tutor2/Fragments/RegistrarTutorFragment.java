package com.example.tutor2.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tutor2.Clases.personaje;
import com.example.tutor2.R;

import java.util.ArrayList;


public class RegistrarTutorFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
EditText etcodigo;
EditText etnombre;
Button btagregar;

    private Spinner spinnerciclo;
    ArrayAdapter<String> adapterciclo;
    public static ArrayList<String> Ciclo;
    private OnFragmentInteractionListener mListener;

    public RegistrarTutorFragment() {

    }


    // TODO: Rename and change types and number of parameters
    public static RegistrarTutorFragment newInstance(String param1, String param2) {
        RegistrarTutorFragment fragment = new RegistrarTutorFragment();
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
    //public static ArrayList<personaje> listaPersonaje;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista =inflater.inflate(R.layout.fragment_registrar_tutor, container, false);

        Ciclo=new ArrayList<String>();
        Ciclo.add("1 Ciclo");
        Ciclo.add("2 Ciclo");
        Ciclo.add("3 Ciclo");
        spinnerciclo=vista.findViewById(R.id.idcursoss);
        adapterciclo= new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item,Ciclo);
        spinnerciclo.setAdapter(adapterciclo);

        etcodigo=(EditText)vista.findViewById(R.id.idcodigoestudiante);
        etnombre=(EditText)vista.findViewById(R.id.idnombreestudiante);
        btagregar=(Button)vista.findViewById(R.id.idbtnagregar);
        btagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    ListaTutorFragment f = new ListaTutorFragment();
                    personaje o = new personaje();
                    o.setCodigo(etcodigo.getText().toString());
                    o.setNombre(etnombre.getText().toString());
                    f.listaPersonaje.add(o);
                Toast.makeText(getContext(), "Registrado", Toast.LENGTH_SHORT).show();

            }
        });

        return vista;
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
