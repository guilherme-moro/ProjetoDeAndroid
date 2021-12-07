package br.com.app.model;

public class Participante {

    //atributos
    private String nome;
    private String id;
    private String email;
    private String senha;


    //construtores
    public Participante() {
    }

    public Participante(String _nome, String _id, String _email, String _senha) {
        this.nome = _nome;
        this.id = _id;
        this.email = _email;
        this.senha = _senha;
    }


    //getters e setters dos atributos do participante
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }


}
