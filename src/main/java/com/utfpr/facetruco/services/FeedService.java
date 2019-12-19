package com.utfpr.facetruco.services;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.utfpr.facetruco.pojo.Postagem;
import com.utfpr.facetruco.util.SessionUtil;
import com.sun.jersey.api.client.ClientResponse;

public class FeedService{
    private final String URI_BACKEND = Api.getURIBACKEND();
    private Client client;
    private final String token = (String) SessionUtil.getParam("token");

    public FeedService(){ this.client = new Client();}

    public List<Postagem> list(String username){
        Gson gson = new Gson();
        ClientResponse response = this.client
            .resource(URI_BACKEND)
            .path("feeds/" + username)
            .header("Authorization", token)
            .get(ClientResponse.class);
        
        Type listType = new TypeToken<ArrayList<Postagem>>(){}.getType();
        List<Postagem> posts = gson.fromJson(
            response.getEntity(String.class),   
            listType
        );
        return posts;
    }

}