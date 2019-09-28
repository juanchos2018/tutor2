package com.example.tutor2.Adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tutor2.Clases.claseagregar;
import com.example.tutor2.R;

import java.util.ArrayList;

public class adapteragregar extends RecyclerView.Adapter<adapteragregar.ViewHolderDatos> {
    ArrayList<claseagregar> listadetalleveo;

    public adapteragregar(ArrayList<claseagregar> listadetalleveo) {
        this.listadetalleveo = listadetalleveo;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_agregar,null,false);

        return new ViewHolderDatos(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {

        holder.nombre.setText(listadetalleveo.get(position).getNombre());


    }

    @Override
    public int getItemCount() {
        return listadetalleveo.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView nombre;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            nombre=(TextView)itemView.findViewById(R.id.idagregar);

        }
    }
}
