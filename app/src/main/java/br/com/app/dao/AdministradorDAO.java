package br.com.app.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import br.com.app.model.Administrador;
import br.com.app.util.MySQLiteHelper;

public class AdministradorDAO {
    private SQLiteDatabase db = null;
    private MySQLiteHelper mySQLiteHelper = null;

    public AdministradorDAO(Context context) {mySQLiteHelper = new MySQLiteHelper(context); }

    public long gravarAdministrador(Administrador adm) throws SQLException {
        //utilizando a referência do banco de dados
        this.db = mySQLiteHelper.getWritableDatabase();

        //usando um ContentValues para inserir em cada campo da tabela
        ContentValues cv = new ContentValues();
        cv.put("nome_administrador", adm.getNome_adm());
        cv.put("grupo_administrador", adm.getGrupo_adm());
        cv.put("email_administrador", adm.getEmail_adm());
        cv.put("senha_administrador", adm.getSenha_adm());

        //inserir os dados na tabela do administrador
        long retorno = db.insert("administrador", null, cv);

        //fechando o banco de dados
        db.close();

        //retornando a váriavel de insert
        return retorno;
    }

    public Administrador validarLoginAdministrador(String email, String senha) {

        Administrador adm = null;

        //consulta sql para ver se existe o email e senha passados no login do administrador
        String sql = "SELECT * FROM administrador WHERE email_administrador = '"+email+"'AND senha_administrador='"+senha+"'";

        //utilizando a referência do banco de dados
        this.db = mySQLiteHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        //utilizando o cursor
        while(cursor.moveToNext()){
            adm = new Administrador();
            adm.setEmail_adm(cursor.getString(3));
            adm.setSenha_adm(cursor.getString(4));
        }

        //fechando o banco de dados
        db.close();

        //retornando o adm
        return adm;
    }


}
