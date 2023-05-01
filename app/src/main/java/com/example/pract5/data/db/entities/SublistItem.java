package com.example.pract5.data.db.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "sub_table")
public class SublistItem {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    public Integer uid;

    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "class")
    public String classic;
    @ColumnInfo(name = "date")
    public String date;
    @ColumnInfo(name = "teacher")
    public String teacher;
    @ColumnInfo(name = "mark")
    public String mark;

    public SublistItem(String name,
                             String classic,
                             String date,
                             String teacher,
                             String mark) {
        this.name = name;
        this.classic = classic;
        this.date = date;
        this.teacher = teacher;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public String getClassic() {
        return classic;
    }

    public String getDate() {
        return date;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getMark() {
        return mark;
    }
}
