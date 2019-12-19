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
    private String ano;
    private List<String> anos;

    public UserBean(){
        dia = "1";
        ano = "2000";
        dias = new ArrayList<>();
        anos = new ArrayList<>();
        for(int i = 1; i < 32; i++){
            dias.add(Integer.toString(i));
        }

        for(int i = 1960; i < 2020; i++){
            anos.add(Integer.toString(i));
        }

        meses = new ArrayList<>();
        meses.add(new Mes(1, "jan"));
        meses.add(new Mes(2, "fev"));
        meses.add(new Mes(3, "mar"));
        meses.add(new Mes(4, "abr"));
        meses.add(new Mes(5, "mai"));
        meses.add(new Mes(6, "jun"));
        meses.add(new Mes(7, "jul"));
        meses.add(new Mes(8, "ago"));
        meses.add(new Mes(9, "set"));
        meses.add(new Mes(10, "out"));
        meses.add(new Mes(11, "nov"));
        meses.add(new Mes(12, "dez"));
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


<<<<<<< HEAD
    public String getAno() {
        return this.ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public List<String> getAnos() {
        return this.anos;
    }

    public void setAnos(List<String> anos) {
        this.anos = anos;
    }

}
=======
}
>>>>>>> acca5e372d7f14b438d9f54c4c373229113d4123
