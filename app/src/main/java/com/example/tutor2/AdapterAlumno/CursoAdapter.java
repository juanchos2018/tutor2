package com.example.tutor2.AdapterAlumno;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tutor2.ClasesAlumno.Cursos;
import com.example.tutor2.R;

import java.util.ArrayList;

public class CursoAdapter  extends RecyclerView.Adapter<CursoAdapter.ViewHolderDatos>  implements View.OnClickListener{


    ArrayList<Cursos> listaCursos;

    public CursoAdapter(ArrayList<Cursos> listaCursos) {
        this.listaCursos = listaCursos;
    }


    private View.OnClickListener listener;
    public  void setOnClickListener(View.OnClickListener listener)
    {
        this.listener=listener;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cursos,null,false);
        view.setOnClickListener(this);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {

        holder.foto.setImageResource(listaCursos.get(position).getFotocurso());
        holder.nombrecu.setText(listaCursos.get(position).getNomnrecurso());
    }

    @Override
    public int getItemCount() {
        return listaCursos.size();
    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView nombrecu,cantutores;
        ImageView foto;
        public ViewHolderDatos(@NonNull View itemView) {

            super(itemView);
            foto=(ImageView)itemView.findViewById(R.id.idfotocurso);
            nombrecu=(TextView)itemView.findViewById(R.id.idnombrecurso);
        }
    }
}
