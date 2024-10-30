package com.example.ejemplosunidad3;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity //implements View.OnClickListener
{
    private class ReceptorBoton implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            System.out.println("implementado con clase interna");
        }
    }

//    @Override
//    public void onClick(View view) {
//        System.out.println("dsfadsfdsfadsfdsaffads");
//        if (view.getId() == findViewById(R.id.button2)){
//
//        }
//    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_eventos), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button button = findViewById(R.id.button2);


        // la misma clase
        //button.setOnClickListener(this);
        ReceptorBoton listener = new ReceptorBoton();

        button.setOnClickListener(listener);

        Button bt = findViewById(R.id.buttonRadio);
        bt.setOnClickListener(listener);


        button.setOnClickListener(view -> {
            System.out.println("clase anónima");
        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("clase anónima otra diferente");
            }
        });




        // Objeto con la vista
        TextView textView = findViewById(R.id.hola_mundo);
        
        // El objeto StringBuilder facilita el uso de cadenas
        // Para añadirle etiquetas de estilo a la cadena, podemos usar las clases Span
        SpannableStringBuilder cadena = new SpannableStringBuilder("nuevo texto");
        cadena.append(" más texto");
        
        // Se añaden las etiquetas a la cadena
        cadena.setSpan(new UnderlineSpan(),0,cadena.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        //Otros tipos de Span:
        // ForegroundColorSpan(Color.RED)
        // StyleSpan(Typeface.BOLD)
        //
        
        // Establece el texto a la vista
        textView.setText(cadena);


        // Establecer un nuevo tipo de Fuente
        Typeface nuevaFuente = getResources().getFont(R.font.tsukimi_rounded);
//        Typeface otrra = getResources().getFont(R.font.otra);
        textView.setTypeface(nuevaFuente);

        // Ejemplo animación de TextView
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation aparicion = new AlphaAnimation(0,1);
        aparicion.setDuration(3000);
        animationSet.addAnimation(aparicion);

        textView.startAnimation(animationSet);

//
//        Button bt_eventos = findViewById(R.id.button2);
//        bt_eventos.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,Eventos.class);
//                startActivity(intent);
//            }
//        });

    }


}