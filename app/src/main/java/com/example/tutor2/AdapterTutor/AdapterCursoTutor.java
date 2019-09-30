package com.example.tutor2.AdapterTutor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tutor2.ClasesTutor.CursoTutor;
import com.example.tutor2.R;

import java.util.ArrayList;

public class AdapterCursoTutor  extends RecyclerView.Adapter<AdapterCursoTutor.ViewHolderDatos> {


    ArrayList<CursoTutor> listacursotutor;

    public AdapterCursoTutor(ArrayList<CursoTutor> listacursotutor) {
        this.listacursotutor = listacursotutor;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_curso_tutor,null,false);

        return new ViewHolderDatos(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        if (holder instanceof ViewHolderDatos){
            final ViewHolderDatos dataholder=(ViewHolderDatos)holder;
            dataholder.curso.setText(listacursotutor.get(position).getNombrecurso());

        }


    }

    @Override
    public int getItemCount() {
        return listacursotutor.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView curso;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            curso=(TextView)itemView.findViewById(R.id.idnombrecurso1);

        }
    }
}
