package com.thaissoares.agendamentoodontologico;

//Importando os elementos do banco de dados SQLite
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoDeDados extends SQLiteOpenHelper {

    //Nome em que o banco irá receber no celular
    private static final String NOME_BANCO = "bancoDados.db";
    //Ao fazer atualizações, mudar a versão para criar outro banco
    private static final int VERSAO = 7;
    //Método construtor - cria o banco de dados
    public BancoDeDados(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Paciente ("
                + "ID integer primary key autoincrement,"
                + "nome string,"
                + "email string,"
                + "CPF string,"
                + "dtNasc string,"
                + "senha string)";
        db.execSQL(sql);
        sql = "CREATE TABLE Dentista ("
                + "ID integer primary key autoincrement,"
                + "nome string,"
                + "CPF string,"
                + "especialidade string)";
        db.execSQL(sql);
        sql = "CREATE TABLE Agendamento ("
                + "IDAgendamento integer primary key autoincrement,"
                + "nome string,"
                + "data string,"
                + "hora string)";
        db.execSQL(sql);
        sql = "CREATE TABLE Feedback ("
                + "IDAgendamento integer primary key autoincrement,"
                + "comentario string)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Paciente");
        db.execSQL("DROP TABLE IF EXISTS Agendamento");
        db.execSQL("DROP TABLE IF EXISTS Feedback");
        onCreate(db);
    }
}