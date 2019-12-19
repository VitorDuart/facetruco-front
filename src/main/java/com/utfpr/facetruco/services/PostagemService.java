package com.utfpr.facetruco.services;

import java.util.List;
import java.lang.reflect.Type;
import java.util.ArrayList;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.utfpr.facetruco.pojo.Marcado;
import com.utfpr.facetruco.pojo.Postagem;
import com.utfpr.facetruco.util.SessionUtil;

public class PostagemService{
    private final String URI_BACKEND = Api.getURIBACKEND();
    private Client client;
    private final String token = (String) SessionUtil.getParam("token");

    public PostagemService(){ this.client = new Client();}

    public Boolean store(Postagem post){
        Gson gson = new Gson();
        String json = gson.toJson(post);
        ClientResponse response = this.client
            .resource(URI_BACKEND)
            .path("postagens")
            .header("Authorization", token)
            .type(MediaType.APPLICATION_JSON)
            .post(ClientResponse.class, json);
        if(response.getStatus() != 201)
            return false;
        return true;     
    }

    public List<Postagem> postagensUsuario(String username){
        Gson gson = new Gson();
        ClientResponse response = this.client
            .resource(URI_BACKEND)
            .path("postusuarios/" + username)
            .header("Authorization", token)
            .type(MediaType.APPLICATION_JSON)
            .get(ClientResponse.class);

        Type listType = new TypeToken<ArrayList<Postagem>>(){}.getType();
        List<Postagem> posts = gson.fromJson(
            response.getEntity(String.class),   
            listType
        );

        for (Postagem post : posts) {
            response = this.client
                .resource(URI_BACKEND)
                .path("marcados/" + post.getId())
                .header("Authorization", token)
                .type(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
            
            Marcado marcado = gson.fromJson(
                response.getEntity(String.class),   
                Marcado.class
            );
            post.setMarcados(marcado.getUsuarios());
        }
        return posts;
    }


    public List<Postagem> postagensAlbum(Long id){
        Gson gson = new Gson();
        ClientResponse response = this.client
            .resource(URI_BACKEND)
            .path("postalbuns/" + id)
            .header("Authorization", token)
            .type(MediaType.APPLICATION_JSON)
            .get(ClientResponse.class);

        Type listType = new TypeToken<ArrayList<Postagem>>(){}.getType();
        List<Postagem> posts = gson.fromJson(
            response.getEntity(String.class),   
            listType
        );

        return posts;
    }

    public Boolean delete(Long id){
        ClientResponse response = this.client
            .resource(URI_BACKEND)
            .path("postagens/" + id)
            .header("Authorization", token)
            .delete(ClientResponse.class);
        
        if(response.getStatus() != 201)
            return false;
        return true;
    }
}