package com.tecleon;

public class Student {

    private String studentName;
    private int controlNum;
    private String carrer;
    private int semester;
    private String email;

    public String getCarrer() {
        return carrer;
    }

    public void setCarrer(String carrer) {
        this.carrer = carrer;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String name) {
        this.studentName = name;
    }

    public int getControlNum() {
        return controlNum;
    }

    public void setControlNum(int controlNum) {
        this.controlNum = controlNum;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + studentName + ", controlNum=" + controlNum + ", carrer=" + carrer + ", semester=" + semester + ", email=" + email + '}';
    }

}
