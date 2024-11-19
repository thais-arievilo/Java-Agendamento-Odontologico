package com.thaissoares.agendamentoodontologico;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText LoginEmail, LoginSenha;
    Button BotaoLogin, Cadastre;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginEmail = (EditText) findViewById(R.id.LoginEmail);
        LoginSenha = (EditText) findViewById(R.id.LoginSenha);
        BotaoLogin = (Button) findViewById(R.id.BotaoLogin);
        Cadastre = (Button) findViewById(R.id.Cadastre);

        BotaoLogin.setOnClickListener(this);
        Cadastre.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.BotaoLogin) {
            if (ValidarDados()) {
                Intent TelaPrincipal = new Intent(this, Principal.class);
                Bundle Parametros = new Bundle();
                Parametros.putString("Email", LoginEmail.getText().toString());
                TelaPrincipal.putExtras(Parametros);
                startActivity(TelaPrincipal);
            }
        }
        if (v.getId() == R.id.Cadastre) {
            Intent TelaCadastreSe = new Intent(this, Cadastro.class);
            startActivity(TelaCadastreSe);
        }
    }

    public boolean ValidarDados() {
        String mensagem = "";
        boolean retorno = true;
        if (LoginEmail.getText().length() == 0) {
            mensagem = "O campo e-mail precisa ser preenchido!";
            Toast.makeText(getApplicationContext(),mensagem, Toast.LENGTH_LONG).show();
            retorno = false;
        }
        if (LoginSenha.getText().length() ==0) {
            mensagem = "O campo senha precisa ser preenchido!";
            Toast.makeText(getApplicationContext(),mensagem, Toast.LENGTH_LONG).show();
            retorno = false;
        }else {
            BancoController bd = new BancoController(getBaseContext());

            Cursor dados = bd.LoginEmailSenha(LoginEmail.getText().toString(),LoginSenha.getText().toString());

            if(!dados.moveToFirst()) {
                mensagem = "O E-mail ou Senha não foram encontrados.";
                Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_LONG).show();
                retorno = false;
            }
        }

        return retorno;
    }
}