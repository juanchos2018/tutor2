package com.example.tutor2.Adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tutor2.Clases.VerCurso;
import com.example.tutor2.Clases.cursotutor;
import com.example.tutor2.R;

import java.util.ArrayList;

public class VerCursosAdapter extends RecyclerView.Adapter<VerCursosAdapter.ViewHolderDatos> {


    ArrayList<cursotutor> listaCurso;

    public VerCursosAdapter(ArrayList<cursotutor> listaCurso) {
        this.listaCurso = listaCurso;
    }

    @NonNull
    @Override
    public VerCursosAdapter.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cursos2,null,false);

        return new ViewHolderDatos(vista);

    }

    @Override
    public void onBindViewHolder(@NonNull VerCursosAdapter.ViewHolderDatos holder, int position) {

       // holder.img.setImageResource(listaCurso.get(position).getCurso());
        holder.curso.setText(listaCurso.get(position).getCurso());

    }

    @Override
    public int getItemCount() {
        return listaCurso.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        ImageView img;
        TextView curso;
        String nombrecurso;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
           // img=(ImageView)itemView.findViewById(R.id.idimg);

            curso=(TextView)itemView.findViewById(R.id.idcur);

        }
    }
}
