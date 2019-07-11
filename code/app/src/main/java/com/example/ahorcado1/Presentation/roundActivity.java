package com.example.ahorcado1.Presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ahorcado1.BusinessLogic.controllers.gameController;
import com.example.ahorcado1.R;

import java.util.Arrays;

public class roundActivity extends AppCompatActivity {

    //@SuppressLint("WrongViewCast")
    //@Override
    TextView impresion;
    EditText e1;
    Button IngresrarLetra;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);

        /*recibe la palabra*/
        final String palabra = "actividad";

        /*convierte la palabra en '_' y la imprime en el TextView*/
        impresion = (TextView) findViewById(R.id.impresionText);
        final char[] letras = palabra.toCharArray();
        final char[] letra = palabra.toCharArray();
        //Convierte letras[] en _
        for (int i = 0; i < letras.length; i++)
        {
            letras[i]= '_';
        }

        //Imprime los caracteres _ en impresión (textView)
        String Poculta = String.valueOf(letras);
        impresion.setText(Poculta);

        //Crea la máscara con el tamaño de la palabra
        final boolean[] mask = new boolean[palabra.length()];
        Arrays.fill(mask, Boolean.FALSE);

        /*ingresa la letra*/

        e1 = (EditText) findViewById(R.id.ingresarField);
        //Toma el primer caracter del string


        //Botón
        IngresrarLetra = (Button) findViewById(R.id.BLetra);

        /*imprime la letra cuanto se pincha el boton*/
        IngresrarLetra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String caracterStr = e1.getText().toString();
                final char[] chArray = caracterStr.toCharArray();
                final char ch = chArray[0];
                boolean isTrue = false;

                for (int i = 0; i < mask.length; i++)
                {
                    if(mask[i]==false){ isTrue = false; break;}
                    else isTrue = true;
                }
                while (isTrue == true)
                {
                    boolean[] s1 = gameController.guess(palabra, mask, ch);
                    //Recorre el  arreglo de booleanos
                    for (int i = 0; i < s1.length; i++)
                    {
                        if(s1[i] == true)
                        {
                            //Actualiza letras que está originalmente en '_' con la letra adivinada
                            letras[i] = letra[i];
                        }
                    }
                    String Poculta = String.valueOf(letras);
                    Toast.makeText(getApplicationContext(),"PALABRA: " + Poculta,Toast.LENGTH_SHORT).show();
                    impresion.setText(Poculta);
                }
            }
        });
    }
}
