package com.example.loginjsf4.modelo.bean;

import org.primefaces.event.SelectEvent;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoginBean {
    private String nombre;
    private String password;
    private Date fecha;

    private TipoUsuario tipo;
    private static List<TipoUsuario> tipos=new ArrayList<TipoUsuario>();
    public LoginBean() {
        tipos.add(new TipoUsuario(1,"estudiante"));
        tipos.add(new TipoUsuario(2,"profesor"));
    }
    public TipoUsuario getTipo() {
        return tipo;
    }
    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
        System.out.println("El tipo del usuario: "+tipo.getCodigo()+"/"+tipo.getTipoUsu());
    }
    public List<TipoUsuario> getTipos() {
        return tipos;
    }
    public void setTipos(List<TipoUsuario> tipos) {
        this.tipos = tipos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String comprobar() {
        if (nombre.length()!= password.length()){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error en el login, nombre y password deben tener la misma longitud"));
            return null;
        }
        if (nombre.equals("pirata")) {
            return "error";
        } else {
            return "ok";
        }
    }
    public void  onDateSelect(SelectEvent event){
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Fecha seleccionada: " + event.getObject()));
    }

    public static TipoUsuario getObject(String tipo) {
        for (TipoUsuario t: tipos){
            if (tipo.equals(t.getTipoUsu()))
                return t;}
        return null;
    }

    public void listener(AjaxBehaviorEvent event) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("El tipo del usuario:"+tipo.getCodigo()+"/"+tipo.getTipoUsu()));
    }

    public void onEventSelect(SelectEvent event) {
        this.tipo=(TipoUsuario)event.getObject();
        FacesContext.getCurrentInstance().addMessage("miForm:mensajes",
                new FacesMessage("El tipo del usuario (tabla):"+tipo.getCodigo()+"/"+tipo.getTipoUsu()));}
}


