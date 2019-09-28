package com.example.tutor2.Clases;

import java.io.Serializable;

public class Notificacion   implements Serializable {
        private String nombrecurso;
        private String nombreestudainte;
        private String codigoestudiante;


    private String fecha;
    private String hora;
    private String lugar;


    public Notificacion(String nombrecurso, String nombreestudainte) {
        this.nombrecurso = nombrecurso;
        this.nombreestudainte = nombreestudainte;
    }

    public String getNombrecurso() {
        return nombrecurso;
    }

    public void setNombrecurso(String nombrecurso) {
        this.nombrecurso = nombrecurso;
    }

    public String getNombreestudainte() {
        return nombreestudainte;
    }

    public void setNombreestudainte(String nombreestudainte) {
        this.nombreestudainte = nombreestudainte;
    }

    public String getCodigoestudiante() {
        return codigoestudiante;
    }

    public void setCodigoestudiante(String codigoestudiante) {
        this.codigoestudiante = codigoestudiante;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
}
