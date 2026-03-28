package com.airtribe.learntrack.service;

import java.util.ArrayList;
import java.util.List;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.exception.EntityNotFoundException;

public class CourseService {

    private List<Course> courses = new ArrayList<>();



    public void addCourse(String name, String desc, int duration) throws InvalidInputException {
        if (duration <= 0) {
            throw new InvalidInputException("Duration must be greater than 0");
        }

        courses.add(new Course(IdGenerator.getCourseId(), name, desc, duration));
    }

    public Course findById(int id) throws EntityNotFoundException {
        for (Course c : courses) {
            if (c.getId() == id) return c;
        }
        throw new EntityNotFoundException("Course not found");
    }

    public void activateOrDeactivateCourse (int id) throws EntityNotFoundException {
        Course c = findById(id);
        c.setActive(!c.isActive());
    }

    public void listCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        for (Course c : courses) {
            System.out.println("Course added: " + c);
        }
    }

    public boolean isCourseActive(int courseId) throws EntityNotFoundException {
        return findById(courseId).isActive();
    }

}