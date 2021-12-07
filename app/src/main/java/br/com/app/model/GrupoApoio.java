package br.com.app.model;

public class GrupoApoio {

    //atributos
    private String nome_grupo;
    private String foco_grupo;
    private String dia_grupo;
    private String horario_grupo;
    private String estado_grupo;
    private String cidade_grupo;
    private String link_grupo;

    //construtores
    public GrupoApoio() {
    }

    public GrupoApoio(String _nomeGrupo, String _focoGrupo, String _diaGrupo, String _horarioGrupo, String _estadoGrupo, String _cidadeGrupo, String _linkGrupo) {
        this.nome_grupo = _nomeGrupo;
        this.foco_grupo = _focoGrupo;
        this.dia_grupo = _diaGrupo;
        this.horario_grupo = _horarioGrupo;
        this.estado_grupo = _estadoGrupo;
        this.cidade_grupo = _cidadeGrupo;
        this.link_grupo = _linkGrupo;
    }

    //getters e setters dos atributos do grupo de apoio
    public String getNome_grupo() {
        return nome_grupo;
    }
    public void setNome_grupo(String nome_grupo) {
        this.nome_grupo = nome_grupo;
    }

    public String getFoco_grupo() {
        return foco_grupo;
    }
    public void setFoco_grupo(String foco_grupo) {
        this.foco_grupo = foco_grupo;
    }

    public String getDia_grupo() {
        return dia_grupo;
    }
    public void setDia_grupo(String dia_grupo) {
        this.dia_grupo = dia_grupo;
    }

    public String getHorario_grupo() {
        return horario_grupo;
    }
    public void setHorario_grupo(String horario_grupo) {
        this.horario_grupo = horario_grupo;
    }

    public String getEstado_grupo() {
        return estado_grupo;
    }
    public void setEstado_grupo(String estado_grupo) {
        this.estado_grupo = estado_grupo;
    }

    public String getCidade_grupo() {
        return cidade_grupo;
    }
    public void setCidade_grupo(String cidade_grupo) {
        this.cidade_grupo = cidade_grupo;
    }

    public String getLink_grupo() {
        return link_grupo;
    }
    public void setLink_grupo(String link_grupo) {
        this.link_grupo = link_grupo;
    }
}

