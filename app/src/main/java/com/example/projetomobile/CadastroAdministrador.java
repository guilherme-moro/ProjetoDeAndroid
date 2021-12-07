package com.example.projetomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.app.dao.AdministradorDAO;
import br.com.app.model.Administrador;

public class CadastroAdministrador extends AppCompatActivity {

    EditText editTextNomeAdm, editTextGrupoAdm, editTextEmailAdm, editTextSenhaAdm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_administrador);
        editTextNomeAdm = (EditText) findViewById(R.id.editTextNomeAdm);
        editTextGrupoAdm = (EditText) findViewById(R.id.editTextGrupoAdm);
        editTextEmailAdm = (EditText) findViewById(R.id.editTextEmailAdm);
        editTextSenhaAdm = (EditText) findViewById(R.id.editTextSenhaAdm);
    }

    public void cadastrarAdministrador (View v) {

        //verifica se algum campo de cadastro está vazio e se tiver retorna uma mensagem para preencher
        if (editTextNomeAdm.getText().toString().equals("") || editTextGrupoAdm.getText().toString().equals("") ||
                editTextEmailAdm.getText().toString().equals("") || editTextSenhaAdm.getText().toString().equals("")) {
            Toast.makeText(CadastroAdministrador.this, "Todos os campos de cadastro devem ser preenchidos. Tente novamente!", Toast.LENGTH_SHORT).show();
        } else { //campos não ficaram vazios
            Administrador administrador = new Administrador();
            AdministradorDAO administradorDAO = new AdministradorDAO(this);

            //preenche dados do admin
            administrador.setNome_adm(editTextNomeAdm.getText().toString());
            administrador.setGrupo_adm(editTextGrupoAdm.getText().toString());
            administrador.setEmail_adm(editTextEmailAdm.getText().toString());
            administrador.setSenha_adm(editTextSenhaAdm.getText().toString());

            //insere no banco de dados
            administradorDAO.gravarAdministrador(administrador);

            //mostra a mensagem de sucesso de cadastro e vai para a tela de login
            Toast.makeText(CadastroAdministrador.this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, LoginAdministrador.class);
            startActivity(intent);

        }
    }

    //função utilizada no botão Voltar
    public void voltarTelaLoginAdm(View view){
        Intent intent = new Intent(this, LoginAdministrador.class);

        startActivity(intent);
    }
}