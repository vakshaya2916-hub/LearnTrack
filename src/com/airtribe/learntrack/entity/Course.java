package com.airtribe.learntrack.entity;

public class Course {
    private int id;
    private String courseName;
    private String description;
    private int durationInWeeks;
    private boolean active;

    public Course(int id, String courseName, String description, int durationInWeeks) {
        this.id = id;
        this.courseName = courseName;
        this.description = description;
        this.durationInWeeks = durationInWeeks;
        this.active = true;
    }

    public int getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return id + " - " + courseName +" - "+description+ " - "+" (" + durationInWeeks + " weeks) | Active: " + active;
    }
}
