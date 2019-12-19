package com.utfpr.facetruco.pojo;


import java.util.List;

public class Album{
    private Long id;
    private String titulo;
    private String descricao;
    private String usuario;
    private List<String> colabs;

    public Album(){}

    public Album(Long id, String titulo, String descricao, String usuario) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.usuario = usuario;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public List<String> getColabs() {
        return this.colabs;
    }

    public void setColabs(List<String> colabs) {
        this.colabs = colabs;
    }
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}