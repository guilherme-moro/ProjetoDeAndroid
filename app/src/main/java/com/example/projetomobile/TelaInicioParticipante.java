package com.example.projetomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.app.dao.GrupoApoioDAO;
import br.com.app.model.GrupoApoio;
import br.com.app.model.Participante;

public class TelaInicioParticipante extends AppCompatActivity {
    TextView textViewParticipante;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicio_participante);
        Participante part = new Participante();
        lv = (ListView) findViewById(R.id.lvGrupo);
        textViewParticipante = (TextView) findViewById(R.id.textViewParticipante);
        textViewParticipante.setText("Bem Vindo!");
    }

    public void buscarUmGrupo(View view){
        EditText edtTxtNomeGrupo = (EditText) findViewById(R.id.editTextBuscarGrupo);
        if(edtTxtNomeGrupo.getText().toString().isEmpty()){ //verifica se o campo de busca do nome está vazio
            Toast.makeText(getApplicationContext(),"Informe um nome do grupo para a busca!",Toast.LENGTH_SHORT).show();
        }else{ //campo de busca preenchido
            GrupoApoioDAO grupoApoioDAO = new GrupoApoioDAO(this);
            GrupoApoio g = grupoApoioDAO.recuperarGrupo(edtTxtNomeGrupo.getText().toString());

            //lista de grupos
            ArrayList<String> grupoListDetalhado = new ArrayList<String>();

            //popula com os dados do grupo
            grupoListDetalhado.add("Nome: "+g.getNome_grupo()+" - Foco : "+g.getFoco_grupo() +" - Dia : "+g.getDia_grupo()+" - Horário : " +g.getHorario_grupo()+" - Estado : "+ g.getEstado_grupo()+" - Cidade : "+ g.getCidade_grupo() +" - Link : "+g.getLink_grupo());
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, grupoListDetalhado);

            //apresenta na list view
            lv.setAdapter(arrayAdapter);
        }
    }

    //função utilizada no botão Sair
    public void sairTelaInicioParticipante(View view){
        Intent intent = new Intent(this, LoginParticipante.class);

        startActivity(intent);
    }
}