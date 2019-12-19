package com.utfpr.facetruco.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.utfpr.facetruco.pojo.Reacao;
import com.utfpr.facetruco.services.ReacaoService;



/**
 * @author vitor
 */

@ManagedBean(name = "reactionBean")
@RequestScoped
public class ReactionBean {


   
    public void react(String reacao){
        Reacao r = new Reacao();
        r.setPostId(new Long(2));
        r.setUsername("eduarte");
        r.setReacao(reacao);

        new ReacaoService().store(r);
    }
}