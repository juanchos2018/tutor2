package com.example.tutor2.Clases;

public class cursotutor {

    private String codigotutor;
    private String curso;


    public cursotutor() {

    }


    public cursotutor( String curso) {

        this.curso = curso;
    }

    public String getCodigotutor() {
        return codigotutor;
    }

    public void setCodigotutor(String codigotutor) {
        this.codigotutor = codigotutor;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
