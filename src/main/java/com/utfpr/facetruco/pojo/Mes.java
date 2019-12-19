package com.utfpr.facetruco.pojo;



public class Mes{
    private Integer id;
    private String mes;


    public Mes(Integer id, String mes) {
        this.id = id;
        this.mes = mes;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMes() {
        return this.mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

}