package com.example.tutor2.Adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tutor2.Clases.Notificacion;
import com.example.tutor2.R;

import java.util.ArrayList;

public class NotificacionAdapter extends RecyclerView.Adapter<NotificacionAdapter.ViewHolderDatos>  implements View.OnClickListener{


    ArrayList<Notificacion> listanotificacion;

    public NotificacionAdapter(ArrayList<Notificacion> listanotificacion) {
        this.listanotificacion = listanotificacion;
    }

    private View.OnClickListener listener;

    public  void setOnClickListener(View.OnClickListener listener)
    {
        this.listener=listener;
    }
    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notificacion,null,false);
        view.setOnClickListener(this);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.nombrecruso.setText(listanotificacion.get(position).getNombrecurso());
        holder.nombreestrudiante.setText(listanotificacion.get(position).getNombreestudainte());
    }

    @Override
    public int getItemCount() {
        return listanotificacion.size();
    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }


    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView nombrecruso,nombreestrudiante;
        ImageView foto;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            nombrecruso=(TextView)itemView.findViewById(R.id.idcursonotificacion);
            nombreestrudiante=(TextView)itemView.findViewById(R.id.idtutornitificacion);


        }
    }
}
