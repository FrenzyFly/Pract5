package com.example.pract5.ui.stateholder.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.pract5.data.repositories.SublistRep;
import com.example.pract5.data.db.entities.SublistItem;

public class SublistItemVmod extends AndroidViewModel {

    private final SublistRep repository = new SublistRep(getApplication());

    public LiveData<SublistItem> sublistItem;

    public SublistItemVmod(@NonNull Application application) {
        super(application);
    }

    public void getSublistItem(int position) {
        sublistItem = repository.getSublistItem(position);
    }
}
