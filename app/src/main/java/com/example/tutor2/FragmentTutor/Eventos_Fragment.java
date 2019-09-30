package com.example.tutor2.FragmentTutor;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tutor2.Adaptador.VerCursosAdapter;
import com.example.tutor2.AdapterTutor.AdapterEventos;
import com.example.tutor2.Clases.cursotutor;
import com.example.tutor2.ClasesTutor.Eventos;
import com.example.tutor2.Conexion.ConexionSQLiteHelper;
import com.example.tutor2.R;
import com.example.tutor2.Tutor.Evento;
import com.example.tutor2.Util.Utilidades;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Eventos_Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Eventos_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Eventos_Fragment extends Fragment  implements AdapterEventos.ListItemClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;


    Button btnmostrardialogo,btneliminartodo;
    EditText ecodigo,etitulo,ecurso,elugar,efecha,edescripcion;
    TextView codetutor;
    Spinner spinercurso;
    ConexionSQLiteHelper conn;
    TextView codigodeotrolado;

    ArrayList<Eventos> listaEventos;
    RecyclerView recyclerView;
    AdapterEventos adapterEventos;

    public final Calendar c = Calendar.getInstance();
    final int mes = c.get(Calendar.MONTH);
    final int dia = c.get(Calendar.DAY_OF_MONTH);
    final int anio = c.get(Calendar.YEAR);
    private static final String CERO = "0";
    private static final String BARRA = "/";

    public String ponerfecha;

    ArrayList<cursotutor> listavercursos;
    ArrayList<String> cursolista;
    ArrayAdapter<CharSequence> adaptador;


    public Eventos_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Eventos_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Eventos_Fragment newInstance(String param1, String param2) {
        Eventos_Fragment fragment = new Eventos_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_eventos_, container, false);
        conn=new ConexionSQLiteHelper(getContext(),"bd_datos",null,1);

        String texto = getArguments().getString("code41");
        codigodeotrolado=(TextView)vista.findViewById(R.id.codiomostrar);
        codigodeotrolado.setText(texto);
        btnmostrardialogo=(Button)vista.findViewById(R.id.idagregaevento);
        btneliminartodo=(Button)vista.findViewById(R.id.ideliminartodo);

        recyclerView=(RecyclerView)vista.findViewById(R.id.recyclereventos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        listaEventos = new ArrayList<>();

        listavercursos= new ArrayList<>();



        Listar();
        adapterEventos = new AdapterEventos(listaEventos);
        recyclerView.setAdapter(adapterEventos);

        btnmostrardialogo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

               // adaptador   =new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,cursolista);
              //      spinercurso.setAdapter(adaptador);
                LayoutInflater inflater = getActivity().getLayoutInflater();
                View view2 = inflater.inflate(R.layout.dialogo_agregar_evento, null);
                builder.setView(view2)
                        .setTitle("Registro")
                        .setPositiveButton("REGISTRAR", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getContext(), "hola", Toast.LENGTH_SHORT).show();
                               Eventos o = new Eventos();
                                o.setCodigotutor(codigodeotrolado.getText().toString());
                                o.setTituloevento(etitulo.getText().toString());
                                o.setCurso("pro1");
                                o.setLugarevento(elugar.getText().toString());
                                o.setFechaevento(efecha.getText().toString());
                                o.setDescripcion(edescripcion.getText().toString());
                                o.setHoraevento("0");
                                o.setEstado("En Progreso");
                                Registrar(o);
                            }
                        });

                builder.show();
                etitulo=(EditText)view2.findViewById(R.id.idtutulo);
                spinercurso=(Spinner)view2.findViewById(R.id.idcurso2);
                elugar=(EditText)view2.findViewById(R.id.idlugar);
                efecha=(EditText)view2.findViewById(R.id.idfecha);
                edescripcion=(EditText)view2.findViewById(R.id.iddescripcion);




                efecha.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        obtenerFecha();
                    }
                });

            }
        });
       // adapterEventos.onBindViewHolder();

        adapterEventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                LayoutInflater inflater = getActivity().getLayoutInflater();
                View view2 = inflater.inflate(R.layout.dioalogo_modificar_evento, null);
                builder.setView(view2)
                        .setTitle("Actualizar")
                        .setNegativeButton("Eliminar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setPositiveButton("Actualizar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //    Toast.makeText(getContext(), "hola", Toast.LENGTH_SHORT).show();
                             /*   personaje o = new personaje();
                                o.setCodigo(ee1.getText().toString());
                                o.setNombre(ee2.getText().toString());
                                o.setApellido(ee3.getText().toString());
                                o.setTelefono(ee4.getText().toString());
                                //           Modificar(o);
                                Modificar();*/
                                //    Toast.makeText(getContext(), "hola"+ ee1.getText().toString(), Toast.LENGTH_SHORT).show();

                            }
                        });


                builder.show();
          /*      ee1=(EditText)view2.findViewById(R.id.agrega1); // codigo
                ee2=(EditText)view2.findViewById(R.id.idnom1);
                ee3=(EditText)view2.findViewById(R.id.idape1);
                ee4=(EditText)view2.findViewById(R.id.idtelefono1);
                eciclo=(EditText)view2.findViewById(R.id.idcicloo1);
                //   spinerciclo1=(Spinner)view2.findViewById(R.id.spinerciclo1);

                ee1.setText(listaPersonaje.get(recycler.getChildAdapterPosition(view)).getCodigo());
                ee2.setText(listaPersonaje.get(recycler.getChildAdapterPosition(view)).getNombre());
                ee3.setText(listaPersonaje.get(recycler.getChildAdapterPosition(view)).getApellido());
                ee4.setText(listaPersonaje.get(recycler.getChildAdapterPosition(view)).getTelefono());
                eciclo.setText(listaPersonaje.get(recycler.getChildAdapterPosition(view)).getCiclo());*/
            }
        });
        return vista;

    }


    private void obtenerFecha(){
        DatePickerDialog recogerFecha = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                final int mesActual = month + 1;
                String diaFormateado = (dayOfMonth < 10)? CERO + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                String mesFormateado = (mesActual < 10)? CERO + String.valueOf(mesActual):String.valueOf(mesActual);
                efecha.setText(diaFormateado + BARRA + mesFormateado + BARRA + year);
            }

        },anio, mes, dia);

        recogerFecha.show();
    }


    private void Registrar(Eventos datos) {
        listaEventos.clear();
        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_CODIGO_TUTORE,datos.getCodigotutor());
        values.put(Utilidades.CAMPO_TITULO_EVENTO,datos.getTituloevento());
        values.put(Utilidades.CAMPO_CURSO_EVENTO,datos.getCurso());
        values.put(Utilidades.CAMPO_LUGAR_EVENTO,datos.getLugarevento());
        values.put(Utilidades.CAMPO_FECHA_EVENTO,datos.getFechaevento());
        values.put(Utilidades.CAMPO_DESCRIPCION_EVENTO,datos.getDescripcion());
        values.put(Utilidades.CAMPO_HORA_EVENTO,datos.getHoraevento());
        values.put(Utilidades.CAMPO_ESTADO_EVENO,datos.getEstado());
        //Long idResultante=db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID,values);
        db.insert(Utilidades.TABLA_EVENTO_TUTOR,null,values);

        Toast.makeText(getContext(),"Registrado: ",Toast.LENGTH_SHORT).show();
        db.close();
      Listar();

    }

    public void Listar() {
        SQLiteDatabase db=conn.getReadableDatabase();
       Eventos even=null;


        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_EVENTO_TUTOR,null);

        while (cursor.moveToNext()){
            even=new Eventos();
            even.setTituloevento(cursor.getString(2));
            even.setCurso(cursor.getString(3));
            even.setFechaevento(cursor.getString(5));
            listaEventos.add(even);
        }
        db.close();

    }

    public void llenarCombo() {

        SQLiteDatabase db=conn.getReadableDatabase();

        cursotutor cursutu=null;

      //  listavercursos = new ArrayList<cursotutor>();

        Cursor cursor=db.rawQuery("SELECT * FROM cursotutor ",null);

        while (cursor.moveToNext()){
            cursutu=new cursotutor();
            cursutu.setCurso(cursor.getString(1));

            listavercursos.add(cursutu);
        }
        db.close();
     //   obtenerLista();

    }

    public void obtenerLista() {
        cursolista=new ArrayList<String>();
        cursolista.add("Seleccione");

        for(int i=0;i<listavercursos.size();i++){
            cursolista.add(listavercursos.get(i).getCurso());
        }

    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
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

    @Override
    public void onListItemClick() {
        Toast.makeText(getContext(), "hola", Toast.LENGTH_SHORT).show();
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
