package com.tecleon;

public class User {
    
    private String userName;
    private String userPassword;
    private int id;
    private String type;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "UserDAO{" + "userName=" + userName + ", userPassword=" + userPassword + ", id=" + id + ", type=" + type + '}';
    }
    
    
}
