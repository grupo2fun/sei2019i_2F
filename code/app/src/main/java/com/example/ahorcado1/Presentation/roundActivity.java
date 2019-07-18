package com.example.ahorcado1.Presentation;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ahorcado1.BusinessLogic.controllers.gameController;
import com.example.ahorcado1.R;

import java.util.Arrays;
import java.util.Stack;

public class roundActivity extends AppCompatActivity {
    int lives ;
    int hints ;
    ImageButton bGuess ;
    ImageButton bHint;
    TextView Tletra ;
    TextView palabra ;
    TextView usedL;
    ImageView hang ;
    boolean[] mask = new  boolean[0];
    Stack<Character> usedLetters = new Stack<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);

        /*palabra a adivinar*/
        hang = findViewById(R.id.hangmanView);
        usedL = findViewById(R.id.usedletText);

        lives = 6;//vidas
        hints = 1;//pistas

        final String word = "actividad"; //Palabra a jugar

        palabra = findViewById(R.id.Palabra);
        palabra.setText("_ _ _ _ _ _ _ _ _");

        final char[] wordc = word.toCharArray();
        final boolean[] maskTrue = new boolean[wordc.length];
        Arrays.fill(maskTrue,true);

        mask = new boolean[wordc.length];
        Arrays.fill(mask,false);

        final boolean[] maskFalse = mask;



        /*Toast limite de pistas */
        Context context = getApplicationContext();
        CharSequence texth = "Solo 1 pista por palabra";
        CharSequence textv = "ya se adivino la palabra";
        CharSequence textd = "ya no teine mas vidas";
        //?????
        int duration = Toast.LENGTH_SHORT; //Duración del mensaje
        final Toast toastHint = Toast.makeText(context, texth, duration);
        final Toast toastV = Toast.makeText(context, textv, duration);
        final Toast toastD = Toast.makeText(context, textd, duration);
        toastHint.setGravity(Gravity.CENTER,0,0);
        toastV.setGravity(Gravity.CENTER,0,0);
        toastD.setGravity(Gravity.CENTER,0,0);

        bGuess =  findViewById(R.id.buttnguess);
        Tletra =  findViewById(R.id.TextLetra);

        /*accion boto de advinar*/
        bGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(lives <= 0)
                {
                    toastD.show();
                }else if (areAllTrue(mask))
                {
                    toastV.show();
                } else
                    {
                        char letra = Tletra.getText().toString().charAt(0);
                        usedLetters.push(letra);
                        boolean[] prevMask = Arrays.copyOf(mask, mask.length);

                        mask = gameController.guess(wordc,mask,letra);

                        if(Arrays.equals(mask,prevMask)){
                            lives -= 1;
                        }else {
                            char[] gWord = new char[mask.length];
                            for(int i = 0;i < mask.length;i++)
                            {
                                if (mask[i]==false)
                                {
                                    gWord[i] = '_';
                                }else{
                                    gWord[i] = wordc[i];
                                }
                            }
                            StringBuilder gpalabra = new StringBuilder(gWord.length);
                            for (char c : gWord){
                                gpalabra.append(c).append(" ");
                            }
                            gpalabra.toString();
                            palabra.setText(gpalabra);
                    }
                    updateHangman(lives);
                    updateLetters(usedLetters);
                }
            }

        });

        /*Accion boton de pista*/
        bHint = findViewById(R.id.hintButton);
        bHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hints <= 0){
                    toastHint.show();
                }else if (areAllTrue(mask)){
                    toastV.show();
                } else{
                    hints -=1;
                    char letraH = gameController.hint(word, mask);
                    usedLetters.push(letraH);
                    //palabra.setText(Character.toString(letraH));
                    mask = gameController.guess(wordc,mask,letraH);
                    char[] gWord = new char[mask.length];
                    for(int i = 0;i<mask.length;i++){
                        if (mask[i]==false){
                            gWord[i] = '_';
                        }else{
                            gWord[i] = wordc[i];
                        }
                    }
                    StringBuilder gpalabra = new StringBuilder(gWord.length);
                    for (char c : gWord){
                        gpalabra.append(c).append(" ");
                    }
                    gpalabra.toString();
                    palabra.setText(gpalabra);
                    updateHangman(lives);

                }
            }
        });
    }
    /*Funcion que actualiza el dibujo*/
    public  void updateHangman(int lives){
        if(areAllTrue(mask)){
            hang.setImageResource(R.drawable.hangamanvictory);
        }else{
            if(lives==6) {
                hang.setImageResource(R.drawable.hangman0);
            }else if (lives ==5){
                hang.setImageResource(R.drawable.hangman1);
            }else if (lives ==4){
                hang.setImageResource(R.drawable.hangman2);
            }else if (lives ==3){
                hang.setImageResource(R.drawable.hangman3);
            }
            else if (lives ==2){
                hang.setImageResource(R.drawable.hangman4);
            }
            else if (lives ==1){
                hang.setImageResource(R.drawable.hangman5);
            }
            else if (lives ==0){
                hang.setImageResource(R.drawable.hangman6);
            }
        }
    }

    /*Revisa si todos los valores en el arrgelo son true*/
    public static boolean areAllTrue(boolean[] array)
    {
        for(boolean b : array) if(!b) return false;
        return true;
    }

    /*Funcion que muestra las letras ya usadas*/
    public void updateLetters(Stack<Character> used){
        usedL.setText(used.toString());
    }
}
