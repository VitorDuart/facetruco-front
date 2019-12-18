package com.utfpr.facetruco.services;

import javax.ws.rs.core.MediaType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.utfpr.facetruco.pojo.Usuario;
import com.sun.jersey.api.client.ClientResponse;

public class UsuarioService{
    private final String URI_BACKEND = Api.getURIBACKEND();
    private Client client;
    private final String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqc291emEifQ.e7PRgFUYxI5e3CSAIwIgMfepR1QpXnUxwPbEipPoqmF8LbsvutcDeuDIkaNdKmlSAfKUZtCaP2gD0eolcxDNXA";

    public UsuarioService(){ this.client = new Client();}

    public Boolean store(Usuario user){
        Gson gson = new Gson();
        String json = gson.toJson(user);
        ClientResponse response = this.client
            .resource(URI_BACKEND)
            .path("usuarios")
            .type(MediaType.APPLICATION_JSON)
            .post(ClientResponse.class, json);
        if(response.getStatus() != 201)
            return false;
        return true;     
    }

    public Usuario get(String username){
        Gson gson = new Gson();
        ClientResponse response = this.client
            .resource(URI_BACKEND)
            .path("usuarios/" + username)
            .header("Authorization", token)
            .get(ClientResponse.class);
        
        Usuario usuario = gson.fromJson(
            response.getEntity(String.class),
            Usuario.class
        );

        return usuario;
    }

    public List<Usuario> list(){
        Gson gson = new Gson();
        ClientResponse response = this.client
            .resource(URI_BACKEND)
            .path("usuarios/")
            .header("Authorization", token)
            .get(ClientResponse.class);
        
        Type listType = new TypeToken<ArrayList<Usuario>>(){}.getType();
        List<Usuario> users = gson.fromJson(
            response.getEntity(String.class),   
            listType
        );
        return users;
    }

    public Boolean delete(String username){
        // Gson gson = new Gson();
        ClientResponse response = this.client
            .resource(URI_BACKEND)
            .path("usuarios/" + username)
            .header("Authorization", token)
            .delete(ClientResponse.class);
        
        if(response.getStatus() != 201)
            return false;
        return true;
    }
}