package com.utfpr.facetruco.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.utfpr.facetruco.pojo.Album;
import com.utfpr.facetruco.pojo.Comentario;
import com.utfpr.facetruco.pojo.Postagem;
import com.utfpr.facetruco.pojo.Reacao;
import com.utfpr.facetruco.pojo.Request;
import com.utfpr.facetruco.pojo.Usuario;
import com.utfpr.facetruco.services.AlbumService;
import com.utfpr.facetruco.services.AmigoService;
import com.utfpr.facetruco.services.ComentarioService;
import com.utfpr.facetruco.services.PostagemService;
import com.utfpr.facetruco.services.ReacaoService;
import com.utfpr.facetruco.services.SolicitacaoService;
import com.utfpr.facetruco.services.UsuarioService;

@RequestScoped
@ManagedBean(name = "testeBean")
public class TesteBean{
    private List<Usuario> usuarios;
    private List<Postagem> postUsers;
    private List<Postagem> postAlbum;
    private List<String> amigos;
    private List<Request> requests;
    private List<Comentario> comments;
    private Long countC;
    private List<Reacao> reacoes;
    private Long numReacoes;
    private List<Album> albuns;

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

    public void amigosUsuario(){
        List<String> amigos = new AmigoService().amigosUsuario("eduarte").getAmigos();
        this.amigos = amigos;
    }

    public void removerAmigo(){
        new AmigoService().delete("eduarte", "eduarte");
    }

    public void solicitacoes(){
        List<Request> requests = new SolicitacaoService().list("eduarte");
        this.requests = requests;
    }

    public void removerSolicitacao(){
        new SolicitacaoService().delete(new Long("30"));
    }

    public void criarComentario(){
        Comentario comment = new Comentario();
        comment.setPostId(new Long("2"));
        comment.setUsername("eduarte");
        comment.setComentario("MEME DO TOM");
        comment.setRecurso("memetom.jpg");

        new ComentarioService().store(comment);
    }

    public void listarComentarios(){
        this.comments = new ComentarioService().list(new Long("2"), "postagem");
    }

    public void removerComentario(){
        new ComentarioService().delete(new Long("3"));
    }

    public void countComentarios(){
        this.countC = new ComentarioService().countComentarios(new Long("2"), "postagem");
    }

    public void criarReacao(){
        Reacao reacao = new Reacao();
        reacao.setPostId(new Long("2"));
        reacao.setUsername("eduarte");
        reacao.setReacao("UAU");

        new ReacaoService().store(reacao);
    }

    public void listarReacoes(){
        this.reacoes = new ReacaoService().list(new Long("2"), "postagem");
    }
    
    public void countReacoes(){
        this.numReacoes = new ReacaoService().countReacoes(new Long("37"), "postagem");
    }

    public void removerReacao(){
        new ReacaoService().delete(new Long("34"));
    }

    public void criarAlbum(){
        List<String> users = new ArrayList<>();
        users.add("psouza");
        users.add("jsouza");
        Album album = new Album();
        album.setUsuario("eduarte");
        album.setTitulo("Termino de semestre");
        album.setDescricao("horas antes de apresentar seminários");
        album.setColabs(users);

        new AlbumService().store(album);
    }

    public void listarAlbuns(){
        this.albuns = new AlbumService().albunsUsuario("eduarte");
    }

    public void removerAlbum(){
        new AlbumService().delete(new Long("7"));
    }

    // GET AND SET
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

    public List<String> getAmigos() {
        return this.amigos;
    }

    public void setAmigos(List<String> amigos) {
        this.amigos = amigos;
    }

    public List<Request> getRequests() {
        return this.requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }


    public List<Comentario> getComments() {
        return this.comments;
    }

    public void setComments(List<Comentario> comments) {
        this.comments = comments;
    }


    public Long getCountC() {
        return this.countC;
    }

    public void setCountC(Long countComentarios) {
        this.countC = countComentarios;
    }

    public List<Reacao> getReacoes() {
        return this.reacoes;
    }

    public void setReacoes(List<Reacao> reacoes) {
        this.reacoes = reacoes;
    }


    public Long getNumReacoes() {
        return this.numReacoes;
    }

    public void setNumReacoes(Long numReacoes) {
        this.numReacoes = numReacoes;
    }
    
    public List<Album> getAlbuns() {
        return this.albuns;
    }

    public void setAlbuns(List<Album> albuns) {
        this.albuns = albuns;
    }

}