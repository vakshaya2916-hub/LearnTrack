package com.airtribe.learntrack.service;

import java.util.ArrayList;
import java.util.List;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.exception.EntityNotFoundException;

public class StudentService {

    private List<Student> students = new ArrayList<>();

    public void addStudent(String fn, String ln,String email, String batch) throws InvalidInputException {
        String newStudentKey = (fn + "|" + ln + "|" + email + "|" + batch).toLowerCase();
        for (Student s : students) {
            if (s.getUniqueKey().equals(newStudentKey)) {
                throw new InvalidInputException(
                        "Student already exists: " + fn + " " + ln + " | Batch: " + batch + " | Email: " + email
                );
            }
        }
        students.add(new Student(IdGenerator.getStudentId(), fn, ln,email, batch));
    }

    public Student findById(int id) throws EntityNotFoundException {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        throw new EntityNotFoundException("Student not found");
    }

    public void deactivateStudent(int id) throws EntityNotFoundException {
        Student s = findById(id);
        s.setActive(false);
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public boolean isStudentActive(int studentId) throws EntityNotFoundException {
        return findById(studentId).isActive();
    }
}