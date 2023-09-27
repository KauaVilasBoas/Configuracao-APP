package com.example.configureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irParaConfiguracoes (View view) {
        Intent intent = new Intent(MainActivity.this, TelaDois.class);
        startActivity(intent);
    }

    public void verDados (View view) {
        Intent intent = new Intent(MainActivity.this, Dados.class);
        startActivity(intent);
    }

}