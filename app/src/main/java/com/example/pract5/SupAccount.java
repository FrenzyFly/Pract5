package com.example.pract5;

public class SupAccount {
    private final String email;
    private final String password;
    private final String phone;
    private final String name;

    public SupAccount(String email,
                               String password,
                               String phone) {
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.name = "";
    }

    public SupAccount(String email,
                               String password,
                               String phone,
                               String name) {
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.name = name;
    }

    public String getLogin() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }
}
