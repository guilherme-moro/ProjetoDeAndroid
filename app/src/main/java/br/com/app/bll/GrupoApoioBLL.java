package br.com.app.bll;

import android.content.Context;
import android.database.SQLException;

import java.util.ArrayList;

import br.com.app.dao.GrupoApoioDAO;
import br.com.app.model.GrupoApoio;

public class GrupoApoioBLL {
    protected GrupoApoioDAO grupoApoioDAO = null;

    //retorna metodos grupoApoioDAO

    public GrupoApoioBLL(Context context) {
        grupoApoioDAO = new GrupoApoioDAO(context);
    }

    public ArrayList<GrupoApoio> recuperarGrupos() {
        return grupoApoioDAO.recuperarGrupos();
    }

    public GrupoApoio recuperarGrupo(String nome) {
        return grupoApoioDAO.recuperarGrupo(nome);
    }

    public long gravarGrupoApoio(GrupoApoio grupo) throws SQLException {
        return grupoApoioDAO.gravarGrupo(grupo);
    }


}
