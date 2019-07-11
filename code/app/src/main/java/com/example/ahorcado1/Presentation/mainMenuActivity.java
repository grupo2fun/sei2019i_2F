package com.example.ahorcado1.Presentation;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.ahorcado1.BusinessLogic.controllers.gameController;
import com.example.ahorcado1.BusinessLogic.controllers.loginController;
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
                String word = "leon";
                char[] wordChar = word.toCharArray();
                char charToFind = 'e';
                Stack<Integer> stack = gameController1.find(wordChar, charToFind);

                Toast.makeText(getApplicationContext(),"Palabra: " + word + "\n" +  "Número de veces que se repite " + charToFind + " : " + stack.size(),Toast.LENGTH_SHORT).show();
            }
        } );

        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i =new Intent(mainMenuActivity.this, roundActivity.class);
                startActivity(i);
            }
        } );
    }
}
