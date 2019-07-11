package com.example.ahorcado1.Presentation;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ahorcado1.BusinessLogic.controllers.gameController;
import com.example.ahorcado1.R;

import java.util.Arrays;

public class roundActivity extends AppCompatActivity {

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);

        /*recibe la palabra*/
        final String palabra = "actividad";

        /*convierte la palabra en '_' y la imprime en el TextView*/
        final TextView impresion = (TextView) findViewById(R.id.impresion);
        final char[] letras = palabra.toCharArray();
        final char[] letra = palabra.toCharArray();
        for (int i=0; i<=letras.length;i++){
            letras [i]= '_' ;
        }
        String Poculta = String.valueOf(letras);
        impresion.setText(Poculta);

        final boolean[] mask = new boolean[palabra.length()];
        Arrays.fill(mask, Boolean.FALSE);

        /*ingresa la letra*/
        EditText e1;
        e1=(EditText) findViewById(R.id.Tletra);
        final char ch = e1.getText().charAt(0);
        Button IngresrarLetra;
        IngresrarLetra=(Button) findViewById(R.id.BLetra);

        /*imprime la letra cuanto se pincha el boton*/
        IngresrarLetra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isTrue;
                for (int i=0; i<=mask.length;i++){
                    if(mask[i]=false){ isTrue=false;break;}
                    else isTrue=true;
                }
                while (isTrue=true){
                    boolean[] s1=gameController.guess(palabra,mask,ch);
                    for (int i=0; i<=s1.length;i++){
                        if(s1[i]=true){
                            letras[i]=letra[i];
                        }
                    }
                    String Poculta = String.valueOf(letras);
                    impresion.setText(Poculta);
                }
            }
        });
    }
}
