package com.example.tutor2;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.ArrayList;

public class EjecutaDialog   extends AppCompatDialogFragment {

    ArrayAdapter<String> adaperspinner;
    ArrayAdapter<String> adaperspinner2;

    private Spinner spinnerciclo;
    private Spinner spinnercursos;
    private ExampleDialogListener listener;

    //   private static final String[] cursos = new String []{"Programacion 1","Programacion 2","Programacion 3","Soluciones Moviles"};
    private static final String[] ciclos = new String []{"1er Ciclo","2do Ciclo","3er Ciclo","4 Ciclo"};


    public static ArrayList<String> telefonos;
    public static ArrayAdapter<String> adapter;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // adaperspinner= new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item,cursos);
        // spinnercursos.setAdapter(adaperspinner);

        telefonos=new ArrayList<String>();
        telefonos.add("Programacion 1");
        telefonos.add("Programacion 2");
        telefonos.add("Programacion 3");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        adaperspinner2= new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item,ciclos);
        adaperspinner= new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item,telefonos);
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog2, null);

        builder.setView(view)
                .setTitle("Agregar Curso")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String ciclo = spinnerciclo.getSelectedItem().toString();
                        String curso = spinnercursos.getSelectedItem().toString();
                        listener.applyTexts(ciclo, curso);
                    }
                });




        spinnerciclo=view.findViewById(R.id.idcicloo1);
        spinnercursos=view.findViewById(R.id.idcursos1);

        spinnerciclo.setAdapter(adaperspinner2);
        spinnercursos.setAdapter(adaperspinner);

        return builder.create();
    }

    public interface ExampleDialogListener {
        void applyTexts(String ciclo, String curso);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (ExampleDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement ExampleDialogListener");
        }
    }
}
