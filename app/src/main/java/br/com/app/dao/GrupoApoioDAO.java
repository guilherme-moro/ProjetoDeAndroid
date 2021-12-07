package br.com.app.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import br.com.app.model.GrupoApoio;
import br.com.app.util.MySQLiteHelper;

    public class GrupoApoioDAO {
    private SQLiteDatabase db = null;
    private MySQLiteHelper mySQLiteHelper = null;

    public GrupoApoioDAO(Context context) {mySQLiteHelper = new MySQLiteHelper(context); }

    public long gravarGrupo(GrupoApoio grupo) throws SQLException {

        //utilizando a referência do banco de dados
        this.db = mySQLiteHelper.getWritableDatabase();

        //usando um ContentValues para inserir em cada campo da tabela
        ContentValues cv = new ContentValues();
        cv.put("nome_grupo", grupo.getNome_grupo());
        cv.put("foco_grupo", grupo.getFoco_grupo());
        cv.put("dia_grupo", grupo.getDia_grupo());
        cv.put("horario_grupo", grupo.getHorario_grupo());
        cv.put("estado_grupo", grupo.getEstado_grupo());
        cv.put("cidade_grupo", grupo.getCidade_grupo());
        cv.put("link_grupo", grupo.getLink_grupo());

        //inserir os dados na tabela do Grupo de apoio
        long retorno = db.insert("grupoApoio", null, cv);

        //fechando o banco de dados
        db.close();

        //retornando a váriavel de insert
        return retorno;
    }

    public ArrayList<GrupoApoio> recuperarGrupos() {
        ArrayList<GrupoApoio> grupoList = new ArrayList<GrupoApoio>();

        //consulta sql para retornar todos os dados da tabela
        String query = "SELECT * FROM grupoApoio";

        //utilizando a referência do banco de dados
        this.db = mySQLiteHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        //transformando registros em objeto do tipo grupo e adicionando na lista
        if (cursor.moveToFirst()) {
            do {
                GrupoApoio grupo = new GrupoApoio();
                grupo.setNome_grupo(cursor.getString(1));
                grupo.setDia_grupo(cursor.getString(3));
                grupo.setHorario_grupo(cursor.getString(4));
                grupo.setLink_grupo(cursor.getString(7));

                //adicionando o grupo na lista de grupos de apoio
                grupoList.add(grupo);
            } while (cursor.moveToNext());
        }

        //fechando o banco de dados
        db.close();

        //retornando a lista de grupos
        return grupoList;
    }

    public GrupoApoio recuperarGrupo(String nome) {
        GrupoApoio grupo = null;

        //consulta sql para retornar todos os dados da tabela pelo nome que for passado
        String query = "SELECT * FROM grupoApoio WHERE nome_grupo = '" + nome +"'";

        //utilizando a referência do banco de dados
        this.db = mySQLiteHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        //transformando registros em objeto grupo
        if (cursor != null){
            cursor.moveToFirst();
            grupo = new GrupoApoio();
            grupo.setNome_grupo(cursor.getString(1));
            grupo.setFoco_grupo(cursor.getString(2));
            grupo.setDia_grupo(cursor.getString(3));
            grupo.setHorario_grupo(cursor.getString(4));
            grupo.setEstado_grupo(cursor.getString(5));
            grupo.setCidade_grupo(cursor.getString(6));
            grupo.setLink_grupo(cursor.getString(7));
        }

        //fechando o banco de dados
        db.close();

        //retornando grupo
        return grupo;
    }

}
