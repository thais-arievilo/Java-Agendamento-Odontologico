package com.thaissoares.agendamentoodontologico;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BancoController {
    private SQLiteDatabase db;
    private BancoDeDados banco;

    public BancoController(Context context) {
        banco = new BancoDeDados(context);
    }

    public String InserirDadosPaciente(String nome, String email, String cpf, String dtNasc, String senha) {
        ContentValues Dados;
        long Inserir;
        db = banco.getWritableDatabase();

        Dados = new ContentValues();
        Dados.put("nome", nome);
        Dados.put("email", email);
        Dados.put("cpf", cpf);
        Dados.put("dtNasc", dtNasc);
        Dados.put("senha", senha);

        Inserir = db.insert("Paciente", null, Dados);
        db.close();

        if (Inserir == -1)
            return "Ocorreu um erro ao tentar inserir os dados.";
        else
            return "Registro concluido com sucesso!";
    }

    public Cursor LoginEmailSenha(String email, String senha) {
        Cursor cursor;
        String[] campos = {"ID", "nome", "email", "CPF", "dtNasc", "senha"};
        String where = "email = '" + email + "' and senha = '" + senha + "' ";
        db = banco.getReadableDatabase();
        cursor = db.query("Paciente", campos, where, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public String InserirDadosAgendandamento(String data, String hora) {
        ContentValues Dados;
        long Inserir;
        db = banco.getWritableDatabase();

        Dados = new ContentValues();
        Dados.put("data", data);
        Dados.put("hora", hora);

        Inserir = db.insert("Agendamento", null, Dados);
        db.close();

        if (Inserir == -1)
            return "Ocorreu um erro ao tentar inserir os dados.";
        else
            return "Agendamento concluido com sucesso!";
    }

    public Cursor ConsultarAgendamento(String data, String hora) {
        Cursor cursor;

        String[] campos = { "IDAgendamento", "nome", "data", "hora" };
        String where = "data = '" + data + "' and hora = '" + hora + "' ";
        db = banco.getReadableDatabase();
        cursor = db.query("Agendamento", campos, where, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public String InserirComentario(String comentario) {
        ContentValues Dados;
        long Inserir;
        db = banco.getWritableDatabase();

        Dados = new ContentValues();
        Dados.put("comentario", comentario);

        Inserir = db.insert("Feedback", null, Dados);
        db.close();

        if (Inserir == -1)
            return "Ocorreu um erro ao tentar inserir o Feedback.";
        else
            return "Feedback realizado com sucesso!";
    }

    public Cursor ConsultarUsuario(String receberEmail) {
        Cursor cursor;
        String[] campos = {"ID", "nome", "email", "CPF", "dtNasc", "senha"};
        String where = "email = '" + receberEmail + "'";
        db = banco.getReadableDatabase();
        cursor = db.query("Paciente", campos, where, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public String AlterarDadosUsuario(int idUsuario, String nome, String dtnasc, String senha) {
        String Mensagem = "Dados alterados com sucesso!";

        db = banco.getReadableDatabase();

        ContentValues Dados = new ContentValues();
        Dados.put("nome", nome);
        Dados.put("dtNasc", dtnasc);
        Dados.put("senha", senha);

        String Condicao = "ID = " + idUsuario;

        int linha;
        linha = db.update("Paciente", Dados, Condicao, null) ;

        if (linha < 1){
            Mensagem = "Erro ao tentar alterar os dados";
        }

        db.close();
        return Mensagem;
    }
}

