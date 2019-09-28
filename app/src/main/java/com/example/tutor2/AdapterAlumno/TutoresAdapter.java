package com.example.tutor2.AdapterAlumno;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tutor2.ClasesAlumno.Tutores;
import com.example.tutor2.R;

import java.util.ArrayList;

public class TutoresAdapter extends RecyclerView.Adapter<TutoresAdapter.ViewHolderDatos> {


   ArrayList<Tutores>listatutores;

    public TutoresAdapter(ArrayList<Tutores> listatutores) {
        this.listatutores = listatutores;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tutoresa,null,false);
        return new ViewHolderDatos(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.nombre.setText(listatutores.get(position).getNombretutor());
        holder.codigo.setText(listatutores.get(position).getCodigotutor());
        holder.imgtutor.setImageResource(listatutores.get(position).getFoto());

    }

    @Override
    public int getItemCount() {
        return listatutores.size();
    }



    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView codigo,nombre;
        ImageView imgtutor;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            codigo=(TextView)itemView.findViewById(R.id.idcodigo1);
            nombre=(TextView)itemView.findViewById(R.id.idnombre1);
            imgtutor=(ImageView)itemView.findViewById(R.id.idfoto1);

        }
    }
}
