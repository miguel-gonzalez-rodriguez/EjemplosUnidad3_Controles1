package com.example.ejemplosunidad3;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        // Objeto con la vista
        TextView textView = (TextView) findViewById(R.id.hola_mundo);
        
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
//        Typeface nuevaFuente = getResources().getFont(R.font.tsukimi_rounded);
//        textView.setTypeface(nuevaFuente);

        // Ejemplo animación de TextView
//        AnimationSet animationSet = new AnimationSet(true);
//        AlphaAnimation aparicion = new AlphaAnimation(0,1);
//        aparicion.setDuration(3000);
//        animationSet.addAnimation(aparicion);
//        textView.startAnimation(animationSet);


        Button bt_eventos = (Button) findViewById(R.id.button2);
        bt_eventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Eventos.class);
                startActivity(intent);
            }
        });

    }
}