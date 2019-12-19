package com.utfpr.facetruco.pojo;


public class Request{
    private Long id;
    private String target;
    private String origin;
    private Boolean visualizada;


    public Request() { }

    public Request(Long id, String target, String origin, Boolean visualizada) {
        this.id = id;
        this.target = target;
        this.origin = origin;
        this.visualizada = visualizada;
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


    public Boolean isVisualizada() {
        return this.visualizada;
    }

    public Boolean getVisualizada() {
        return this.visualizada;
    }

    public void setVisualizada(Boolean visualizada) {
        this.visualizada = visualizada;
    }
}