package com.example.pract5.data.repositories;

import android.content.Context;

import com.example.pract5.data.datasource.UserRemDS;
import com.example.pract5.data.protocols.UserAccProtocol;
import com.example.pract5.data.models.SinAccount;
import com.example.pract5.data.models.SupAccount;

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
