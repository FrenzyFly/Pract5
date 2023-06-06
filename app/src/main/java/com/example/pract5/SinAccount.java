package com.example.pract5;

public class SinAccount {
    private final String login;
    private final String password;

    public SinAccount(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
