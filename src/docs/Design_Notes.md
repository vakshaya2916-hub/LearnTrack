# Why you used ArrayList instead of array

ArrayList was used instead of arrays because:

It is dynamic in size (no need to define size beforehand)
Easier to add and remove elements
Provides built-in methods like add(), remove(), size()
More flexible for managing collections of objects like Students, Courses, and Enrollments

# Where you used static members and why
Static members were used in the IdGenerator class:

Static variables: studentId, courseId, enrollmentId
Static methods: getStudentId(), getCourseId(), getEnrollmentId()

IDs should be shared across the entire application
No need to create an object of IdGenerator
Ensures unique ID generation globally

# Where you used inheritance and what you gained from it

Inheritance was implemented using:

Person (base class)
Student (derived class)
Benefits:
Avoids code duplication (firstName, lastName, email reused)
Improves code reusability
Makes structure more organized and scalable
Demonstrates real-world relationship (Student is a Person)