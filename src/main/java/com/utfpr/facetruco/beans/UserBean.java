package com.utfpr.facetruco.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import com.utfpr.facetruco.pojo.User;

/**
 * @author vitor
 */

@ManagedBean(name = "userBean")
@RequestScoped
public class UserBean {
    @Inject
    private User user;
    private String dia;
    private List<String> dias;

    public UserBean(){
        this.dias = new ArrayList<>();
        for(int i=1; i<31; i++){
            this.dias.add(i-1,i+"");
        }

        this.dia = this.dias.get(0);
    }


    public User getUser() {return this.user;}
    public void setUser(User user) {this.user = user;}
    public String getDia() {return this.dia;}
    public void setDia(String dia) {this.dia = dia;}
    public List<String> getDias() {return this.dias;}
    public void setDias(List<String> dias) {this.dias = dias;}

}