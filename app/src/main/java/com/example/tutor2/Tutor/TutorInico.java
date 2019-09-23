package com.example.tutor2.Tutor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;

import com.example.tutor2.R;

public class TutorInico extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_inico);

        Drawable originalDrawable = getResources().getDrawable(R.drawable.ico1_1);
        Bitmap oriBitmap =((BitmapDrawable)originalDrawable).getBitmap();

        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(),oriBitmap);

        roundedBitmapDrawable.setCornerRadius(oriBitmap.getHeight());
        ImageView imageView =(ImageView)findViewById(R.id.idimage);
        imageView.setImageDrawable(roundedBitmapDrawable);

    }

    public void onClick(View view) {

        switch (view.getId()){
            case R.id.idcar1:

                startActivity(new Intent(TutorInico.this,Evento.class));
                break;

        }
    }
}
