package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button simpleButton, aboutButton, exitButton, advancedButton;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleButton = findViewById(R.id.simpleButton);
        aboutButton = findViewById(R.id.aboutButton);
        exitButton = findViewById(R.id.exitButton);
        advancedButton = findViewById(R.id.advancedButton);

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("tag","OnClick");
                finish();
                System.exit(0);
            }
        });

        simpleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("tag","OnClick");
                Intent SimpleCalc = new Intent(MainActivity.this, SimpleCalculatorAvticity.class);
                startActivity(SimpleCalc);
            }
        });

        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("tag","OnClick");
                Intent AboutActivity = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(AboutActivity);
            }
        });

        advancedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("tag","OnClick");
                Intent AboutActivity = new Intent(MainActivity.this, AdvancedActivity.class);
                startActivity(AboutActivity);
            }
        });


    }


}