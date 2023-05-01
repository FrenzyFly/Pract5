package com.example.pract5.data.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.pract5.data.db.entities.SublistItem;

import java.util.List;

@Dao
public interface SubDao {
    @Query("SELECT * FROM sub_table")
    LiveData<List<SublistItem>> getSubList();
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(SublistItem subListItem);
    @Query("SELECT * FROM sub_table WHERE :id LIKE id")
    LiveData<SublistItem> getItem(int id);
}
