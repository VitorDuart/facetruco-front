package com.utfpr.facetruco.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.utfpr.facetruco.pojo.Postagem;
import com.utfpr.facetruco.pojo.Usuario;
import com.utfpr.facetruco.services.PostagemService;
import com.utfpr.facetruco.services.UsuarioService;

@RequestScoped
@ManagedBean(name = "testeBean")
public class TesteBean{
    private List<Usuario> usuarios;
    private List<Postagem> postUsers;
    private List<Postagem> postAlbum;

    public String cadastroUsuario(){
        Usuario user = new Usuario();

        user.setNome("Nathalie");
        user.setSobrenome("Martins");
        user.setUsername("nath");
        user.setEmail("nathalie@gmail.com");
        user.setSenha("1234");
        user.setGenero("fe");
        user.setDataNascimento("1997-04-17");
        user.setFotoPerfil("nathalie");
        user.setFotoTimeline("nathalie");

        new UsuarioService().store(user);
        return null;
    }

    public String listarUsuarios(){
        List<Usuario> users = new UsuarioService().list();
        this.usuarios = users;
        return null;
    }

    public String deleteUsuario(){
        new UsuarioService().delete("nath");
        return null;
    }

    public String criarPostagem(){
        Postagem post =  new Postagem();

        post.setLegenda("Teste com o front");
        post.setSentimento("Teste com o front");
        post.setUsername("eduarte");

        Boolean a = new PostagemService().store(post);
        if(a) System.out.println("SIM"); else System.out.println("NÃO"); 
        return null;
    }

    public String postagensUsuario(){
        List<Postagem> post = new PostagemService().postagensUsuario("eduarte");
        this.postUsers = post;

        return null;
    }

    public String postagensAlbum(){
        List<Postagem> post = new PostagemService().postagensAlbum(new Long("7"));
        this.postAlbum = post;

        return null;
    }

    public String deletePostagem(){
        new PostagemService().delete(new Long("27"));
        return null;
    }

    public List<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(List<Usuario> usuario) {
        this.usuarios = usuario;
    }


    public List<Postagem> getPostUsers() {
        return this.postUsers;
    }

    public void setPostUsers(List<Postagem> postUsers) {
        this.postUsers = postUsers;
    }


    public List<Postagem> getPostAlbum() {
        return this.postAlbum;
    }

    public void setPostAlbum(List<Postagem> postAlbum) {
        this.postAlbum = postAlbum;
    }

}