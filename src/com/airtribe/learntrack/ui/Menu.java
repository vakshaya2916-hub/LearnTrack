package com.airtribe.learntrack.ui;

import java.util.Scanner;

import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.service.*;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.InputValidator;

public class Menu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService(studentService, courseService);

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Deactivate Student");
            System.out.println("5. Add New Course");
            System.out.println("6. View Courses");
            System.out.println("7. Activate/Deactivate Course");
            System.out.println("8. Enroll Student");
            System.out.println("9. View Enrollments");
            System.out.println("10. Update Enrollment Status");
            System.out.println("11. Exit");

            try {

                int choice = InputValidator.readInt(sc, "Choose option: ");

                switch (choice) {

                    case 1:
                        System.out.print("First Name: ");
                        String fn = sc.nextLine();
                        System.out.print("Last Name: ");
                        String ln = sc.nextLine();
                        System.out.print("Email: ");
                        String email = sc.nextLine();
                        System.out.print("Batch: ");
                        String batch = sc.nextLine();
                        InputValidator.validateStudentInput(fn, ln, batch);
                        studentService.addStudent(fn, ln, email, batch);
                        break;

                    case 2:
                        studentService.listStudents();
                        break;

                    case 3:
                        int searchId = InputValidator.readInt(sc, "Enter ID: ");
                        System.out.println(studentService.findById(searchId));
                        break;

                    case 4:
                        int deactivateId = InputValidator.readInt(sc, "Enter ID: ");
                        studentService.deactivateStudent(deactivateId);
                        break;

                    case 5:
                        System.out.print("Course Name: ");
                        String cn = sc.nextLine();
                        System.out.print("Description: ");
                        String desc = sc.nextLine();
                        int dur = InputValidator.readInt(sc, "Duration: ");
                        courseService.addCourse(cn, desc, dur);
                        break;

                    case 6:
                        courseService.listCourses();
                        break;

                    case 7:
                        int courseId = InputValidator.readInt(sc, "Course ID: ");
                        courseService.activateOrDeactivateCourse(courseId);
                        break;

                    case 8:
                        int sid = InputValidator.readInt(sc, "Student ID: ");
                        int cid = InputValidator.readInt(sc, "Course ID: ");
                        //studentService.findById(sid);
                       // courseService.findById(cid);
                        enrollmentService.enroll(sid, cid);
                        break;

                    case 9:
                        int viewSid = InputValidator.readInt(sc, "Student ID: ");
                        enrollmentService.viewByStudent(viewSid);
                        break;

                    case 10:
                        try {
                            int sId = InputValidator.readInt(sc, "Student ID: ");
                            int cId = InputValidator.readInt(sc, "Course ID: ");
                            System.out.print("Update Status to ACTIVE/COMPLETED/CANCELLED: ");
                            String status = sc.nextLine();
                            enrollmentService.updateStatus(sId, cId, status);
                        } catch (InvalidInputException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 11:
                        System.exit(0);

                    default:
                        System.out.println("Invalid option");
                }

            } catch (EntityNotFoundException | InvalidInputException  | NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
    }
}