package com.example.practicacalificadafanny;

import android.os.CancellationSignal;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {


    static TextView Receptor;
    static TextView Cantidad;
    static TextView Otro;
    static TextView Item;
    static TextView Canpalindrona;
    static TextView Palindroma;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

// en este texto se recibe el dato
        Receptor = (TextView) findViewById(R.id.receptor);
        Cantidad = (TextView) findViewById(R.id.cantidad);
        Otro = (TextView)findViewById(R.id.otro);
        Item = (TextView)findViewById(R.id.item);
        Palindroma = (TextView)findViewById(R.id.item2);


        // recepcion de datos
        Bundle parametros = this.getIntent().getExtras();
        if(parametros != null)
            {
                String dato = parametros.getString("dato");
                Receptor.setText(dato);

                String cantidad = "Cantidad de letras:"+ " "+parametros.getString("cantidad");
                Cantidad.setText(cantidad);

                String otro = "Cantidad de palabras:"+ " "+parametros.getString("otro");
                Otro.setText(otro);

                String item = "LETRAS:"+ " "+parametros.getString("item");
                Item.setText(item);





                String palind = parametros.getString("item2");
                Palindroma.setText(palind);


            }
    }
}
