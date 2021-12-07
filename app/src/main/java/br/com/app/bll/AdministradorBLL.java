package br.com.app.bll;

import android.content.Context;
import android.database.SQLException;

import br.com.app.dao.AdministradorDAO;
import br.com.app.model.Administrador;

public class AdministradorBLL {
    protected AdministradorDAO admDAO = null;

    public AdministradorBLL(Context context) {
        admDAO = new AdministradorDAO(context);
    }

    //retorna metodos admDao
    public long gravarAdministrador(Administrador adm) throws SQLException {
        return admDAO.gravarAdministrador(adm);
    }

    public Administrador validarLoginAdministrador (String email, String senha) {
        return admDAO.validarLoginAdministrador(email,senha);
    }
}
