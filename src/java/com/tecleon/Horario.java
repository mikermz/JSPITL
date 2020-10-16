package com.tecleon;

public class Horario {

    private int idHorario;
    private String idClase;
    private String horLunes, salLunes, horMartes, salMartes, horMiercoles, salMiercoles,
            horJueves, salJueves, horViernes, salViernes;
    private String periodo;

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public String getIdClase() {
        return idClase;
    }

    public void setIdClase(String idClase) {
        this.idClase = idClase;
    }

    public String getHorLunes() {
        return horLunes;
    }

    public void setHorLunes(String horLunes) {
        this.horLunes = horLunes;
    }

    public String getSalLunes() {
        return salLunes;
    }

    public void setSalLunes(String salLunes) {
        this.salLunes = salLunes;
    }

    public String getHorMartes() {
        return horMartes;
    }

    public void setHorMartes(String horMartes) {
        this.horMartes = horMartes;
    }

    public String getSalMartes() {
        return salMartes;
    }

    public void setSalMartes(String salMartes) {
        this.salMartes = salMartes;
    }

    public String getHorMiercoles() {
        return horMiercoles;
    }

    public void setHorMiercoles(String horMiercoles) {
        this.horMiercoles = horMiercoles;
    }

    public String getSalMiercoles() {
        return salMiercoles;
    }

    public void setSalMiercoles(String salMiercoles) {
        this.salMiercoles = salMiercoles;
    }

    public String getHorJueves() {
        return horJueves;
    }

    public void setHorJueves(String horJueves) {
        this.horJueves = horJueves;
    }

    public String getSalJueves() {
        return salJueves;
    }

    public void setSalJueves(String salJueves) {
        this.salJueves = salJueves;
    }

    public String getHorViernes() {
        return horViernes;
    }

    public void setHorViernes(String horViernes) {
        this.horViernes = horViernes;
    }

    public String getSalViernes() {
        return salViernes;
    }

    public void setSalViernes(String salViernes) {
        this.salViernes = salViernes;
    }

    @Override
    public String toString() {
        return "Horario{" + "idHorario=" + idHorario + ", idClase=" + idClase + ", horLunes=" + horLunes + ", salLunes=" + salLunes + ", horMartes=" + horMartes + ", salMartes=" + salMartes + ", horMiercoles=" + horMiercoles + ", salMiercoles=" + salMiercoles + ", horJueves=" + horJueves + ", salJueves=" + salJueves + ", horViernes=" + horViernes + ", salViernes=" + salViernes + ", periodo=" + periodo + '}';
    }
  
}
