package com.tecleon;

public class Prof {

    private int idProf;
    private String nombreProf;
    private String apellidoProf;
    private String emailProf;
    private String passProf;
    private String puesto;

////    public Prof(int idProf, String nombreProf, String apellidoProf, String emailProf, String passProf, String puesto) {
////        this.idProf = idProf;
////        this.nombreProf = nombreProf;
////        this.apellidoProf = apellidoProf;
////        this.emailProf = emailProf;
////        this.passProf = passProf;
////        this.puesto = puesto;
////    }


    public int getIdProf() {
        return idProf;
    }

    public void setIdProf(int idProf) {
        this.idProf = idProf;
    }

    public String getNombreProf() {
        return nombreProf;
    }

    public void setNombreProf(String nombreProf) {
        this.nombreProf = nombreProf;
    }

    public String getApellidoProf() {
        return apellidoProf;
    }

    public void setApellidoProf(String apellidoProf) {
        this.apellidoProf = apellidoProf;
    }

    public String getEmailProf() {
        return emailProf;
    }

    public void setEmailProf(String emailProf) {
        this.emailProf = emailProf;
    }

    public String getPassProf() {
        return passProf;
    }

    public void setPassProf(String passProf) {
        this.passProf = passProf;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
        @Override
    public String toString() {
        return "Prof{" + "idProf=" + idProf + ", nombreProf=" + nombreProf + ", apellidoProf=" + apellidoProf + ", emailProf=" + emailProf + ", passProf=" + passProf + ", puesto=" + puesto + '}';
    }

}
