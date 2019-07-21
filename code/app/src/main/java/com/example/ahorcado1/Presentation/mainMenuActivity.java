package com.example.ahorcado1.Presentation;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.ahorcado1.BusinessLogic.controllers.Globals;
import com.example.ahorcado1.BusinessLogic.controllers.categoryController;
import com.example.ahorcado1.BusinessLogic.controllers.gameController;
import com.example.ahorcado1.BusinessLogic.controllers.loginController;
import com.example.ahorcado1.DataAccess.models.Category;
import com.example.ahorcado1.R;

import java.util.Stack;

public class mainMenuActivity extends AppCompatActivity {

    ImageButton button1;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //Instancia de controller
        final gameController gameController1 = new gameController();

        button1 = (ImageButton) findViewById(R.id.imageButton);
        button2 = (Button) findViewById(R.id.pruebaButton);

        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Lógica de juego
                //CATEGORÍA
                //En cada botón de categoría debe ir una instanciación a la varaible Global "Categoría"
                //Iniciar actividad de juego
                //JUEGO
                //Inicia la actividad del juego, y al final del mismo se debe crear un objeto Round, instanciarlo con todos los datos.
                //Round: Usuario, categoría, puntaje
                //Al usuario se le debe acumular el puntaje: (Pseduocodigo)
                //puntaje:  usuario.getPuntaje + puntajePartida;
                //usuario.setPuntaje(puntaje)
                //Hacerlo dentro de un controlador acumularPuntaje(puntaje, usuario), actualizar repositorio.

                //Código de prueba
                /*
                String word = "leon";
                char[] wordChar = word.toCharArray();
                char charToFind = 'e';
                Stack<Integer> stack = gameController1.find(wordChar, charToFind);

                Toast.makeText(getApplicationContext(),"Palabra: " + word + "\n" +  "Número de veces que se repite " + charToFind + " : " + stack.size(),Toast.LENGTH_SHORT).show();
                */

            }
        } );

        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Se obtienen la información de la categoría
                String nombreCategoria = "Animales";
                int idCategoria = 0;
                //Instancia del controlador de categoría y actualización del objeto global de categoría
                categoryController categoryCont = new categoryController();
                Globals.category = categoryCont.getCategory(idCategoria);
                //Cambio de actividad
                Intent i =new Intent(mainMenuActivity.this, roundActivity.class);
                startActivity(i);
            }
        } );
    }
}
