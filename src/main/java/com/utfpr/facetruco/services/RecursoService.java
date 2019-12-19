package com.utfpr.facetruco.services;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.MediaType;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.utfpr.facetruco.pojo.Recurso;
import com.utfpr.facetruco.util.SessionUtil;
import com.sun.jersey.api.client.ClientResponse;
import com.google.gson.reflect.TypeToken;

public class RecursoService{
    private final String URI_BACKEND = Api.getURIBACKEND();
    private Client client;
    private final String token = (String) SessionUtil.getParam("token");

    public RecursoService(){ this.client = new Client();}

    public Boolean store(Recurso recurso){        
        Gson gson = new Gson();
        String json = gson.toJson(recurso);
        ClientResponse response = this.client
            .resource(URI_BACKEND)
            .path("recursos")
            .header("Authorization", token)
            .type(MediaType.APPLICATION_JSON)
            .post(ClientResponse.class, json);
        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, Integer.toString(response.getStatus()),""));
        if(response.getStatus() != 201)
            return false;
        return true;
    }

    public List<Recurso> listRecursos(Long postId, String target){
        Gson gson = new Gson();
        ClientResponse response = this.client
            .resource(URI_BACKEND)
            .path("reclists/" + postId + "/" + target)
            .header("Authorization", token)
            .get(ClientResponse.class);

        Type listType = new TypeToken<ArrayList<Recurso>>(){}.getType();
        List<Recurso> recursos = gson.fromJson(
            response.getEntity(String.class),   
            listType
        );
    
        return recursos;
    }

    public Boolean delete(Long id){
        ClientResponse response = this.client
            .resource(URI_BACKEND)
            .path("recursos/" + id)
            .header("Authorization", token)
            .delete(ClientResponse.class);
        
        if(response.getStatus() != 201)
            return false;
        return true;
    }
}