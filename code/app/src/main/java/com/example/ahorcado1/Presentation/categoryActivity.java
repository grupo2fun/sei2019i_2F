package com.example.ahorcado1.Presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ahorcado1.BusinessLogic.controllers.Globals;
import com.example.ahorcado1.BusinessLogic.controllers.categoryController;
import com.example.ahorcado1.BusinessLogic.controllers.wordController;
import com.example.ahorcado1.DataAccess.models.Category;
import com.example.ahorcado1.DataAccess.models.Word;
import com.example.ahorcado1.R;

import java.util.LinkedList;
import java.util.List;

public class categoryActivity extends AppCompatActivity {

    Spinner spn1, spn2;
    Button btn;
    categoryController cc = new categoryController();
    wordController wc = new  wordController();
    TextView t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        spn1 = (Spinner) findViewById(R.id.spnCat);
        spn2 = (Spinner) findViewById(R.id.spnDif);
        btn = (Button) findViewById(R.id.btnPlay);
        t1 = (TextView) findViewById(R.id.textName);
        t2 = (TextView) findViewById(R.id.textPuntaje);

        t1.setText(Globals.user.getUsername());
        t2.setText(String.valueOf(Globals.user.getScoreAccum()));

        List<String> lista1 = new LinkedList<>();
        List<Category> lc = cc.getAllCategories();

        for (int i = 0; i < lc.size(); i++) {
            lista1.add(lc.get(i).getName());
        }

        ArrayAdapter<String> adp = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, lista1
        );

        spn1.setAdapter(adp);

        List<Integer> lista2 = new LinkedList<>();
        lista2.add(1);
        lista2.add(2);
        lista2.add(3);

        ArrayAdapter<Integer> adp2 = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, lista2
        );

        spn2.setAdapter(adp2);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Category cat = cc.getCategoryByName(spn1.getSelectedItem().toString());
                int dif = Integer.parseInt(spn2.getSelectedItem().toString());

                List<Word> listWord = wc.getWordsByCatDif(cat, dif);
                if (listWord.size()!=0){
                    Globals.category = cat;
                    Globals.dif = dif;
                    //Intent i =new Intent(loginUserActivity.this,registerUserActivity.class);
                    Intent i =new Intent(categoryActivity.this, roundActivity.class);

                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(),"La categoria no tiene palabras para jugar, intente con otra categoria o nivel de dificultad",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}
