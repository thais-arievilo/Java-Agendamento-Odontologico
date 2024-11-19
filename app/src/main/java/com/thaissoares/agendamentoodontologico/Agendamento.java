package com.thaissoares.agendamentoodontologico;

import static android.app.ProgressDialog.show;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Agendamento extends AppCompatActivity implements View.OnClickListener {
    DatePicker Calendario;
    Button BotaoVoltarAgendamento, BotaoSalvarAgendamento;
    Spinner Horarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamento);

        Calendario = (DatePicker) findViewById(R.id.Calendario);
        BotaoVoltarAgendamento = (Button) findViewById(R.id.BotaoVoltarAgendamento);
        Horarios = (Spinner) findViewById(R.id.Horarios);
        BotaoSalvarAgendamento = (Button) findViewById(R.id.BotaoSalvarAgendamento);

        String[] Horas = new String[] {"Escolha um horário:", "08h00", "09h00", "10h00", "11h00", "13h00", "14h00", "15h00", "16h00"};
        ArrayAdapter<String> ListaHorarios = new ArrayAdapter<String>(this, R.layout.style_acspinner, Horas);
        Horarios.setAdapter(ListaHorarios);

        BotaoVoltarAgendamento.setOnClickListener(this);
        BotaoSalvarAgendamento.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.BotaoVoltarAgendamento) {
            Intent TelaPrincipal = new Intent(this, Principal.class);
            startActivity(TelaPrincipal);
        }
        if (v.getId() == R.id.BotaoSalvarAgendamento) {
            String Data, Hora;
            Data = Calendario.getDayOfMonth() + " / " + (Calendario.getMonth() + 1) + " / " + Calendario.getYear();
            Hora = Horarios.getSelectedItem().toString();

            BancoController bd = new BancoController(getBaseContext());
            String Inserir;

            if (Hora.equals("Escolha um horário:")){
                Inserir = "Escolha um horário válido.";
                Toast.makeText(getApplicationContext(), Inserir, Toast.LENGTH_LONG).show();
            }else {
                //Verificar se não tem duplicidade de horarios
                Cursor Dados = bd.ConsultarAgendamento(Data,Hora);
                if (Dados.moveToFirst()) {
                    Inserir = "A data e hora estão indisponiveis para agendamento.";
                    Toast.makeText(getApplicationContext(), Inserir, Toast.LENGTH_LONG).show();
                } else {
                    Inserir = bd.InserirDadosAgendandamento(Data, Hora);
                    Toast.makeText(getApplicationContext(), Inserir, Toast.LENGTH_LONG).show();

                }
            }
        }
    }
}