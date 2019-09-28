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
import android.widget.FrameLayout;

import com.example.tutor2.AdapterAlumno.TutoresAdapter;
import com.example.tutor2.ClasesAlumno.Tutores;
import com.example.tutor2.R;

import java.util.ArrayList;


public class TutoresFragments extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;

    ArrayList<Tutores> listatutores;
    RecyclerView recyclertutores;


    public TutoresFragments() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TutoresFragments.
     */
    // TODO: Rename and change types and number of parameters
    public static TutoresFragments newInstance(String param1, String param2) {
        TutoresFragments fragment = new TutoresFragments();
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
       View vista=inflater.inflate(R.layout.fragment_tutores_fragments, container, false);
       listatutores=new ArrayList<>();
       recyclertutores=(RecyclerView)vista.findViewById(R.id.recyclerId2);
       recyclertutores.setLayoutManager(new LinearLayoutManager(getContext()));
       llenarLista();
        TutoresAdapter adapter= new TutoresAdapter(listatutores);
        recyclertutores.setAdapter(adapter);

        return  vista;
    }

    private void llenarLista() {

        listatutores.add(new Tutores("2014049452","juan carlos panty",R.drawable.bart));
        listatutores.add(new Tutores("2014043452","jose espinoza",R.drawable.lisa));
        listatutores.add(new Tutores("2014042452","andres calamaro",R.drawable.homero));

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
