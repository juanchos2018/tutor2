package com.example.tutor2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tutor2.Admin.PrincipalAdmin;
import com.example.tutor2.Alumno.Principal;
import com.example.tutor2.Tutor.TutorInico;

public class Login extends AppCompatActivity {
    Button btn2,btn3,btn4;
    TextView txttipousu;

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn2=(Button)findViewById(R.id.idbtnalumno);
        btn3=(Button)findViewById(R.id.idbtntutores);
        btn4=(Button)findViewById(R.id.idbtnadmin);
        txttipousu=(TextView)findViewById(R.id.txtiposusu);
        btn=(Button)findViewById(R.id.loginId);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txttipousu.getText().equals("Alumno")){
                  startActivity(new Intent(Login.this, Principal.class));
                    //finish();
                }
                if (txttipousu.getText().equals("Tutor")){
                  startActivity(new Intent(Login.this, TutorInico.class));
                    // finish();
                }
                if (txttipousu.getText().equals("Admin")){
                    //  startActivity(new Intent(Login.this, PrincipalAdmin.class));
                    startActivity(new Intent(Login.this, PrincipalAdmin.class));
                    // finish();

                }
            }
        });

    }
    public void cambiarEstado(View view) {

        switch (view.getId()){
            case R.id.idbtnalumno:

                btn2.setBackground(getDrawable(R.drawable.bordeboton3));

                btn3.setBackground(getDrawable(R.drawable.bordeboton2));
                btn4.setBackground(getDrawable(R.drawable.bordeboton2));
                txttipousu.setText("Alumno");

                break;
            case R.id.idbtntutores:
                btn3.setBackground(getDrawable(R.drawable.bordeboton3));

                btn2.setBackground(getDrawable(R.drawable.bordeboton2));
                btn4.setBackground(getDrawable(R.drawable.bordeboton2));
                txttipousu.setText("Tutor");
                break;

            case R.id.idbtnadmin:
                btn4.setBackground(getDrawable(R.drawable.bordeboton3));

                btn2.setBackground(getDrawable(R.drawable.bordeboton2));
                btn3.setBackground(getDrawable(R.drawable.bordeboton2));
                txttipousu.setText("Admin");
                break;


        }
    }
}
