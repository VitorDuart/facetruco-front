package com.utfpr.facetruco.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import com.utfpr.facetruco.pojo.Login;
import com.utfpr.facetruco.pojo.UserLogged;
import com.utfpr.facetruco.services.LoginService;


/**
 * @author vitor
 */

@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean {
    @Inject
    private Login log;
    private UserLogged user;
    
    @Inject
    private LoginService logService;

    public String loginho(){
        this.user = this.logService.login(log);        
        if (this.user == null)
            return "index"; 
        return "feeds";
    }

    public Login getLog() {return this.log;}
    public void setLog(Login log) {this.log = log;}

    public UserLogged getUser() {return this.user;}
    public void setUser(UserLogged user) {this.user = user;}

    public LoginService getLogService() {return this.logService;}
    public void setLogService(LoginService logService) {this.logService = logService;}
}