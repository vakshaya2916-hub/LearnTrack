LearnTrack - Student & Course Management System

# Project Description

LearnTrack is a console-based application built using Core Java.
It allows administrators to manage:
* Students
* Courses
* Enrollments

The project focuses on practicing Java fundamentals such as OOP concepts, collections, exception handling, and clean code design.

# Features

1. Student Management
2. Add new student
3. View all students
4. Search student by ID
5. Deactivate student
6. Course Management
7. Add new course
8. View all courses
9. Activate/Deactivate course
10. Enrollment Management
11. Enroll a student in a course
12. View enrollments for a student
13. Update enrollment status (ACTIVE, COMPLETED, CANCELLED)

# How to Compile and Run

Step 1: Compile

Navigate to the src folder and run:
javac com/airtribe/learntrack/ui/Menu.java

Step 2: Run
java com.airtribe.learntrack.ui.Menu

# #Class Diagram


## Class Diagram

```
          +-------------------+
          |      Person       |
          +-------------------+
          | - id              |
          | - firstName       |
          | - lastName        |
          | - email           |
          +-------------------+
          | + getDisplayName()|
          +-------------------+
                    ▲
                    |
          +-------------------+
          |      Student      |
          +-------------------+
          | - batch           |
          | - active          |
          +-------------------+
          | + isActive()      |
          +-------------------+


+---------------------+        +----------------------+
|       Course        |        |     Enrollment       |
+---------------------+        +----------------------+
| - id                |        | - id                 |
| - courseName        |        | - studentId          |
| - description       |        | - courseId           |
| - durationInWeeks   |        | - enrollmentDate     |
| - active            |        | - status             |
+---------------------+        +----------------------+


+------------------------+
|    StudentService      |
+------------------------+
| - students             |
+------------------------+
| + addStudent()         |
| + findById()           |
| + deactivateStudent()  |
+------------------------+

+------------------------+
|     CourseService      |
+------------------------+
| - courses              |
+------------------------+
| + addCourse()          |
| + findById()           |
| + activateOrDeactivateCourse() |
+------------------------+

+----------------------------+
|    EnrollmentService       |
+----------------------------+
| - enrollments              |
| - studentService           |
| - courseService            |
+----------------------------+
| + enroll()                 |
| + updateStatus()           |
+----------------------------+


+---------------------+
|    IdGenerator      |
+---------------------+
| - studentId         |
| - courseId          |
| - enrollmentId      |
+---------------------+
| + getStudentId()    |
| + getCourseId()     |
| + getEnrollmentId() |
+---------------------+
```

# Relationships

* Student **inherits** from Person (Inheritance)
* Enrollment connects Student and Course (Association)
* Service classes handle business logic for entities
* EnrollmentService depends on StudentService and CourseService
* IdGenerator provides unique IDs using static methods
