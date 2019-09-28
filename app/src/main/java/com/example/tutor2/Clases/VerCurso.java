package com.example.tutor2.Clases;

public class VerCurso {

    private String nombrecurso;
    private int fotocurso;

    public VerCurso(String nombrecurso, int fotocurso) {
        this.nombrecurso = nombrecurso;
        this.fotocurso = fotocurso;
    }

    public String getNombrecurso() {
        return nombrecurso;
    }

    public void setNombrecurso(String nombrecurso) {
        this.nombrecurso = nombrecurso;
    }

    public int getFotocurso() {
        return fotocurso;
    }

    public void setFotocurso(int fotocurso) {
        this.fotocurso = fotocurso;
    }
}
