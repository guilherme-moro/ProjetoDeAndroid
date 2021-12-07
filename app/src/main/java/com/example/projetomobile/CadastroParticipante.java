package com.example.projetomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.app.dao.ParticipanteDAO;
import br.com.app.model.Participante;

public class CadastroParticipante extends AppCompatActivity {

    EditText editTextNome, editTextID, editTextEmail, editTextSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_participante);
        editTextNome = (EditText) findViewById(R.id.editTextNome);
        editTextID = (EditText) findViewById(R.id.editTextID);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextSenha = (EditText) findViewById(R.id.editTextSenha);
    }

    public void cadastrarParticipante (View v) {

        //verifica se algum campo de cadastro está vazio e se tiver retorna uma mensagem para preencher
        if (editTextNome.getText().toString().equals("") || editTextID.getText().toString().equals("") ||
                editTextEmail.getText().toString().equals("") || editTextSenha.getText().toString().equals("")) {
            Toast.makeText(CadastroParticipante.this, "Todos os campos de cadastro devem ser preenchidos. Tente novamente!", Toast.LENGTH_SHORT).show();
        } else { //campos não ficaram vazios

            Participante participante = new Participante();
            ParticipanteDAO participanteDAO = new ParticipanteDAO(this);

            //preenche dados do participante
            participante.setNome(editTextNome.getText().toString());
            participante.setId(editTextID.getText().toString());
            participante.setEmail(editTextEmail.getText().toString());
            participante.setSenha(editTextSenha.getText().toString());

            //insere no banco de dados
            participanteDAO.gravarParticipante(participante);

            //mostra a mensagem de sucesso de cadastro e vai para a tela de login
            Toast.makeText(CadastroParticipante.this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, LoginParticipante.class);
            startActivity(intent);

        }
    }

    //função utilizada no botão Voltar
    public void voltarTelaLoginParticipante(View view){
        Intent intent = new Intent(this, LoginParticipante.class);

        startActivity(intent);
    }
}