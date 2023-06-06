package com.example.pract5;

public interface UserAccProtocol {
    boolean createAccount(SupAccount supAcc);

    boolean loginAccount(SinAccount sinAcc, boolean allowed);
}
