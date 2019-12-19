package com.utfpr.facetruco.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import com.utfpr.facetruco.pojo.Mes;
import com.utfpr.facetruco.pojo.Usuario;
import com.utfpr.facetruco.services.UsuarioService;


/**
 * @author vitor
 */

@ManagedBean(name = "userBean")
@RequestScoped
public class UserBean {
    @Inject
    private Usuario user;
    
    private List<String> dias;
    private String dia;

    private Mes mes;
    private List<Mes> meses;

    public UserBean(){
        dia = "1";
        dias = new ArrayList<>();
        for(int i = 1; i < 32; i++){
            dias.add(Integer.toString(i));
        }
        meses = new ArrayList<>();
        meses.add(new Mes(1, "jan"));
        meses.add(new Mes(2, "fev"));
    }

    public String store(){
        new UsuarioService().store(user);
        return "feeds";
    }



    public Usuario getUser() {return this.user;}
    public void setUser(Usuario user) {this.user = user;}
    public String getDia() {return this.dia;}

    public void setDia(String dia) {this.dia = dia;}
    public List<String> getDias() {return this.dias;}
    public void setDias(List<String> dias) {this.dias = dias;}


    public Mes getMes() {
        return this.mes;
    }

    public void setMes(Mes mes) {
        this.mes = mes;
    }

    public List<Mes> getMeses() {
        return this.meses;
    }

    public void setMeses(List<Mes> meses) {
        this.meses = meses;
    }

    public Mes getMes(Integer id) {
        if (id == null){
            throw new IllegalArgumentException("no id provided");
        }
        for (Mes mes : meses){
            if (id.equals(mes.getId())){
                return mes;
            }
        }
        return null;
    }


}
