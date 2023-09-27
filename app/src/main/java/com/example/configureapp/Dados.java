package com.example.configureapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Dados extends AppCompatActivity {

    private TextView textViewNome;
    private TextView textViewSobrenome;
    private TextView textViewNumero;
    private TextView textViewGenero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);

        textViewNome = (TextView) findViewById(R.id.textViewNome);
        textViewSobrenome = (TextView) findViewById(R.id.textViewSobrenome);
        textViewNumero = (TextView) findViewById(R.id.textViewNumero);
        textViewGenero = (TextView) findViewById(R.id.textViewGenero);

        String nomeSalvo = TelaDois.sharedPreferences.getString("nome", "");
        String sobrenomeSalvo = TelaDois.sharedPreferences.getString("sobrenome", "");
        String telefoneSalvo = TelaDois.sharedPreferences.getString("telefone", "");
        String generoSalvo = TelaDois.sharedPreferences.getString("genero", "");

        textViewNome.setText("Nome: " + nomeSalvo);
        textViewSobrenome.setText("Sobrenome: " + sobrenomeSalvo);
        textViewNumero.setText("Telefone: " + telefoneSalvo);
        textViewGenero.setText("Gênero: " + generoSalvo);

    }

    public void voltarParaConfiguracoes (View view) {
        Intent intent = new Intent(Dados.this, MainActivity.class);
        startActivity(intent);
    }


}