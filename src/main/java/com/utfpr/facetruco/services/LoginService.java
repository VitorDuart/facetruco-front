package com.utfpr.facetruco.services;

import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import com.utfpr.facetruco.pojo.Login;
import com.utfpr.facetruco.pojo.UserLogged;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

/**
 * @author vitor
 */

public class LoginService{
    private final String URI_BACKEND = Api.getURIBACKEND();
    
    private Client client;

    public LoginService (){this.client = new Client();}

    public UserLogged login(Login log){
        Gson gson = new Gson();

        String json = gson.toJson(log);
        ClientResponse response = this.client
            .resource(URI_BACKEND)
            .path("login")
            .type(MediaType.APPLICATION_JSON)
            .post(ClientResponse.class, json);
        
        if (response.getStatus() != 200)
            return null;
        
        UserLogged user = gson.fromJson(
            response.getEntity(String.class),
            UserLogged.class
        );

        return user;
    }
}