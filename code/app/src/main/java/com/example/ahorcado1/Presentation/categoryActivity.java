package com.example.ahorcado1.Presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ahorcado1.R;

public class categoryActivity extends AppCompatActivity {

    Button br1, br2, br3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        br1 = (Button)findViewById(R.id.animalsBtn);
        br2 = (Button)findViewById(R.id.cosasBtn);
        br3 = (Button)findViewById(R.id.actividadesBtn);

        br1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(categoryActivity.this, roundActivity.class);
                startActivity(i);
            }
        });

        br2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(categoryActivity.this, roundActivity.class);
                startActivity(i);
            }
        });

        br3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(categoryActivity.this, roundActivity.class);
                startActivity(i);
            }
        });

    }
}
