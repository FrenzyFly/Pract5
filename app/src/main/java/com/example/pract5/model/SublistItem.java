package com.example.pract5.model;

public class SublistItem {

    private final String name;
    private final String classic;
    private final String timeStartEnd;
    private final String date;
    private final String teacher;

    public SublistItem(String name, String classic, String timeStartEnd, String date, String teacher) {
        this.name = name;
        this.classic = classic;
        this.timeStartEnd = timeStartEnd;
        this.date = date;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public String getClassic() {
        return classic;
    }

    public String getTimeStartEnd() {
        return timeStartEnd;
    }

    public String getDate() {
        return date;
    }

    public String getTeacher() {
        return teacher;
    }
}
