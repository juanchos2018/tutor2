package com.example.tutor2.Tutor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.tutor2.R;

public class TutorInico extends AppCompatActivity {

    TextView code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_inico);

        code=(TextView)findViewById(R.id.idcodigoincioturor);

      /*  Drawable originalDrawable = getResources().getDrawable(R.drawable.ico1_1);
        Bitmap oriBitmap =((BitmapDrawable)originalDrawable).getBitmap();

        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(),oriBitmap);

        roundedBitmapDrawable.setCornerRadius(oriBitmap.getHeight());
        ImageView imageView =(ImageView)findViewById(R.id.idimage);
        imageView.setImageDrawable(roundedBitmapDrawable);*/

    }

    public void onClick(View view) {

        switch (view.getId()){
            case R.id.idcar1:

              //  startActivity(new Intent(TutorInico.this,InicioTutor.class));
                Intent intent= new Intent(TutorInico.this,InicioTutor.class);
                Bundle bundle= new Bundle();
                bundle.putString("code4",code.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);


                break;
            case R.id.idcar2:
                Intent intent1 = new Intent(TutorInico.this, Horario.class);
                startActivity(intent1);

                break;

            case R.id.idcar3:
                Intent intent2 =new Intent(TutorInico.this,Perfil.class);
                startActivity(intent2);
        }
    }
}
