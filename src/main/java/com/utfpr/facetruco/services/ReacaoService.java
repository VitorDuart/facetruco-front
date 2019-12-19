package com.utfpr.facetruco.services;

import java.util.List;
import java.lang.reflect.Type;
import java.util.ArrayList;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.utfpr.facetruco.pojo.Reacao;
import com.utfpr.facetruco.util.SessionUtil;


public class ReacaoService{
    private final String URI_BACKEND = Api.getURIBACKEND();
    private Client client;
    private final String token = (String) SessionUtil.getParam("token");

    public ReacaoService(){ this.client = new Client(); }

    public Boolean store(Reacao react){
        Gson gson = new Gson();

        String json = gson.toJson(react);
        ClientResponse response = this.client
            .resource(URI_BACKEND)
            .path("/reacoes")
            .header("Authorization", token)
            .type(MediaType.APPLICATION_JSON)
            .post(ClientResponse.class, json);
        if(response.getStatus() != 201)
            return false;
        return true;    
    }
    
    public List<Reacao> list(Long id, String target){
        Gson gson = new Gson();
        ClientResponse response = this.client
            .resource(URI_BACKEND)
            .path("reaclists/" + id + "/" + target)
            .header("Authorization", token)
            .get(ClientResponse.class);
        Type listType = new TypeToken<ArrayList<Reacao>>(){}.getType();
        List<Reacao> reacoes = gson.fromJson(
            response.getEntity(String.class),
            listType
        );
        return reacoes;
    }

    public Long countReacoes(Long id, String target){
        Gson gson = new Gson();
        ClientResponse response = this.client
            .resource(URI_BACKEND)
            .path("countreacoes/" + id + "/" + target)
            .header("Authorization", token)
            .get(ClientResponse.class);
        Long count = gson.fromJson(
            response.getEntity(String.class),
            Long.class
        );
        return count;
    }

    public Boolean delete(Long id){
        ClientResponse response = this.client
            .resource(URI_BACKEND)
            .path("reacoes/" + id)
            .header("Authorization", token)
            .delete(ClientResponse.class);
       
        if(response.getStatus() != 201)
            return false;
        return true;
    }
}