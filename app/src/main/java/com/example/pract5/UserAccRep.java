package com.example.pract5;

import android.content.Context;

public class UserAccRep implements UserAccProtocol {

    private final UserRemDS userRemDS;

    public UserAccRep(Context context) {
        this.userRemDS = new UserRemDS(context);
    }

    @Override
    public boolean createAccount(SupAccount supAcc) {
        return userRemDS.checkRegistrationValid(supAcc);
    }

    @Override
    public boolean loginAccount(SinAccount sinAcc, boolean allowed) {
        return userRemDS.checkLoginValid(sinAcc, allowed);
    }
}
