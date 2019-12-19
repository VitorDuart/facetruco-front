package com.utfpr.facetruco.services;

import java.util.List;
import java.lang.reflect.Type;
import java.util.ArrayList;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.utfpr.facetruco.pojo.Request;
import com.utfpr.facetruco.util.SessionUtil;


public class SolicitacaoService{
    private final String URI_BACKEND = Api.getURIBACKEND();
    private Client client;
    private final String token = (String) SessionUtil.getParam("token");

    public SolicitacaoService(){ this.client = new Client();}

    public Boolean store(Request request){
        Gson gson = new Gson();
        
        String json = gson.toJson(request);
        ClientResponse response = this.client
            .resource(URI_BACKEND)
            .path("solicitacoes")
            .header("Authorization", token)
            .type(MediaType.APPLICATION_JSON)
            .post(ClientResponse.class, json);
        if(response.getStatus() != 201)
            return false;
        return true;    
    }
    
    public List<Request> list(String username){
        Gson gson = new Gson();
        ClientResponse response = this.client
            .resource(URI_BACKEND)
            .path("solicitacoes/" + username)
            .header("Authorization", token)
            .get(ClientResponse.class);
        Type listType = new TypeToken<ArrayList<Request>>(){}.getType();
        List<Request> requests = gson.fromJson(
            response.getEntity(String.class),
            listType
        );
        return requests;
    }

    public Boolean delete(Long id){
        ClientResponse response = this.client
            .resource(URI_BACKEND)
            .path("solicitacoes/" + id)
            .header("Authorization", token)
            .delete(ClientResponse.class);
       
        if(response.getStatus() != 201)
            return false;
        return true;
    }
}