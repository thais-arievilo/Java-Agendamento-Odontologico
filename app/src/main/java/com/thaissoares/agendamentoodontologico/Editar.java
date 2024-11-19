package com.thaissoares.agendamentoodontologico;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Editar extends AppCompatActivity implements View.OnClickListener {
    EditText EditarNome, EditarEmail, EditarCPF, EditarDtNasc, EditarSenha;
    Button BotaoVoltarEditarPerfil, SalvarBotaoEditar;
    String ReceberEmail;
    int IdUsuario = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        Intent Receber = getIntent();
        Bundle Parametros = Receber.getExtras();
        ReceberEmail = Parametros.getString("Email");

        EditarNome = (EditText) findViewById(R.id.EditarNome);
        EditarEmail = (EditText) findViewById(R.id.EditarEmail);
        EditarCPF = (EditText) findViewById(R.id.EditarCPF);
        EditarDtNasc = (EditText) findViewById(R.id.EditarDtNasc);
        EditarSenha = (EditText) findViewById(R.id.EditarSenha);

        BotaoVoltarEditarPerfil = (Button) findViewById(R.id.BotaoVoltarEditarPerfil);
        SalvarBotaoEditar = (Button) findViewById(R.id.SalvarBotaoEditar);

        BotaoVoltarEditarPerfil.setOnClickListener(this);
        SalvarBotaoEditar.setOnClickListener(this);
        
        BancoController bd = new BancoController(getBaseContext());
        Cursor Dados = bd.ConsultarUsuario(ReceberEmail);
        if(Dados.moveToFirst()){
            IdUsuario = Dados.getInt(0);
            EditarNome.setText(Dados.getString(1));
            EditarEmail.setText(Dados.getString(2));
            EditarCPF.setText(Dados.getString(3));
            EditarDtNasc.setText(Dados.getString(4));
            EditarSenha.setText(Dados.getString(5));
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.BotaoVoltarEditarPerfil) {
            Intent TelaPerfil = new Intent(this, Perfil.class);
            Bundle Parametros = new Bundle();
            Parametros.putString("Email", ReceberEmail);
            TelaPerfil.putExtras(Parametros);
            startActivity(TelaPerfil);
        }

        if (v.getId() == R.id.SalvarBotaoEditar) {
            if (ValidarDados() == true) {
                AlterarDados();
                Intent TelaPerfil = new Intent(this, Perfil.class);
                Bundle Parametros = new Bundle();
                Parametros.putString("Email", ReceberEmail);
                TelaPerfil.putExtras(Parametros);
                startActivity(TelaPerfil);
            }
        }
    }

    private void AlterarDados() {
        BancoController bd = new BancoController(getBaseContext());
        String Mensagem = bd.AlterarDadosUsuario(IdUsuario, EditarNome.getText().toString(), EditarDtNasc.getText().toString(), EditarSenha.getText().toString());
        Toast.makeText(getApplicationContext(),Mensagem, Toast.LENGTH_LONG).show();
    }

    public boolean ValidarDados() {
        boolean retorno = true;
        String mensagem = "";
        if (EditarNome.getText().length()==0){
            mensagem = "O campo Nome precisa ser preenchido!";
            Toast.makeText(getApplicationContext(),mensagem, Toast.LENGTH_LONG).show();
            retorno = false;
        }
        if (EditarDtNasc.getText().length()==0){
            mensagem = "O campo Data de Nascimento precisa ser preenchido!";
            Toast.makeText(getApplicationContext(),mensagem, Toast.LENGTH_LONG).show();
            retorno = false;
        }
        if (EditarSenha.getText().length()==0){
            mensagem = "O campo Senha precisa ser preenchido!";
            Toast.makeText(getApplicationContext(),mensagem, Toast.LENGTH_LONG).show();
            retorno = false;
        }
        return retorno;
    }
}