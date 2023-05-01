package com.example.pract5.ui.stateholder.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.pract5.data.models.SupAccount;
import com.example.pract5.data.protocols.UserAccProtocol;
import com.example.pract5.data.repositories.UserAccRep;

public class SupVmod extends AndroidViewModel {

    private final UserAccProtocol repository = new UserAccRep(getApplication());

    private final MutableLiveData<Boolean> _errorInputLogin = new MutableLiveData<>();

    public SupVmod(@NonNull Application application) {
        super(application);
    }

    public LiveData<Boolean> errorInputLogin() {
        return _errorInputLogin;
    }

    private final MutableLiveData<Boolean> _errorInputPass = new MutableLiveData<>();

    public LiveData<Boolean> errorInputPass() {
        return _errorInputPass;
    }

    private final MutableLiveData<Boolean> _errorInputEmail = new MutableLiveData<>();

    public LiveData<Boolean> errorInputEmail() {
        return _errorInputEmail;
    }

    private final MutableLiveData<Boolean> _errorInputPhone = new MutableLiveData<>();

    public LiveData<Boolean> errorInputPhone() {
        return _errorInputPhone;
    }

    public boolean createAccount(String login,
                                 String pass,
                                 String email,
                                 String phone,
                                 String name,
                                 String surname
    ) {

        dbRecord();

        boolean fieldsValid = validateInput(
                login,
                pass,
                email,
                phone
        );
        if (fieldsValid) {
            SupAccount registrationAccount = new SupAccount(
                    login,
                    pass,
                    email,
                    phone,
                    name,
                    surname
            );
            return repository.createAccount(registrationAccount);
        }
        return false;
    }

    private void dbRecord() {

    }

    private boolean validateInput(String login,
                                  String pass,
                                  String email,
                                  String phone
    ) {
        boolean result = true;
        if (login.equals("")) {
            _errorInputLogin.setValue(true);
            result = false;
        }
        if (pass.equals("")) {
            _errorInputPass.setValue(true);
            result = false;
        }
        if (email.equals("")) {
            _errorInputEmail.setValue(true);
            result = false;
        }
        if (phone.equals("")) {
            _errorInputPhone.setValue(true);
            result = false;
        }
        return result;
    }

    public void resetErrorInputLogin() {
        _errorInputLogin.setValue(false);
    }

    public void resetErrorInputPass() {
        _errorInputPass.setValue(false);
    }

    public void resetErrorInputEmail() {
        _errorInputEmail.setValue(false);
    }

    public void resetErrorInputPhone() {
        _errorInputPhone.setValue(false);
    }
}
