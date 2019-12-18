package com.utfpr.facetruco.pojo;


public class Request{
    private Long id;
    private String target;
    private String origin;


    public Request() { }


    public Request(Long id, String target, String origin) {
        this.id = id;
        this.target = target;
        this.origin = origin;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTarget() {
        return this.target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

}