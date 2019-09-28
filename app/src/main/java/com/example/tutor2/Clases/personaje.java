package com.example.tutor2.Clases;

import java.io.Serializable;

public class personaje implements Serializable {

    private String codigo;
    private String nombre;
    private String apellido;
    private String telefono;
    private String ciclo;
    private String clave;
    private String canctursos;
    private int foto;


public  personaje(){

}
    public personaje(String codigo, String nombre, int foto) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.foto = foto;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCanctursos() {
        return canctursos;
    }

    public void setCanctursos(String canctursos) {
        this.canctursos = canctursos;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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
