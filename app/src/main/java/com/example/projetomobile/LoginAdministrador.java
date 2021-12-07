package com.example.projetomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.app.dao.AdministradorDAO;
import br.com.app.model.Administrador;

public class LoginAdministrador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_administrador);
    }

    public void logarAdministrador(View view){
        AdministradorDAO administradorDAO = new AdministradorDAO(this);

        //definindo as variaveis email e senha para os campos de login
        String email = ((EditText) findViewById(R.id.editTextEmailLoginAdm)).getText().toString();
        String senha = ((EditText) findViewById(R.id.editTextSenhaLoginAdm)).getText().toString();

        //acessando o método de validar login do adm
        Administrador adm = administradorDAO.validarLoginAdministrador(email, senha);

        //verifica se o administrador existe
        if (adm != null) { //administrador existe
            //mostra a mensagem de sucesso e abre a página inicial do adm
            Toast.makeText(LoginAdministrador.this, "Login de administrador feito com sucesso!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, TelaInicioAdministrador.class);
            startActivity(intent);
        }else{ //administrador não existe
            //mostra a mensagem de erro e permanece na tela de login
            Toast.makeText(LoginAdministrador.this, "Email ou senha não conferem!", Toast.LENGTH_SHORT).show();
        }

    }

    //função utilizada no botão Cadastre-se
    public void mostrarTelaCadastroAdm(View view){
        Intent intent = new Intent(this, CadastroAdministrador.class);
        startActivity(intent);
    }

    //função utilizada no botão Voltar
    public void admVoltarTelaInicial(View view){
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }
}