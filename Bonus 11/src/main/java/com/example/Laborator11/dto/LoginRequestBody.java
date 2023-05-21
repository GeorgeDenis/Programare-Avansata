package com.example.Laborator11.dto;

public class LoginRequestBody {
    private String name;
    private String password;
    public LoginRequestBody() {
    }

    public LoginRequestBody(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }



}
