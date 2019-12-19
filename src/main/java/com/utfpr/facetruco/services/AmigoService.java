package com.utfpr.facetruco.services;

import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.utfpr.facetruco.pojo.Request;
import com.utfpr.facetruco.util.SessionUtil;
import com.utfpr.facetruco.pojo.Amigo;

public class AmigoService{
    private final String URI_BACKEND = Api.getURIBACKEND();
    private Client client;
    private final String token = (String) SessionUtil.getParam("token");

    public AmigoService(){ this.client = new Client();}

    public Boolean store(Request request){
        Gson gson = new Gson();
        
        String json = gson.toJson(request);
        ClientResponse response = this.client
            .resource(URI_BACKEND)
            .path("amigos")
            .header("Authorization", token)
            .type(MediaType.APPLICATION_JSON)
            .post(ClientResponse.class, json);
        if(response.getStatus() != 201)
            return false;
        return true;     
    }

    public Amigo amigosUsuario(String username){
        Gson gson = new Gson();
        ClientResponse response = this.client
            .resource(URI_BACKEND)
            .path("amigos/" + username)
            .header("Authorization", token)
            .type(MediaType.APPLICATION_JSON)
            .get(ClientResponse.class);

        
        Amigo amigos = gson.fromJson(
            response.getEntity(String.class),   
            Amigo.class
        );
        return amigos;
    }

    public Boolean delete(String logged, String target){
        ClientResponse response = this.client
            .resource(URI_BACKEND)
            .path("amigos/" + logged + "/" + target)
            .header("Authorization", token)
            .delete(ClientResponse.class);
        
        if(response.getStatus() != 201)
            return false;
        return true;
    }
}