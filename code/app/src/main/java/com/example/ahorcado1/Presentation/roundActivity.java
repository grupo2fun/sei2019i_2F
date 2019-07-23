package com.example.ahorcado1.Presentation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
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

import com.example.ahorcado1.BusinessLogic.controllers.Globals;
import com.example.ahorcado1.BusinessLogic.controllers.gameController;
import com.example.ahorcado1.BusinessLogic.controllers.wordController;
import com.example.ahorcado1.DataAccess.models.Word;
import com.example.ahorcado1.R;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class roundActivity extends AppCompatActivity {

    int lives;
    int hints;
    int score;
    ImageButton bGuess;

    ImageButton bHint;
    ImageButton bback;
    TextView Tletra;
    TextView palabra;
    TextView usedL;
    TextView Tscore;
    ImageView hang;
    boolean[] mask = new boolean[0];
    LinkedList<Character> usedLetters = new LinkedList<>();
    gameController gameCont = new gameController();
    //Stack<Character> usedLetters = new Stack<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);

        /*palabra a adivinar*/
        hang = findViewById(R.id.hangmanView);
        usedL = findViewById(R.id.usedletText);
        Tscore = findViewById(R.id.ScoreText);

        lives = 6;//vidas
        hints = 1;//pistas
        score = 0;//Puntaje

        //Palabra a jugar proveniente de la categoria
        wordController wordCont = new wordController();
        List<Word> listOfWords = wordCont.getWordsByCatDif(Globals.category, Globals.dif); //Categoría y dificultad
        int randomWordOfList = gameCont.randomNumber(listOfWords.size() - 1);
        final String word = listOfWords.get(randomWordOfList).getWord(); //Por ahora solo puedo obtener la información de categoría pero no de sus palabras


        palabra = findViewById(R.id.Palabra);
        //palabra.setText("_ _ _ _ _ _ _ _ _");
        Tscore.setText(Integer.toString(score));
        final char[] wordc = word.toCharArray();
        //muestra los espacios al inicio de la actividad
        final char beginword[]=new char[wordc.length];
        Arrays.fill(beginword,'_');
        StringBuilder bpalabra = new StringBuilder(beginword.length);
        for (char c : beginword) {
            bpalabra.append(c).append(" ");
        }
        palabra.setText(bpalabra);
        final boolean[] maskTrue = new boolean[wordc.length];
        Arrays.fill(maskTrue, true);
        mask = new boolean[wordc.length];
        Arrays.fill(mask, false);
        final boolean[] maskFalse = mask;


        /*Toast limite de pistas */
        Context context = getApplicationContext();
        CharSequence texth = "Solo 1 pista por palabra";
        CharSequence textv = "ya se adivino la palabra";
        CharSequence textd = "ya no tiene mas vidas";
        CharSequence textr = "letra ya usada";

        int duration = Toast.LENGTH_SHORT;
        final Toast toastHint = Toast.makeText(context, texth, duration);
        final Toast toastD = Toast.makeText(context, textd, duration);
        final Toast toastR = Toast.makeText(context, textr, duration);
        toastHint.setGravity(Gravity.CENTER, 0, 0);
        toastD.setGravity(Gravity.CENTER, 0, 0);
        toastR.setGravity(Gravity.CENTER, 0, 0);

        bGuess = findViewById(R.id.buttnguess);
        Tletra = findViewById(R.id.TextLetra);
        bback = findViewById(R.id.backButton);

        /*accion boto de advinar*/
        bGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lives <= 0) {
                    //Se sale a otra actividad que resume y crea y guarda la ronda

                    gameCont.createRound(Globals.user,Globals.category, (long)score);
                    //Instancia de otra actividad INTENT.... ETC

                    toastD.show();
                    lossAlert(score);
                } else if (areAllTrue(mask)) {
                    //Se sale a otra actividad que resume y crea y guarda la ronda

                    gameCont.createRound(Globals.user,Globals.category, (long)score);
                    //Instancia de otra actividad INTENT.... ETC

                    WinAlert(score);
                } else {
                    char letra = Tletra.getText().toString().toLowerCase().charAt(0);
                    //Si ya se uso ese caracter, siempre mostrará el mensaje y no se podrá continuar.
                    //Sino, continua el juego.
                    if (usedLetters.contains(letra)) {
                        toastR.show();
                    } else {
                        usedLetters.push(letra);
                        boolean[] prevMask = Arrays.copyOf(mask, mask.length);
                        mask = gameController.guess(wordc, mask, letra);
                        if (Arrays.equals(mask, prevMask)) {
                            lives -= 1;
                            score -= 50;
                        } else {
                            score += 100;
                            char[] gWord = new char[mask.length];
                            for (int i = 0; i < mask.length; i++) {
                                if (mask[i] == false) {
                                    gWord[i] = '_';
                                } else {
                                    gWord[i] = wordc[i];
                                }
                            }
                            StringBuilder gpalabra = new StringBuilder(gWord.length);
                            for (char c : gWord) {
                                gpalabra.append(c).append(" ");
                            }
                            gpalabra.toString();
                            palabra.setText(gpalabra);
                        }
                        updateHangman(lives);
                        updateLetters(usedLetters);
                        Tscore.setText(Integer.toString(score));
                    }
                }

                if (areAllTrue(mask)) {
                    //Se sale a otra actividad que resume y crea y guarda la ronda
                    gameCont.createRound(Globals.user,Globals.category, (long)score);
                    //Instancia de otra aactividad INTENT.... ETC
                    WinAlert(score);

                }

            }

        });

        /*Accion boton de pista*/
        bHint = findViewById(R.id.hintButton);
        bHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hints <= 0) {
                    toastHint.show();
                } else if (areAllTrue(mask)) {
                    WinAlert(score);
                } else {
                    score -= 25;
                    hints -= 1;
                    char letraH = gameController.hint(word, mask);
                    usedLetters.push(letraH);
                    //palabra.setText(Character.toString(letraH));
                    mask = gameController.guess(wordc, mask, letraH);
                    char[] gWord = new char[mask.length];
                    for (int i = 0; i < mask.length; i++) {
                        if (mask[i] == false) {
                            gWord[i] = '_';
                        } else {
                            gWord[i] = wordc[i];
                        }
                    }
                    StringBuilder gpalabra = new StringBuilder(gWord.length);
                    for (char c : gWord) {
                        gpalabra.append(c).append(" ");
                    }
                    gpalabra.toString();
                    palabra.setText(gpalabra);
                    updateHangman(lives);
                    Tscore.setText(Integer.toString(score));
                }
                if (areAllTrue(mask)) {
                    WinAlert(score);
                }
            }
        });

        bback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(roundActivity.this, categoryActivity.class);
                startActivity(i);
            }
        });
    }

    /*Funcion que actualiza el dibujo*/
    public void updateHangman(int lives) {
        if (areAllTrue(mask)) {
            hang.setImageResource(R.drawable.hangamanvictory);
        } else {
            if (lives == 6) {
                hang.setImageResource(R.drawable.hangman0);
            } else if (lives == 5) {
                hang.setImageResource(R.drawable.hangman1);
            } else if (lives == 4) {
                hang.setImageResource(R.drawable.hangman2);
            } else if (lives == 3) {
                hang.setImageResource(R.drawable.hangman3);
            } else if (lives == 2) {
                hang.setImageResource(R.drawable.hangman4);
            } else if (lives == 1) {
                hang.setImageResource(R.drawable.hangman5);
            } else if (lives == 0) {
                hang.setImageResource(R.drawable.hangman6);
            }
        }
    }

    /*Revisa si todos los valores en el arrgelo son true*/
    public static boolean areAllTrue(boolean[] array) {
        for (boolean b : array) if (!b) return false;
        return true;
    }

    /*Funcion que muestra las letras ya usadas*/
    public void updateLetters(LinkedList<Character> used) {
        usedL.setText(used.toString());
    }

    public void WinAlert(int score) {
        AlertDialog.Builder WAlert = new AlertDialog.Builder(this);
        WAlert.setMessage("Ganaste, tu puntaje final es de : " + Integer.toString(score))
                .setPositiveButton("Siguiente", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(roundActivity.this, categoryActivity.class);
                        startActivity(i);
                        //dialog.dismiss();
                    }
                })
                .setTitle("!!!!!!!!!!!!!Felicitaciones¡¡¡¡¡¡¡¡¡¡¡¡¡¡")
                .setIcon(R.drawable.hangamanvictory)
                .create();
        WAlert.show();

    }

    public void lossAlert(int score)
    {
        AlertDialog.Builder lAlert = new AlertDialog.Builder(this);
        lAlert.setMessage("Perdiste, tu puntaje final es de : " + Integer.toString(score))
                .setPositiveButton("Siguiente", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(roundActivity.this, categoryActivity.class);
                        startActivity(i);
                        //dialog.dismiss();
                    }
                })
                .setTitle("Inténtalo de nuevo")
                .setIcon(R.drawable.hangamanvictory)
                .create();
        lAlert.show();

    }

}
