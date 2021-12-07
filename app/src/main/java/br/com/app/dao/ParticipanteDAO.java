package br.com.app.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import br.com.app.model.Participante;
import br.com.app.util.MySQLiteHelper;

public class ParticipanteDAO {
    private SQLiteDatabase db = null;
    private MySQLiteHelper mySQLiteHelper = null;

    public ParticipanteDAO(Context context) {
        mySQLiteHelper = new MySQLiteHelper(context);
    }

    public long gravarParticipante(Participante part) throws SQLException {

        //utilizando a referência do banco de dados
        this.db = mySQLiteHelper.getWritableDatabase();

        //usando um ContentValues para inserir em cada campo da tabela
        ContentValues cv = new ContentValues();
        cv.put("nome", part.getNome());
        cv.put("id", part.getId());
        cv.put("email", part.getEmail());
        cv.put("senha", part.getSenha());

        //inserir os dados na tabela do participante
        long retorno = db.insert("participante", null, cv);

        //fechando o banco de dados
        db.close();

        //retornando a váriavel de insert
        return retorno;
    }


    public Participante validarLoginParticipante(String email, String senha) {

     Participante part = null;

     //consulta sql para ver se existe o email e senha passados no login do participante
     String sql = "SELECT * FROM participante WHERE email = '"+email+"'AND senha='"+senha+"'";

        //utilizando a referência do banco de dados
        this.db = mySQLiteHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        //utilizando o cursor
        while(cursor.moveToNext()){
            part = new Participante();
            part.setEmail(cursor.getString(3));
            part.setSenha(cursor.getString(4));
        }

        //fechando o banco de dados
        db.close();

        //retornando objeto participante
        return part;
    }
}
