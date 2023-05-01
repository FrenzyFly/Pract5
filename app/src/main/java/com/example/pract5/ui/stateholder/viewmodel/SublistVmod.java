package com.example.pract5.ui.stateholder.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.pract5.data.repositories.SublistRep;
import com.example.pract5.data.db.entities.SublistItem;

import java.util.List;

public class SublistVmod extends AndroidViewModel {

    private final SublistRep repository = new SublistRep(getApplication());

    public LiveData<List<SublistItem>> sublist = repository.getSublist();

    public SublistVmod(@NonNull Application application) {
        super(application);
    }
}
