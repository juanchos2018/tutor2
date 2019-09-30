package com.example.tutor2.FragmentAlumno;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tutor2.AdapterAlumno.SeccionesAdapter;
import com.example.tutor2.ClasesAlumno.Util;
import com.example.tutor2.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;


public class ContenedorFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;

    View vista;
    private AppBarLayout appBar;
    private TabLayout pestanas;
    private ViewPager viewPager;



    public ContenedorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContenedorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContenedorFragment newInstance(String param1, String param2) {
        ContenedorFragment fragment = new ContenedorFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      /*  if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        vista= inflater.inflate(R.layout.fragment_contenedor, container, false);

        if (Util.rotacion==0){
            View parent=(View)container.getParent();
            if (appBar==null){
                appBar=(AppBarLayout)parent.findViewById(R.id.appBar);
                pestanas= new TabLayout(getActivity());
                appBar.addView(pestanas);
                viewPager=vista.findViewById(R.id.idviewPagerInformation);
                llenarViewPager(viewPager);
                viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener()  {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                    }
                });
                pestanas.setupWithViewPager(viewPager);

            }
            pestanas.setTabGravity(TabLayout.GRAVITY_FILL);
        }
        else{
            Util.rotacion=1;
        }




        return vista;
    }
    private void llenarViewPager(ViewPager viewPager) {
        SeccionesAdapter adapter = new SeccionesAdapter(getFragmentManager());
        adapter.addFragment(new CursosFragments(),"Cursos");
        adapter.addFragment(new TutoresFragments(),"Tutoraes");
        adapter.addFragment(new InformacionFragment(),"Infoarmacion");

        viewPager.setAdapter(adapter);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (Util.rotacion==0){
            appBar.removeView(pestanas);
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
