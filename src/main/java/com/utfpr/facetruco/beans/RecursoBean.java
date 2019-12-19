package com.utfpr.facetruco.beans;


import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import com.amazonaws.services.s3.model.ObjectMetadata;
import com.utfpr.facetruco.pojo.Recurso;
import com.utfpr.facetruco.services.RecursoService;
import com.utfpr.facetruco.services.S3Service;
import com.utfpr.facetruco.util.Token;

@RequestScoped
@ManagedBean(name = "recursoBean")
public class RecursoBean {
    private Part file;
    private List<Recurso> recursos;

    public void uploadRecurso () throws IOException{ 
        FacesContext context = FacesContext.getCurrentInstance();
        S3Service s3 = new S3Service();
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(file.getContentType());

        String nameFile  = Token.generateToken("jsouza") + "_" + file.getSubmittedFileName();

        s3.uploadMedia(nameFile, file.getInputStream(), metadata);
        s3.getObjectURL(nameFile);
       
        RecursoService rs = new RecursoService();
        Recurso r = new Recurso();
        r.setUrl(s3.getObjectURL(nameFile));
        r.setUsername("eduarte");
        r.setTipo(file.getContentType());
        r.setPostId(new Long("2"));
        Boolean res = rs.store(r);/* rs.store(new Recurso(
            "jsouza",
            s3.getObjectURL(nameFile),
            file.getContentType(),
            new Long("4"))
        ); */
        if(!res)
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não foi possível carregar media",""));
    }

    public void getRecursosPost(){
        FacesContext context = FacesContext.getCurrentInstance();
        RecursoService rs = new RecursoService();
        List<Recurso> recursos = rs.listRecursos(new Long("2"), "postagem");
        this.recursos = recursos;
    }

    public void removerRecurso(){
        new RecursoService().delete(new Long("5"));
    }
     
    public Part getFile() {
        return file;
    }
    public void setFile(Part arquivo) {
        this.file = arquivo;
    }

    public List<Recurso> getRecursos() {
        return this.recursos;
    }

    public void setRecursos(List<Recurso> recursos) {
        this.recursos = recursos;
    }
    
}
 