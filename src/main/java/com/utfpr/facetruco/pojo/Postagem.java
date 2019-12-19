package com.utfpr.facetruco.pojo;

import java.util.List;

public class Postagem{
    private Long id;
    private Long albumId;
    private String legenda;
    private String sentimento;
    private String username;
    private String timestamp;
    private List<String> marcados;

    public Postagem() {}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLegenda() {
        return this.legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

    public String getSentimento() {
        return this.sentimento;
    }

    public void setSentimento(String sentimento) {
        this.sentimento = sentimento;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getAlbumId() {
        return this.albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public List<String> getMarcados() {
        return this.marcados;
    }

    public void setMarcados(List<String> marcados) {
        this.marcados = marcados;
    }

}