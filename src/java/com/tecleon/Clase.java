package com.tecleon;

public class Clase {
    private String idClase;
    private int idProfe;
    private String idMateria;
    private int numAlumnos;
    private String grupo;

    @Override
    public String toString() {
        return "Clase{" + "idClase=" + idClase + ", idProfe=" + idProfe + ", idMateria=" + idMateria + ", numAlumnos=" + numAlumnos + ", grupo=" + grupo + '}';
    }

    public String getIdClase() {
        return idClase;
    }

    public void setIdClase(String idClase) {
        this.idClase = idClase;
    }

    public int getIdProfe() {
        return idProfe;
    }

    public void setIdProfe(int idProfe) {
        this.idProfe = idProfe;
    }

    public String getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(String idMateria) {
        this.idMateria = idMateria;
    }

    public int getNumAlumnos() {
        return numAlumnos;
    }

    public void setNumAlumnos(int numAlumnos) {
        this.numAlumnos = numAlumnos;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

}
