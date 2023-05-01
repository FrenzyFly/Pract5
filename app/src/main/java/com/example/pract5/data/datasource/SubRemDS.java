package com.example.pract5.data.datasource;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.pract5.data.db.SubDB;
import com.example.pract5.data.db.dao.SubDao;
import com.example.pract5.data.db.entities.SublistItem;

import java.util.ArrayList;
import java.util.List;

public class SubRemDS {

    private final Context context;

    public SubRemDS(Context context) {
        this.context = context;
    }

    public LiveData<SublistItem> getSublistItem(int position) {
        SubDB db = SubDB.getDatabase(context);
        SubDao subDao = db.subDao();
        return subDao.getItem(position + 1);
    }

    public LiveData<List<SublistItem>> getHackathonList() {
        List<SublistItem> subListItems = new ArrayList<>();

        String[] names = {"ГЕОГРАФИЯ", "ИСТОРИЯ", "МАТЕМАТИКА", "АНГЛИЙСКИЙ", "БИОЛОГИЯ", "ОБЩЕТСВОЗНАНИЕ", "ИНФОРМАТИКА"};
        String[] classics = {"A-1", "A-2", "A-3", "A-4", "A-5", "Б-1", "Б-2", "Б-3", "В-1", "В-2"};
        String[] date = {"24.01.2023", "24.02.2023", "24.03.2023"};
        String[] teachers = {"Иванова А.А.", "Петрова Е.Е.", "Сидоров Б.Б."};
        String[] mark = {"2", "3", "4", "5", "-", "н", "у"};

        for (int i = 0; i < 50; i++) {
            subListItems.add(
                    new SublistItem(
                            names[(int) (Math.random() * names.length)],
                            classics[(int) (Math.random() * classics.length)],
                            date[(int) (Math.random() * date.length)],
                            teachers[(int) (Math.random() * teachers.length)],
                            mark[(int) (Math.random() * mark.length)]
                    )
            );
        }

        SubDB db = SubDB.getDatabase(context);
        SubDao subDao = db.subDao();
        db.getQueryExecutor().execute(() -> {
            for (SublistItem subs : subListItems) {
                subDao.insert(subs);
                Log.d("myLogs", String.valueOf(subs.uid));
            }
        });

        return subDao.getSubList();
    }
}
