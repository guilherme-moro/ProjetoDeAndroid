package com.example.projetomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.app.dao.GrupoApoioDAO;
import br.com.app.model.GrupoApoio;


public class CriarGrupoAdm extends AppCompatActivity {

    EditText editTextNomeGrupo, editTextFocoGrupo, editTextDiaGrupo, editTextHorarioGrupo,editTextEstadoGrupo, editTextCidadeGrupo, editTextLinkGrupo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_grupo_adm);

        editTextNomeGrupo       = (EditText) findViewById(R.id.editTextNomeGrupo);
        editTextFocoGrupo       = (EditText) findViewById(R.id.editTextFocoGrupo);
        editTextDiaGrupo        = (EditText) findViewById(R.id.editTextDiaGrupo);
        editTextHorarioGrupo    = (EditText) findViewById(R.id.editTextHorarioGrupo);
        editTextEstadoGrupo     = (EditText) findViewById(R.id.editTextEstadoGrupo);
        editTextCidadeGrupo     = (EditText) findViewById(R.id.editTextCidadeGrupo);
        editTextLinkGrupo       = (EditText) findViewById(R.id.editTextLinkGrupo);
    }

    public void cadastrarGrupo (View v) {

        //verifica se os campos de cadastro do grupo estão vazios e se tiverem apresenta uma mensagem para preencher
        if (editTextNomeGrupo.getText().toString().equals("") || editTextFocoGrupo.getText().toString().equals("") ||
                editTextDiaGrupo.getText().toString().equals("") || editTextHorarioGrupo.getText().toString().equals("") ||
                editTextEstadoGrupo.getText().toString().equals("") || editTextCidadeGrupo.getText().toString().equals("")
                || editTextLinkGrupo.getText().toString().equals("") ) {
            Toast.makeText(CriarGrupoAdm.this, "Todos os campos de cadastro devem ser preenchidos. Tente novamente!", Toast.LENGTH_SHORT).show();
        } else { //campos preenchidos

            GrupoApoio grupoApoio = new GrupoApoio();
            GrupoApoioDAO grupoApoioDAO = new GrupoApoioDAO(this);

            //preenche dados do grupo de apoio
            grupoApoio.setNome_grupo(editTextNomeGrupo.getText().toString());
            grupoApoio.setFoco_grupo(editTextFocoGrupo.getText().toString());
            grupoApoio.setDia_grupo(editTextDiaGrupo.getText().toString());
            grupoApoio.setHorario_grupo(editTextHorarioGrupo.getText().toString());
            grupoApoio.setEstado_grupo(editTextEstadoGrupo.getText().toString());
            grupoApoio.setCidade_grupo(editTextCidadeGrupo.getText().toString());
            grupoApoio.setLink_grupo(editTextLinkGrupo.getText().toString());

            //insere no banco de dados
            grupoApoioDAO.gravarGrupo(grupoApoio);

            //mostra a mensagem de sucesso de cadastro e vai para a tela de inicio do admin
            Toast.makeText(CriarGrupoAdm.this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, TelaInicioAdministrador.class);
            startActivity(intent);

        }
    }

    //função utilizada no botão Voltar
    public void voltarTelaInicioAdm(View view){
        Intent intent = new Intent(this, TelaInicioAdministrador.class);

        startActivity(intent);
    }
}