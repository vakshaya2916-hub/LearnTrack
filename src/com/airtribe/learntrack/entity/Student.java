package com.airtribe.learntrack.entity;

public class Student extends Person{
    private String batch;
    private boolean active;


    public Student(int id, String firstName, String lastName, String email, String batch) {
        super(id, firstName, lastName, email != null && !email.isEmpty() ? email : "N/A");
        this.batch = batch;
        this.active = true;
    }


    public Student(int id, String firstName, String lastName, String batch) {
        this(id, firstName, lastName, "N/A", batch);
    }

    public void setActive(boolean active) { this.active = active; }

    public boolean isActive() {
        return active;
    }

    @Override
    public String getDisplayName() {
        return "Student: " + super.getDisplayName();
    }

    @Override
    public String toString() {
        return super.getId() + " | " + getDisplayName() + " | Email: " + super.getEmail() + " | Batch: " + batch + " | Active: " + active;
    }

    public String getUniqueKey() {
        // Combine fn, ln, email, batch in lowercase for case-insensitive comparison
        return (super.getFirstName() + "|" + super.getLastName() + "|" + super.getEmail()+ "|" + batch).toLowerCase();
    }



}
