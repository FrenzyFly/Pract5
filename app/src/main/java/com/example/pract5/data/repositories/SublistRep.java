package com.example.pract5.data.repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.pract5.data.datasource.SubRemDS;
import com.example.pract5.data.protocols.SublistProtocol;
import com.example.pract5.data.db.entities.SublistItem;

import java.util.List;

public class SublistRep implements SublistProtocol {

    private final Context context;

    private List<SublistItem> list;

    private final SubRemDS subRemDS;

    public SublistRep(Context context) {
        this.context = context;
        subRemDS = new SubRemDS(context);
    }

    @Override
    public LiveData<SublistItem> getSublistItem(int position) {
        return subRemDS.getSublistItem(position);
    }

    @Override
    public LiveData<List<SublistItem>> getSublist() {
        list = subRemDS.getHackathonList().getValue();
        return subRemDS.getHackathonList();
    }
}
