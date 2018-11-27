package com.idestro.model;

public class User {

    private String name;
    private String passWord;
    private String phone;
    private String email;

    public void setName(String name) {
        this.name = name;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String mail) {
        this.email = mail;
    }

    public String getName() {
        return this.name;
    }

    public String getPassWord() {
        return this.passWord;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getEmail() {
        return this.email;
    }
}
