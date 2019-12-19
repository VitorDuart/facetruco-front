package com.utfpr.facetruco.services;

import java.util.List;
import java.lang.reflect.Type;
import java.util.ArrayList;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.utfpr.facetruco.pojo.Album;
import com.utfpr.facetruco.pojo.Colaborador;
import com.utfpr.facetruco.util.SessionUtil;

public class AlbumService{
    private final String URI_BACKEND = Api.getURIBACKEND();
    private Client client;
    private final String token = (String) SessionUtil.getParam("token");

    public AlbumService(){ this.client = new Client();}

    public Boolean store(Album album){
        Gson gson = new Gson();
        String json = gson.toJson(album);
        ClientResponse response = this.client
            .resource(URI_BACKEND)
            .path("albuns")
            .header("Authorization", token)
            .type(MediaType.APPLICATION_JSON)
            .post(ClientResponse.class, json);
        if(response.getStatus() != 201)
            return false;
        return true;     
    }

    public List<Album> albunsUsuario(String username){
        Gson gson = new Gson();
        ClientResponse response = this.client
            .resource(URI_BACKEND)
            .path("albuns/" + username)
            .header("Authorization", token)
            .type(MediaType.APPLICATION_JSON)
            .get(ClientResponse.class);

        Type listType = new TypeToken<ArrayList<Album>>(){}.getType();
        List<Album> albuns = gson.fromJson(
            response.getEntity(String.class),   
            listType
        );

        for (Album album : albuns) {
            response = this.client
                .resource(URI_BACKEND)
                .path("colabs/" + album.getId())
                .header("Authorization", token)
                .type(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
            
            Colaborador colab = gson.fromJson(
                response.getEntity(String.class),   
                Colaborador.class
            );
            album.setColabs(colab.getColabs());
        }
        return albuns;
    }

    public Boolean delete(Long id){
        ClientResponse response = this.client
            .resource(URI_BACKEND)
            .path("albuns/" + id)
            .header("Authorization", token)
            .delete(ClientResponse.class);
        
        if(response.getStatus() != 201)
            return false;
        return true;
    }
}