package br.com.app.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {

    //Definindo o nome da base de dados que vai ser utilizada
    private static final String DATABASE_NAME = "BdProjeto.db";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //criando as tabelas no banco de dados
        String criaTabelaParticipante = "CREATE TABLE IF NOT EXISTS participante (" + "pk_participante integer PRIMARY KEY AUTOINCREMENT," + "nome varchar(60) NOT NULL," + "id varchar(30) UNIQUE NOT NULL," + "email varchar(60) NOT NULL," + "senha varchar(15) NOT NULL);";
        String criaTabelaAdministrador = "CREATE TABLE IF NOT EXISTS administrador (" + "pk_administrador integer PRIMARY KEY AUTOINCREMENT," + "nome_administrador varchar(60) NOT NULL," + "grupo_administrador varchar (60) NOT NULL," + "email_administrador varchar(60) NOT NULL," + "senha_administrador varchar(15) NOT NULL);";
        String criaTabelaGrupoApoio = "CREATE TABLE IF NOT EXISTS grupoApoio (" + "pk_grupo integer PRIMARY KEY AUTOINCREMENT," + "nome_grupo varchar(60) NOT NULL," + "foco_grupo varchar (60) NOT NULL," + "dia_grupo varchar(40) NOT NULL," + "horario_grupo text NOT NULL," + "estado_grupo varchar(60) NOT NULL," + "cidade_grupo varchar(60) NOT NULL," + "link_grupo varchar(100) NOT NULL);";

        db.execSQL(criaTabelaParticipante);
        db.execSQL(criaTabelaAdministrador);
        db.execSQL(criaTabelaGrupoApoio);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
