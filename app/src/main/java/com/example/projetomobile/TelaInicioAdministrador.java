package com.example.projetomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TelaInicioAdministrador extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicio_administrador);
    }

    //função utilizada no botão Criar Grupo de apoio
    public void mostrarTelaCriarGrupo (View view){
        Intent intent = new Intent(this, CriarGrupoAdm.class);
        startActivity(intent);
    }

    //função utilizada no botão Visualizar Grupos criados
    public void mostrarTelaVisualizarGrupos (View view){
        Intent intent = new Intent(this, VisualizarGruposAdm.class);
        startActivity(intent);
    }

    //função utilizada no botão Sair
    public void sairTelaInicioAdm (View view){
        Intent intent = new Intent(this, LoginAdministrador.class);
        startActivity(intent);
    }


}