package com.example.tutor2.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tutor2.Adaptador.perosonajeadapter;
import com.example.tutor2.Alumno.Principal;
import com.example.tutor2.Clases.personaje;
import com.example.tutor2.Helper.MyButtonClickListener;
import com.example.tutor2.Helper.MySwipeHelper;
import com.example.tutor2.Interfaces.Icomunica1;
import com.example.tutor2.Login;
import com.example.tutor2.R;
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

    RecyclerView recycler;
       public static ArrayList<personaje> listaPersonaje;
    Icomunica1 interfas;
    ImageButton img;
        Button btn;
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
        listaPersonaje = new ArrayList<>();
        recycler = (RecyclerView) vista.findViewById(R.id.recyclerId1);
        recycler.setLayoutManager(new LinearLayoutManager(this.getContext()));
      //  btn=(Button)vista.findViewById(R.id.btbclick);
        //btn.setOnClickListener();
        //img.setOnClickListener();


        MySwipeHelper swipeHelper= new MySwipeHelper(getContext(),recycler,100) {
            @Override
            public void instantiateMyButton(RecyclerView.ViewHolder viewHolder, List<MySwipeHelper.MyButton> buffer) {
            buffer.add(new MyButton(getContext(),
                    "UpDate",
                    20,
                    R.drawable.ic_create_edit_24dp,
                    Color.parseColor("#FF9502"),
                    new MyButtonClickListener(){


                        @Override
                        public void onClick(int pos) {
                          //  startActivity(new Intent(activity, Principal.class));
                            Toast.makeText(getContext(), "hola udate", Toast.LENGTH_SHORT).show();

                        }
                    }));
            }
        };

        llenarLista();
        perosonajeadapter adapter  = new perosonajeadapter(listaPersonaje);
        recycler.setAdapter(adapter);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), listaPersonaje.get(recycler.getChildAdapterPosition(view)).getNombre(), Toast.LENGTH_SHORT).show();
          //  interfas.EnviarDetalle(listaPersonaje.get(recycler.getChildAdapterPosition(view)));

            }
        });

        return vista;
    }




    private void llenarLista() {
        listaPersonaje.add(new personaje("20130303","vago",R.drawable.bart));
        listaPersonaje.add(new personaje("20130302","Vago 2",R.drawable.lisa));
        listaPersonaje.add(new personaje("20130301","Vago 3",R.drawable.homero));


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
