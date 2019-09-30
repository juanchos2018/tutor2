package com.example.tutor2.AdapterTutor;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tutor2.ClasesTutor.Eventos;
import com.example.tutor2.R;

import java.util.ArrayList;

public class AdapterEventos extends RecyclerView.Adapter<AdapterEventos.ViewHolderDatos>   implements View.OnClickListener {

    ArrayList<Eventos> listaeventos;

    //final private ListItemClickListener mOnClickListener;
    private ListItemClickListener listener2;

    public AdapterEventos(ArrayList<Eventos> listaeventos) {
        this.listaeventos = listaeventos;
    }


    public interface ListItemClickListener{
      void onListItemClick();

    }

    private View.OnClickListener listener;

    public  void setOnClickListener(View.OnClickListener listener)
    {
        this.listener=listener;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_eventostutor,null,false);
        vista.setOnClickListener(this);
        return new ViewHolderDatos(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {

        if (holder instanceof  ViewHolderDatos){
            final ViewHolderDatos dataholder =(ViewHolderDatos)holder;
            dataholder.titulo.setText(listaeventos.get(position).getTituloevento());
            dataholder.curso.setText(listaeventos.get(position).getCurso());
            dataholder.fecha.setText(listaeventos.get(position).getFechaevento());
           dataholder.img.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                //   listener.onClick(view);
             //   listener2.onListItemClick();

               /*    AlertDialog.Builder dialog= new AlertDialog.Builder(dataholder.img.getContext());


                   dialog.setTitle("Recordatodio");

                   dialog.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogo1, int id) {

                        }
                    });
                   dialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                       public void onClick(DialogInterface dialogo1, int id) {

                       }
                   });
                   dialog.show();*/
               }
           });
        }


    }

    @Override
    public int getItemCount() {
        return listaeventos.size();
    }


    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView titulo,curso,fecha;
        String lugar,descripcion,estado;
        ImageView img;
        Button btnoti;


        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            titulo=(TextView)itemView.findViewById(R.id.idtitutloevento);
            curso=(TextView)itemView.findViewById(R.id.idcursoevento);
            fecha=(TextView)itemView.findViewById(R.id.idfechaevento);
            img=(ImageView)itemView.findViewById(R.id.idnoti);



        }
    }
}
