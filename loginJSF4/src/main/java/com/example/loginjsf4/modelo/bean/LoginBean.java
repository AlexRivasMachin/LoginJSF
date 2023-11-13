package com.example.loginjsf4.modelo.bean;

import java.util.Date;

public class LoginBean {
    private String nombre;
    private String password;
    private Date fecha;

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
        System.out.println("ha llegado al bean");
        if (nombre.equals("pirata")) {
            System.out.println("Devolviendo error");
            return "error";
        } else {
            System.out.println("devolviendo ok");
            return "ok";
        }
    }
}

