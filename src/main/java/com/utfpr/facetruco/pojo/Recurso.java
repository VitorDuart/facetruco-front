package com.utfpr.facetruco.pojo;


public class Recurso{
    private Long id;
    private String username;
    private String url;
    private String tipo;
    private Long postId;
    private Long albumId;

    public Recurso(){ }


    public Recurso(Long id, String username, String url, String tipo, Long postId, Long albumId) {
        this.username = username;
        this.url = url;
        this.tipo = tipo;
        this.postId = postId;
        this.albumId = albumId;
    }

    public String getUsername() { return this.username; }
    public String getUrl() { return this.url; }
    public String getTipo() { return this.tipo; }
    public Long getPostId() { return this.postId; }
    public Long getAlbumId() { return this.albumId; }
    public Long getId() { return this.id; }

    public void setUsername(String username) { this.username = username; }
    public void setUrl(String url) { this.url = url; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setPostId(Long postId) { this.postId = postId; }
    public void setAlbumId(Long albumId) { this.albumId = albumId; }
    public void setId(Long id) { this.id = id; }
}