package com.example.tutor2.ClasesTutor;

public class Eventos {
    private String codigoevento;
    private String codigotutor;
    private String tituloevento;
    private String lugarevento;
    private String curso;
    private String fechaevento;
    private String descripcion;
    private String horaevento;

    private String estado;

    public Eventos(){

    }

    public String getEstado() {
        return estado;
    }

    public String getCodigoevento() {
        return codigoevento;
    }

    public void setCodigoevento(String codigoevento) {
        this.codigoevento = codigoevento;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCodigotutor() {
        return codigotutor;
    }

    public void setCodigotutor(String codigotutor) {
        this.codigotutor = codigotutor;
    }

    public String getTituloevento() {
        return tituloevento;
    }

    public void setTituloevento(String tituloevento) {
        this.tituloevento = tituloevento;
    }

    public String getLugarevento() {
        return lugarevento;
    }

    public void setLugarevento(String lugarevento) {
        this.lugarevento = lugarevento;
    }

    public String getFechaevento() {
        return fechaevento;
    }

    public void setFechaevento(String fechaevento) {
        this.fechaevento = fechaevento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHoraevento() {
        return horaevento;
    }

    public void setHoraevento(String horaevento) {
        this.horaevento = horaevento;
    }
}
