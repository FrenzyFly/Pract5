package com.example.pract5.data.protocols;

import com.example.pract5.data.models.SinAccount;
import com.example.pract5.data.models.SupAccount;

public interface UserAccProtocol {
    boolean createAccount(SupAccount supAcc);

    boolean loginAccount(SinAccount sinAcc, boolean allowed);
}
