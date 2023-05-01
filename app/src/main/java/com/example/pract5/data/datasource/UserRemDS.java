package com.example.pract5.data.datasource;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.example.pract5.data.models.SinAccount;
import com.example.pract5.data.models.SupAccount;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class UserRemDS {

    private final Context context;

    public UserRemDS(Context context) {
        this.context = context;
    }

    public boolean checkLoginValid(SinAccount sinAcc, boolean allowed) {
        if (allowed) {
            String filename = "login";
            String fileContents = sinAcc.getLogin();
            File file_login = new File("/storage/emulated/0/Android/data", filename);
            try {
                FileOutputStream fos = new FileOutputStream(file_login);
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
                writer.write(fileContents);
                writer.close();
                fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        return !sinAcc.getLogin().equals("") && !sinAcc.getPassword().equals("");
    }

    public boolean checkRegistrationValid(SupAccount supAcc) {
        String filename = "email";
        String fileContents = supAcc.getEmail();
        File dir = context.getFilesDir();
        File file_email = new File(dir, filename);
        try {
            FileOutputStream fos = new FileOutputStream(file_email);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
            writer.write(fileContents);
            writer.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return !supAcc.getLogin().equals("") &&
                !supAcc.getPassword().equals("") &&
                !supAcc.getEmail().equals("") &&
                !supAcc.getPhone().equals("");
    }
}
