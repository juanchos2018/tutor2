package com.example.tutor2.Clases;

import java.io.Serializable;

public class personaje implements Serializable {

    private String codigo;
    private String nombre;
    private int foto;

public  personaje(){

}
    public personaje(String codigo, String nombre, int foto) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.foto = foto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
