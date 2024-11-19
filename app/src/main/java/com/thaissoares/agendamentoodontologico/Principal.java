package com.thaissoares.agendamentoodontologico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Principal extends AppCompatActivity implements View.OnClickListener {
    Button BotaoUsuario, BotaoExtracao, BotaoConsulta, BotaoAparelho, BotaoProtese, BotaoLimpeza, BotaoCanal, BotaoFacetas, BotaoTartaro, BotaoClareamento, BotaoRestauracao, BotaoFluor, BotaoPeriodontia;
    String ReceberEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Intent Receber = getIntent();
        Bundle Parametros = Receber.getExtras();
        ReceberEmail = Parametros.getString("Email");

        BotaoUsuario = (Button) findViewById(R.id.BotaoUsuario);
        BotaoExtracao = (Button) findViewById(R.id.BotaoExtracao);
        BotaoConsulta = (Button) findViewById(R.id.BotaoConsulta);
        BotaoAparelho = (Button) findViewById(R.id.BotaoAparelho);
        BotaoProtese = (Button) findViewById(R.id.BotaoProtese);
        BotaoLimpeza = (Button) findViewById(R.id.BotaoLimpeza);
        BotaoCanal = (Button) findViewById(R.id.BotaoCanal);
        BotaoFacetas = (Button) findViewById(R.id.BotaoFacetas);
        BotaoTartaro = (Button) findViewById(R.id.BotaoTartaro);
        BotaoClareamento = (Button) findViewById(R.id.BotaoClareamento);
        BotaoRestauracao = (Button) findViewById(R.id.BotaoRestauracao);
        BotaoFluor = (Button) findViewById(R.id.BotaoFluor);
        BotaoPeriodontia = (Button) findViewById(R.id.BotaoPeriodontia);

        BotaoUsuario.setOnClickListener(this);
        BotaoExtracao.setOnClickListener(this);
        BotaoConsulta.setOnClickListener(this);
        BotaoAparelho.setOnClickListener(this);
        BotaoProtese.setOnClickListener(this);
        BotaoLimpeza.setOnClickListener(this);
        BotaoCanal.setOnClickListener(this);
        BotaoFacetas.setOnClickListener(this);
        BotaoTartaro.setOnClickListener(this);
        BotaoClareamento.setOnClickListener(this);
        BotaoRestauracao.setOnClickListener(this);
        BotaoFluor.setOnClickListener(this);
        BotaoPeriodontia.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.BotaoUsuario) {
            Intent TelaEditar = new Intent(this, Perfil.class);
            Bundle Parametros = new Bundle();
            Parametros.putString("Email", ReceberEmail);
            TelaEditar.putExtras(Parametros);
            startActivity(TelaEditar);
        }
        if (v.getId() == R.id.BotaoExtracao) {
            Intent TelaAgendamento = new Intent(this, Agendamento.class);
            startActivity(TelaAgendamento);
        }
        if (v.getId() == R.id.BotaoConsulta) {
            Intent TelaAgendamento = new Intent(this, Agendamento.class);
            startActivity(TelaAgendamento);
        }
        if (v.getId() == R.id.BotaoAparelho) {
            Intent TelaAgendamento = new Intent(this, Agendamento.class);
            startActivity(TelaAgendamento);
        }
        if (v.getId() == R.id.BotaoProtese) {
            Intent TelaAgendamento = new Intent(this, Agendamento.class);
            startActivity(TelaAgendamento);
        }
        if (v.getId() == R.id.BotaoLimpeza) {
            Intent TelaAgendamento = new Intent(this, Agendamento.class);
            startActivity(TelaAgendamento);
        }
        if (v.getId() == R.id.BotaoCanal) {
            Intent TelaAgendamento = new Intent(this, Agendamento.class);
            startActivity(TelaAgendamento);
        }
        if (v.getId() == R.id.BotaoFacetas) {
            Intent TelaAgendamento = new Intent(this, Agendamento.class);
            startActivity(TelaAgendamento);
        }
        if (v.getId() == R.id.BotaoTartaro) {
            Intent TelaAgendamento = new Intent(this, Agendamento.class);
            startActivity(TelaAgendamento);
        }
        if (v.getId() == R.id.BotaoClareamento) {
            Intent TelaAgendamento = new Intent(this, Agendamento.class);
            startActivity(TelaAgendamento);
        }
        if (v.getId() == R.id.BotaoRestauracao) {
            Intent TelaAgendamento = new Intent(this, Agendamento.class);
            startActivity(TelaAgendamento);
        }
        if (v.getId() == R.id.BotaoFluor) {
            Intent TelaAgendamento = new Intent(this, Agendamento.class);
            startActivity(TelaAgendamento);
        }
        if (v.getId() == R.id.BotaoPeriodontia) {
            Intent TelaAgendamento = new Intent(this, Agendamento.class);
            startActivity(TelaAgendamento);
        }
    }
}