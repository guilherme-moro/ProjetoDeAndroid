package com.example.projetomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.app.dao.GrupoApoioDAO;
import br.com.app.model.GrupoApoio;

public class VisualizarGruposAdm extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_grupos_adm);

        GrupoApoioDAO grupoApoioDAO = new GrupoApoioDAO(this);
        lv = (ListView) findViewById(R.id.listViewTodosGrupos);

        ArrayList<GrupoApoio> grupoList = grupoApoioDAO.recuperarGrupos();

        //lista de grupos criados
        ArrayList<String> grupoListDetalhado = new ArrayList<String>();

        for(GrupoApoio f : grupoList){
            //popula com os dados do grupo de apoio
            grupoListDetalhado.add("Nome: "+f.getNome_grupo()+" - Dia: "+f.getDia_grupo()+" - Hora: "+f.getHorario_grupo() + " - Link: "+f.getLink_grupo());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, grupoListDetalhado);

        //apresenta na list view
        lv.setAdapter(arrayAdapter);
    }

    //função utilizada no botão voltar
    public void voltarTelaInicioAdm(View view){
        Intent intent = new Intent(this, TelaInicioAdministrador.class);

        startActivity(intent);
    }


}