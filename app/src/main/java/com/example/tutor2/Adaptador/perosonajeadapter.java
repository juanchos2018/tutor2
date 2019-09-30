package com.example.tutor2.Adaptador;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentController;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tutor2.Admin.AgregarAlumno;
import com.example.tutor2.Admin.AgregarCurso;
import com.example.tutor2.Admin.VerCursos;
import com.example.tutor2.Alumno.Principal;
import com.example.tutor2.Clases.personaje;
import com.example.tutor2.EjecutaDialog;
import com.example.tutor2.Login;
import com.example.tutor2.R;

import java.util.ArrayList;

public class perosonajeadapter extends RecyclerView.Adapter<perosonajeadapter.ViewHolderDatos> implements View.OnClickListener {


    ArrayList<personaje> listaPersonaje;

    private Spinner spinnerciclo;
    private Spinner spinnercursos;
    ArrayAdapter<String> adaperspinner;
    ArrayAdapter<String> adaperspinner2;
    //private ExampleDialogListener listener;

     ArrayList<String> Cursos;
     ArrayAdapter<String> adapter;

    private View.OnClickListener listener;

    public perosonajeadapter(ArrayList<personaje> listaPersonaje) {
        this.listaPersonaje = listaPersonaje;
    }

    public  void setOnClickListener(View.OnClickListener listener)
    {
        this.listener=listener;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemtutores,null,false);
        vista.setOnClickListener(this);
        return new ViewHolderDatos(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderDatos holder, final int position) {
      /*  holder.codigo.setText(listaPersonaje.get(position).getCodigo());
        holder.nombre.setText(listaPersonaje.get(position).getNombre());
        holder.ape.setText(listaPersonaje.get(position).getApellido());*/

        if (holder instanceof ViewHolderDatos){
            //  final Dato dato=
            final ViewHolderDatos datgolder =(ViewHolderDatos)holder;
            datgolder.codigo.setText(listaPersonaje.get(position).getCodigo());
            datgolder.nombre.setText(listaPersonaje.get(position).getNombre());

            datgolder.apellidos=listaPersonaje.get(position).getApellido();
            datgolder.telefonos=listaPersonaje.get(position).getTelefono();

            // datgolder.foto.setImageResource(listaPersonaje.get(position).getFoto());

            datgolder.btnprueba.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //   Toast.makeText(null, "hola", Toast.LENGTH_SHORT).show();
                    //   Intent intent= new Intent(datgolder.btnprueba.getContext(), Login.class);
                    // datgolder.btnprueba.getContext().startActivity(intent);


                    final  Button b1 = new Button(datgolder.btnprueba.getContext());
                    b1.setText("boton1");
                    final  Button b2 = new Button(datgolder.btnprueba.getContext());
                    b2.setText("boton 2");

                    final CharSequence[] items = new CharSequence[3];
                    AlertDialog.Builder dialog= new AlertDialog.Builder(datgolder.btnprueba.getContext());


                    dialog.setCancelable(false);
                    items[0] = "Asignar Curso";
                    items[1] = "Asignar Alumnos";
                    items[2] = "Ver Cursos";
                    //dialog.setItems(items);
                    dialog.setTitle("Acciones").setItems(items, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            //   Toast.makeText( datgolder.btnprueba.getContext(),"Seleccionaste:" + items[which],Toast.LENGTH_SHORT)
                            //         .show();
                            if (which==0){
                                Intent intent= new Intent(datgolder.btnprueba.getContext(), AgregarCurso.class);
                                //  intent.putExtra("codigo",datgolder.codigo.getText());
                                //intent.putExtra("name",datgolder.nombre.getText());
                                //intent.putExtra("foto",datgolder.fo);
                                int img;
                                ImageView g;


                                Bundle bundle = new Bundle();
                                img=listaPersonaje.get(position).getFoto();
                                bundle.putString("code",datgolder.codigo.getText().toString());
                                bundle.putString("name",datgolder.nombre.getText().toString());
                                bundle.putInt("foto",img);
                                intent.putExtras(bundle);
                                datgolder.btnprueba.getContext().startActivity(intent);
                                //  datgolder.btnprueba.getContext().startActivity(intent);
                            }
                            if (which==1){
                                Intent intent= new Intent(datgolder.btnprueba.getContext(), AgregarAlumno.class);
                                datgolder.btnprueba.getContext().startActivity(intent);
                            }
                            if (which==2){
                                Intent intent= new Intent(datgolder.btnprueba.getContext(), VerCursos.class);
                                Bundle bundle=  new Bundle();
                                bundle.putString("name2",datgolder.nombre.getText().toString());
                                bundle.putString("ape2",datgolder.apellidos);
                                intent.putExtras(bundle);

                                datgolder.btnprueba.getContext().startActivity(intent);
                            }

                        }
                    });
                   /* dialog.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogo1, int id) {

                        }
                    });*/
                    dialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogo1, int id) {

                        }
                    });
                    dialog.show();
                }
            });

        }

    }


    @Override
    public int getItemCount() {
        return listaPersonaje.size();
    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }
    public class ViewHolderDatos extends RecyclerView.ViewHolder {
                TextView codigo,nombre,ape,telefono;
                ImageView foto;
                Button btnprueba;
        String telefonos,apellidos,codigos;
            public ViewHolderDatos(@NonNull View itemView) {
                super(itemView);

                codigo=(TextView)itemView.findViewById(R.id.idcodigo);
                nombre=(TextView)itemView.findViewById(R.id.idnombre);
                btnprueba=(Button)itemView.findViewById(R.id.btbclick);
                //   ape=(TextView)itemView.findViewById(R.id.idappp);


                //  telefono=(TextView)itemView.findViewById(R.id.idtelefono);
                //      foto=(ImageView)itemView.findViewById(R.id.idfoto);


            }
        }
    public void filterList(ArrayList<personaje> filterdNames) {
  /*      TextView codigo,nombre;
        nombre=(TextView)filterdNames.findViewById(R.id.idnombre);
        no = filterdNames;
        notifyDataSetChanged();*/
    }
}
