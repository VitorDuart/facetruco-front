package com.utfpr.facetruco.pojo;


/**
 * @author vitor
 */

public class User{
    private String name;
    
    public User(){
        this.name = "Vitor";
    }

    public String getName(){return this.name;}
    public void setName(String name){ this.name=name;}
}