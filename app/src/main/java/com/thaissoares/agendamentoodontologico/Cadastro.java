package com.thaissoares.agendamentoodontologico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastro extends AppCompatActivity implements View.OnClickListener {
    EditText CadastroNome, CadastroEmail, CadastroCPF, CadastroDtNasc, CadastroSenha;
    Button SalvarBotaoCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        CadastroNome = (EditText) findViewById(R.id.CadastroNome);
        CadastroEmail = (EditText) findViewById(R.id.CadastroEmail);
        CadastroCPF = (EditText) findViewById(R.id.CadastroCPF);
        CadastroDtNasc = (EditText) findViewById(R.id.CadastroDtNasc);
        CadastroSenha = (EditText) findViewById(R.id.CadastroSenha);
        SalvarBotaoCadastro = (Button) findViewById(R.id.SalvarBotaoCadastro);

        SalvarBotaoCadastro.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (ValidarDados() == true) {
            SalvarDados();
            Intent TelaLogin = new Intent(this, MainActivity.class);
            startActivity(TelaLogin);
        }else {
            //Erro
        }
    }

    public boolean ValidarDados() {
        boolean retorno = true;
        String mensagem = "";
        if (CadastroNome.getText().length()==0){
            mensagem = "O campo nome precisa ser preenchido!";
            Toast.makeText(getApplicationContext(),mensagem, Toast.LENGTH_LONG).show();
            retorno = false;
        }
        if (CadastroEmail.getText().length()==0){
            mensagem = "O campo nome E-mail ser preenchido!";
            Toast.makeText(getApplicationContext(),mensagem, Toast.LENGTH_LONG).show();
            retorno = false;
        }
        if (CadastroCPF.getText().length()==0){
            mensagem = "O campo CPF precisa ser preenchido!";
            Toast.makeText(getApplicationContext(),mensagem, Toast.LENGTH_LONG).show();
            retorno = false;
        }
        if (CadastroCPF.getText().length() > 11){
            mensagem = "O campo CPF deve ter no máximo 11 números!";
            Toast.makeText(getApplicationContext(),mensagem, Toast.LENGTH_LONG).show();
            retorno = false;
        }
        if (CadastroDtNasc.getText().length()==0){
            mensagem = "O campo Dt. Nascimento  precisa ser preenchido!";
            Toast.makeText(getApplicationContext(),mensagem, Toast.LENGTH_LONG).show();
            retorno = false;
        }
        if (CadastroSenha.getText().length()==0){
            mensagem = "O campo Senha  precisa ser preenchido!";
            Toast.makeText(getApplicationContext(),mensagem, Toast.LENGTH_LONG).show();
            retorno = false;
        }
        return retorno;
    }

    public void SalvarDados() {
        String Nome = CadastroNome.getText().toString();
        String Email = CadastroEmail.getText().toString();
        String CPF = CadastroCPF.getText().toString();
        String DtNasc = CadastroDtNasc.getText().toString();
        String Senha = CadastroSenha.getText().toString();

        BancoController bd = new BancoController(getBaseContext());
        String Inserir;

        Inserir = bd.InserirDadosPaciente(Nome, Email, CPF, DtNasc, Senha);

        Toast.makeText(getApplicationContext(), Inserir, Toast.LENGTH_LONG).show();
        Limpar();
    }

    public void Limpar() {
        CadastroNome.setText("");
        CadastroEmail.setText("");
        CadastroCPF.setText("");
        CadastroDtNasc.setText("");
        CadastroSenha.setText("");
    }
}

