package com.thaissoares.agendamentoodontologico;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Perfil extends AppCompatActivity implements View.OnClickListener {
    Button BotaoVoltarPerfil, BotaoPerfilEditar, BotaoPerfilFeedback, BotaoSair;
    String ReceberEmail;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        Intent Receber = getIntent();
        Bundle Parametros = Receber.getExtras();
        ReceberEmail = Parametros.getString("Email");

        BotaoVoltarPerfil = (Button) findViewById(R.id.BotaoVoltarPerfil);
        BotaoPerfilEditar = (Button) findViewById(R.id.BotaoPerfilEditar);
        BotaoPerfilFeedback = (Button) findViewById(R.id.BotaoPerfilFeedback);
        BotaoSair = (Button) findViewById(R.id.BotaoSair);

        BotaoVoltarPerfil.setOnClickListener(this);
        BotaoPerfilEditar.setOnClickListener(this);
        BotaoPerfilFeedback.setOnClickListener(this);
        BotaoSair.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.BotaoVoltarPerfil) {
            Intent TelaPrincipal = new Intent(this, Principal.class);
            Bundle Parametros = new Bundle();
            Parametros.putString("Email", ReceberEmail);
            TelaPrincipal.putExtras(Parametros);
            startActivity(TelaPrincipal);
        }

        if (v.getId() == R.id.BotaoPerfilEditar) {
            Intent TelaEditar = new Intent(this, Editar.class);
            Bundle Parametros = new Bundle();
            Parametros.putString("Email", ReceberEmail);
            TelaEditar.putExtras(Parametros);
            startActivity(TelaEditar);
        }

        if (v.getId() == R.id.BotaoPerfilFeedback) {
            Intent TelaFeedback = new Intent(this, Feedback.class);
            startActivity(TelaFeedback);
        }

        if (v.getId() == R.id.BotaoSair) {
            Intent TelaLogin = new Intent(this, MainActivity.class);
            startActivity(TelaLogin);
        }
    }
}