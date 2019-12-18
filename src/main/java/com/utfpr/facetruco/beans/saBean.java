package com.utfpr.facetruco.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.utfpr.facetruco.pojo.Request;
import com.utfpr.facetruco.services.AmigoService;
import com.utfpr.facetruco.services.SolicitacaoService;

@ManagedBean(name = "saBean")
@RequestScoped
public class saBean{
    public void addAmigo(){
        AmigoService as = new AmigoService();
        Request request = new Request();
        request.setOrigin("eduarte");
        request.setTarget("psouza");
        as.store(request);
    }

    public void requestAmigo(){
        SolicitacaoService ss = new SolicitacaoService();
        Request r = new Request();
        r.setOrigin("psouza");
        r.setTarget("jsouza");
        ss.store(r);
    }
}