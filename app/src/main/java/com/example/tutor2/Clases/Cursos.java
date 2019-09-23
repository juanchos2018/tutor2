package com.example.tutor2.Clases;

public class Cursos {

    private String codigocurso;
    private String nomnrecurso;
    private int fotocurso;


    public Cursos(String codigocurso, String nomnrecurso, int fotocurso) {
        this.codigocurso = codigocurso;
        this.nomnrecurso = nomnrecurso;
        this.fotocurso = fotocurso;
    }

    public String getCodigocurso() {
        return codigocurso;
    }

    public void setCodigocurso(String codigocurso) {
        this.codigocurso = codigocurso;
    }

    public String getNomnrecurso() {
        return nomnrecurso;
    }

    public void setNomnrecurso(String nomnrecurso) {
        this.nomnrecurso = nomnrecurso;
    }

    public int getFotocurso() {
        return fotocurso;
    }

    public void setFotocurso(int fotocurso) {
        this.fotocurso = fotocurso;
    }
}
