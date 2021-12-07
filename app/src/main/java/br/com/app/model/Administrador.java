package br.com.app.model;

public class Administrador {

    //atributos
    private String nome_adm;
    private String grupo_adm;
    private String email_adm;
    private String senha_adm;

    //construtores
    public Administrador() {
    }

    public Administrador(String _nomeAdm, String _grupoAdm, String _emailAdm, String _senhaAdm) {
        this.nome_adm = _nomeAdm;
        this.grupo_adm = _grupoAdm;
        this.email_adm = _emailAdm;
        this.senha_adm = _senhaAdm;
    }

    //getters e setters dos atributos do administrador
    public String getNome_adm() {
        return nome_adm;
    }
    public void setNome_adm(String nome_adm) {
        this.nome_adm = nome_adm;
    }

    public String getGrupo_adm() {
        return grupo_adm;
    }
    public void setGrupo_adm(String grupo_adm) {
        this.grupo_adm = grupo_adm;
    }

    public String getEmail_adm() {
        return email_adm;
    }
    public void setEmail_adm(String email_adm) {
        this.email_adm = email_adm;
    }

    public String getSenha_adm() {
        return senha_adm;
    }
    public void setSenha_adm(String senha_adm) {
        this.senha_adm = senha_adm;
    }
}
