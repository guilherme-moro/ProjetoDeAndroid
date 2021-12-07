package com.example.projetomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //função utilizada no botão de Logar como administrador
    public void mostrarTelaLoginAdm(View view){
        Intent intent = new Intent(this, LoginAdministrador.class);

        startActivity(intent);
    }

    //função utilizada no botão de Logar como participante
    public void mostrarTelaLoginParticipante(View view){
        Intent intent = new Intent(this, LoginParticipante.class);

        startActivity(intent);
    }
}