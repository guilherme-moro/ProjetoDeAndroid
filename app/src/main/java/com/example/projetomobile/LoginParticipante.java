package com.example.projetomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.app.dao.ParticipanteDAO;
import br.com.app.model.Participante;

public class LoginParticipante extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_participante);
    }

    public void logarParticipante(View view) {

        ParticipanteDAO participanteDAO = new ParticipanteDAO(this);

        //definindo as variaveis email e senha para os campos de login
        String email = ((EditText) findViewById(R.id.editTextEmailLoginPart)).getText().toString();
        String senha = ((EditText) findViewById(R.id.editTextSenhaLoginPart)).getText().toString();

        //acessando o método de validar login do participante
        Participante part = participanteDAO.validarLoginParticipante(email, senha);

        //verifica se o participante existe
        if (part != null) { //participante existe
            //mostra a mensagem de sucesso e abre a página inicial do participante
            Toast.makeText(LoginParticipante.this, "Login de participante feito com sucesso!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, TelaInicioParticipante.class);
            startActivity(intent);
        }else{ //participante não existe
            //mostra a mensagem de erro e permanece na tela de login
            Toast.makeText(LoginParticipante.this, "Email ou senha não conferem!", Toast.LENGTH_SHORT).show();
        }
    }

    //função utilizada no botão Cadastre-se
    public void mostrarTelaCadastroParticipante(View view){
        Intent intent = new Intent(this, CadastroParticipante.class);

        startActivity(intent);
    }

    //função utilizada no botão Voltar
    public void partVoltarTelaInicial(View view){
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }
}