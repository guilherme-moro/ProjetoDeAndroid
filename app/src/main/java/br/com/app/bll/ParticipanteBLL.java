package br.com.app.bll;

import android.content.Context;
import android.database.SQLException;

import br.com.app.dao.ParticipanteDAO;
import br.com.app.model.Participante;

public class ParticipanteBLL {
    protected ParticipanteDAO partDAO = null;

    //retorna metodos participanteDAO

    public ParticipanteBLL(Context context) {
        partDAO = new ParticipanteDAO(context);
    }

    public long gravarParticipante(Participante part) throws SQLException {
        return partDAO.gravarParticipante(part);
    }

    public Participante validarLoginParticipante (String email, String senha) {
        return partDAO.validarLoginParticipante(email,senha);
    }

}
