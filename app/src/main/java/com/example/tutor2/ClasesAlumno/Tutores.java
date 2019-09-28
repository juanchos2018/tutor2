package com.example.tutor2.ClasesAlumno;

public class Tutores {

    private String codigotutor;
    private String nombretutor;
    private int foto;

    public Tutores(String codigotutor, String nombretutor,int foto) {
        this.codigotutor = codigotutor;
        this.nombretutor = nombretutor;
        this.foto=foto;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getCodigotutor() {
        return codigotutor;
    }

    public void setCodigotutor(String codigotutor) {
        this.codigotutor = codigotutor;
    }

    public String getNombretutor() {
        return nombretutor;
    }

    public void setNombretutor(String nombretutor) {
        this.nombretutor = nombretutor;
    }
}
