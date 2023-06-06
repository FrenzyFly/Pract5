package com.example.pract5;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class SinVmod extends AndroidViewModel {

    private final UserAccProtocol repository = new UserAccRep(getApplication());

    private final MutableLiveData<Boolean> _errorInputLogin = new MutableLiveData<>();

    public SinVmod(@NonNull Application application) {
        super(application);
    }

    public LiveData<Boolean> errorInputLogin() {
        return _errorInputLogin;
    }

    private final MutableLiveData<Boolean> _errorInputPass = new MutableLiveData<>();

    public LiveData<Boolean> errorInputPass() {
        return _errorInputPass;
    }


    public boolean sinAcc(String login, String pass, boolean allowed) {
        boolean fieldsValid = validateInput(login, pass);
        if (fieldsValid) {
            SinAccount loginAccount = new SinAccount(login, pass);
            return repository.loginAccount(loginAccount, allowed);
        }
        return false;
    }

    private boolean validateInput(String login, String pass) {
        boolean result = true;
        if (login.equals("")) {
            _errorInputLogin.setValue(true);
            result = false;
        }
        if (pass.equals("")) {
            _errorInputPass.setValue(true);
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
}
