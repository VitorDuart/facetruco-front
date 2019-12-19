package com.utfpr.facetruco.pojo;

import java.util.List;

public class Marcado{
    private Long postId;
    private List<String> usuarios;

    public Marcado() { }

    public Marcado(Long postId, List<String> usuarios) {
        this.postId = postId;
        this.usuarios = usuarios;
    }

    public List<String> getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(List<String> usuarios) {
        this.usuarios = usuarios;
    }

    public Long getPostId() {
        return this.postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}