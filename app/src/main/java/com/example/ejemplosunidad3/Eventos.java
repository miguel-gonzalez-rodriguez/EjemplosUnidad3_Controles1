package com.example.ejemplosunidad3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Eventos extends AppCompatActivity {

    ToggleButton toggleButton;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_eventos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_eventos), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imageView = (ImageView) findViewById(R.id.laImagen);
        imageView.setVisibility(View.VISIBLE);


        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                System.out.println("botón cambiado");
                if (isChecked){
                    System.out.println("ACTIVADO");
                    buttonView.setTextColor(Color.RED);
                    imageView.setVisibility(View.VISIBLE);
                }
                else {
                    System.out.println("DESACTIVADO");
                    buttonView.setTextColor(Color.GRAY);
                    imageView.setVisibility(View.INVISIBLE);



                }

            }
        });
    }
}