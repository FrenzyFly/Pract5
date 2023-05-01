package com.example.pract5.data.protocols;

import androidx.lifecycle.LiveData;

import com.example.pract5.data.db.entities.SublistItem;

import java.util.List;

public interface SublistProtocol {
    LiveData<SublistItem> getSublistItem(int position);

    LiveData<List<SublistItem>> getSublist();
}
