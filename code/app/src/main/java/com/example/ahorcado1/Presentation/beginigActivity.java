package com.example.ahorcado1.Presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ahorcado1.R;

public class beginigActivity extends AppCompatActivity {

    Button br1, br2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginig);

        br1 = (Button)findViewById(R.id.loginBtn);
        br2 = (Button)findViewById(R.id.registerBtn);

        br1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(beginigActivity.this, loginUserActivity.class);
                startActivity(i);
            }
        });

        br2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(beginigActivity.this, registerUserActivity.class);
                startActivity(i);
            }
        });

    }
}
