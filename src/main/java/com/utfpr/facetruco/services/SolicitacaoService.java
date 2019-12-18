package com.utfpr.facetruco.services;

import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.utfpr.facetruco.pojo.Request;


public class SolicitacaoService{
    private final String URI_BACKEND = Api.getURIBACKEND();
    private Client client;
    private final String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqc291emEifQ.e7PRgFUYxI5e3CSAIwIgMfepR1QpXnUxwPbEipPoqmF8LbsvutcDeuDIkaNdKmlSAfKUZtCaP2gD0eolcxDNXA";

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
}