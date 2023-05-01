package com.example.pract5.data.models;

public class SupAccount {
    private final String login;
    private final String password;
    private final String email;
    private final String phone;
    private final String name;
    private final String surname;

    public SupAccount(String login,
                               String password,
                               String email,
                               String phone) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.name = "";
        this.surname = "";
    }

    public SupAccount(String login,
                               String password,
                               String email,
                               String phone,
                               String name,
                               String surname) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.name = name;
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
