package com.utfpr.facetruco.pojo;

public class Reacao{
    private Long id;
    private Long postId;
    private Long albumId;
    private Long commentId;
    private String reacao;
    private String username;

    public Reacao() { }
    
    public Reacao(Long id, Long postId, Long albumId, Long commentId, String reacao, String username) {
        this.id = id;
        this.postId = postId;
        this.albumId = albumId;
        this.commentId = commentId;
        this.reacao = reacao;
        this.username = username;
    }

    public Long getPostId() {
        return this.postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getReacao() {
        return this.reacao;
    }

    public void setReacao(String reacao) {
        this.reacao = reacao;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAlbumId() {
        return this.albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public Long getCommentId() {
        return this.commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }
}