package com.example.tutor2.Fragments;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.tutor2.Adaptador.NotificacionAdapter;
import com.example.tutor2.Clases.Notificacion;
import com.example.tutor2.Helper.MyButtonClickListener;
import com.example.tutor2.Helper.MySwipeHelper;
import com.example.tutor2.Interfaces.Icomunica2;
import com.example.tutor2.R;

import java.util.ArrayList;
import java.util.List;


public class NotificacionFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    Activity activity;
    RecyclerView recycler;
   Icomunica2 icomunica2;

    public static ArrayList<Notificacion> listaNotificacion;
    private OnFragmentInteractionListener mListener;

    public NotificacionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NotificacionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NotificacionFragment newInstance(String param1, String param2) {
        NotificacionFragment fragment = new NotificacionFragment();
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
   View vista=inflater.inflate(R.layout.fragment_notificacion, container, false);

        listaNotificacion = new ArrayList<>();
        recycler = (RecyclerView) vista.findViewById(R.id.recyclerId6);
        recycler.setLayoutManager(new LinearLayoutManager(this.getContext()));



        LlenarLista();
        NotificacionAdapter adapter  = new NotificacionAdapter(listaNotificacion);
        recycler.setAdapter(adapter);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "hola", Toast.LENGTH_SHORT).show();
                icomunica2.EnviarDetalle(listaNotificacion.get(recycler.getChildAdapterPosition(view)));

            }
        });

        return  vista;
    }

    private void LlenarLista() {
      //  holder.codigocurso.setText(listanotificacion.get(position).getNombrecurso());
       // holder.nombreestrudiante.setText(listanotificacion.get(position).getNombreestudainte());
        listaNotificacion.add(new Notificacion("programacion","Pepito"));
        listaNotificacion.add(new Notificacion("Soluciones Moviels","Vago 2"));


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
            icomunica2=(Icomunica2)this.activity;

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
