package com.thaissoares.agendamentoodontologico;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Feedback extends AppCompatActivity implements View.OnClickListener {
    Button BotaoVoltarFeedback, BotaoEnviarFeedback;
    RatingBar Classificacao;
    TextView Comentario;
    String ReceberEmail;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        BotaoVoltarFeedback = (Button) findViewById(R.id.BotaoVoltarFeedback);
        BotaoEnviarFeedback = (Button) findViewById(R.id.BotaoEnviarFeedback);
        Comentario = (TextView) findViewById(R.id.Comentario);

        BotaoVoltarFeedback.setOnClickListener(this);
        BotaoEnviarFeedback.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.BotaoVoltarFeedback) {
            Intent TelaPerfil = new Intent(this, Perfil.class);
            Bundle Parametros = new Bundle();
            Parametros.putString("Email", ReceberEmail);
            TelaPerfil.putExtras(Parametros);
            startActivity(TelaPerfil);
        }
        if (v.getId() == R.id.BotaoEnviarFeedback) {
            SalvarDados();
        }
    }

    public void SalvarDados() {
        String CampoComentario = Comentario.getText().toString();

        BancoController bd = new BancoController(getBaseContext());
        String Inserir;

        Inserir = bd.InserirComentario(CampoComentario);

        Toast.makeText(getApplicationContext(), Inserir, Toast.LENGTH_LONG).show();
        Limpar();
    }

    public void Limpar() {
        Comentario.setText("");
    }
}

