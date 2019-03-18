package com.example.practicacalificadafanny;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn =(Button)findViewById(R.id.imprimir);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Resultado.class);
                EditText editText =(EditText)findViewById(R.id.palabra);

                String dato = editText.getText().toString();
                //contar letras
                int cantidad = editText.length();

// contar palabras
                String temp[] = dato.split(" ");
                int otro = temp.length;



// contar palabras repetitivas


                String palabras [] = dato.split(" ");
                String palabrasB [] = dato.split(" ");
                 int total= palabras.length;
                 String resultado = "";
                for (int i=0; i<total;i++)
                {
                    int contador =0;
                    resultado += palabras[i];
                    String palabra = palabras[i];
                    for (int j=0; j<total;j++)
                    {
                        if(palabra.equalsIgnoreCase(palabrasB[j]))
                        {
                            contador++;
                            palabras[j] = "";
                        }



                    }
                    if (contador>0){
                        resultado += " "+contador+"\n";
                    }

                }

                intent.putExtra("item", resultado);






// Palabras palindronas

                String palindrona [] = dato.split(" ");
                String ResultadoPalin = "";
                String ResultadoTotal = "";
                int Count = 0;
                for (int i=0; i<palindrona.length;i++)
                    {
                        int caso =0;
                        String cadena1 = palindrona[i];
                        int tamaño = palindrona[i].length();
                        for(int y=0; y<tamaño/2;y++)
                        {
                            if(cadena1.charAt(y) != cadena1.charAt(tamaño-1-y))
                            {
                                caso++;
                            }
                        }
                        if(caso==0)
                        {
                            Count++;
                            ResultadoPalin += palindrona[i]+"\n";;

                        }
                    }
                ResultadoTotal = "Cantidad de palindronas:" +   Count+ "\n" +"palabras:" + ResultadoPalin;
                intent.putExtra("item1", Count);
                intent.putExtra("item2", ResultadoTotal);



                intent.putExtra("dato", dato);
//mostrar letras
                intent.putExtra("cantidad", Integer.toString(cantidad));
//enviar palabras
                intent.putExtra("otro", Integer.toString(otro));

                startActivity(intent);
            }
        });

    }

}
