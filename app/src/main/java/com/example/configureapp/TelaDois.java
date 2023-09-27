package com.example.configureapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class TelaDois extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton choiceMale;
    private RadioButton choiceFemale;
    private EditText nome;
    private EditText sobrenome;
    private EditText telefone;
    public static SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_dois);

        radioGroup = findViewById(R.id.radioGroup);
        choiceMale = findViewById(R.id.choiceMale);
        choiceFemale = findViewById(R.id.choiceFemale);
        nome = findViewById(R.id.nome);
        sobrenome = findViewById(R.id.sobrenome);
        telefone = findViewById(R.id.telefone);

        sharedPreferences = getSharedPreferences("MinhasPreferencias", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        String generoSelecionado = sharedPreferences.getString("genero", "");
        if (!generoSelecionado.isEmpty()) {
            if (generoSelecionado.equals("Masculino")) {
                choiceMale.setChecked(true);
            } else if (generoSelecionado.equals("Feminino")) {
                choiceFemale.setChecked(true);
            }
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.choiceMale) {
                    // Usuário selecionou "Masculino"
                    editor.putString("genero", "Masculino");
                } else if (checkedId == R.id.choiceFemale) {
                    // Usuário selecionou "Feminino"
                    editor.putString("genero", "Feminino");
                }
                // Aplica as alterações no editor
                editor.apply();
            }
        });

    }

    public void voltarParaConfiguracao(View view) {
        Intent intent = new Intent(TelaDois.this, MainActivity.class);
        startActivity(intent);
    }

    public void salvarDados(View view) {
        String nomeDigitado = nome.getText().toString();
        String sobrenomeDigitado = sobrenome.getText().toString();
        String telefoneDigitado = telefone.getText().toString();

        editor.putString("nome", nomeDigitado);
        editor.putString("sobrenome", sobrenomeDigitado);
        editor.putString("telefone", telefoneDigitado);
        editor.apply();

        AlertDialog.Builder msg = new AlertDialog.Builder(this);
        msg.setMessage(nome.toString() + " você foi cadastrado com sucesso!");
        msg.show();
    }


}