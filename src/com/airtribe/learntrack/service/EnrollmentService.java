package com.airtribe.learntrack.service;

import java.util.ArrayList;
import java.util.List;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.util.IdGenerator;

public class EnrollmentService {

    private List<Enrollment> enrollments = new ArrayList<>();
    private CourseService courseService;
    private StudentService studentService;



    public EnrollmentService(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public void enroll(int studentId, int courseId) throws InvalidInputException, EntityNotFoundException {

        if (findEnrollment(studentId, courseId) != null) {
            throw new InvalidInputException("Student is already enrolled in this course.");
        }


        if (!courseService.isCourseActive(courseId)) {
            throw new InvalidInputException("Cannot enroll: Course is inactive.");
        }

        if (!studentService.isStudentActive(studentId)) {
            throw new InvalidInputException("Cannot enroll: Student is inactive.");
        }

        enrollments.add(new Enrollment(
                IdGenerator.getEnrollmentId(),
                studentId,
                courseId,
                Enrollment.EnrollmentStatus.ACTIVE
        ));
    }
    public void viewByStudent(int studentId) {
        boolean found = false;
        for (Enrollment e : enrollments) {
            if (e.getStudentId() == studentId) {
                System.out.println(e);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No enrollments found for student ID " + studentId);
        }
    }



    public void updateStatus(int studentId, int courseId, String status)
            throws InvalidInputException, EntityNotFoundException {


        Enrollment target = findEnrollment(studentId, courseId);

        if (target == null) {
            throw new EntityNotFoundException(
                    "Enrollment not found for Student ID " + studentId +
                            " and Course ID " + courseId
            );
        }

        try {
            Enrollment.EnrollmentStatus newStatus =
                    Enrollment.EnrollmentStatus.valueOf(status.toUpperCase());

            target.setStatus(newStatus);

            System.out.println("Enrollment status updated to " + newStatus);

        } catch (IllegalArgumentException e) {
            throw new InvalidInputException("Invalid status. Use ACTIVE, COMPLETED, or CANCELLED.");
        }
    }

    private Enrollment findEnrollment(int studentId, int courseId) {
        for (Enrollment e : enrollments) {
            if (e.getStudentId() == studentId && e.getCourseId() == courseId) {
                return e;
            }
        }
        return null;
    }
}