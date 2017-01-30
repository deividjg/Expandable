package com.example.david.expandable;

import java.io.Serializable;

/**
 * Created by David on 02/12/2016.
 */

public class Alumno implements Serializable {

    private static final long serialVersionUID = 1L;
    private long id;
    private String nombre, grupo;

    public Alumno(long id, String nombre, String grupo){
        this.id = id;
        this.nombre = nombre;
        this.grupo = grupo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

}
