package com.dastan.who;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onNumberClick(View view) {
        Intent numberIntent = new Intent(MainActivity.this, NumberActivity.class);
        startActivity(numberIntent);
    }

    public void onTextClick(View view) {
        Intent textIntent = new Intent(MainActivity.this, TextActivity.class);
        startActivity(textIntent);
    }
}