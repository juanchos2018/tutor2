package com.example.tutor2.Clases;

public class Tutores {

    private int foto;
    private String nombrecurso;
    private int cantutores;

    public Tutores(int foto, String nombrecurso, int cantutores) {
        this.foto = foto;
        this.nombrecurso = nombrecurso;
        this.cantutores = cantutores;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombrecurso() {
        return nombrecurso;
    }

    public void setNombrecurso(String nombrecurso) {
        this.nombrecurso = nombrecurso;
    }

    public int getCantutores() {
        return cantutores;
    }

    public void setCantutores(int cantutores) {
        this.cantutores = cantutores;
    }
}
