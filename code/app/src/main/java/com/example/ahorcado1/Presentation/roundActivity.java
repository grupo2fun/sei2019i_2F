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

        final String palabra = "actividad";

        TextView impresion = (TextView) findViewById(R.id.impresion);
        final char[] letras = palabra.toCharArray();
        for (int i=0; i<=letras.length;i++){
            letras [i]= '_' ;
        }
        String Poculta = String.valueOf(letras);
        impresion.setText(Poculta);

        final boolean[] mask = new boolean[palabra.length()];
        Arrays.fill(mask, Boolean.FALSE);

        EditText e1;
        e1=(EditText) findViewById(R.id.Tletra);
        final char ch = e1.getText().charAt(0);
        Button IngresrarLetra;
        IngresrarLetra=(Button) findViewById(R.id.BLetra);

        /*imprime la letra cuanto se pincha e boton*/
        IngresrarLetra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isTrue;
                for (int i=0; i<=mask.length;i++){
                    if(mask[i]=false){ isTrue=false;break;}
                    else isTrue=true;
                }
                while (isTrue=true){
                    gameController.guess(palabra,mask,ch);

                }
            }
        });
    }
}
