package se.lexicon.course_manager_assignment.data.dao;
import se.lexicon.course_manager_assignment.model.Course;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class CourseCollectionRepository implements CourseDao{
    private Collection<Course> courses;
    public CourseCollectionRepository(Collection<Course> courses) {
        this.courses = courses;
    }

    @Override
    public Course createCourse(String courseName, LocalDate startDate, int weekDuration) {
        Course newCourse = new Course(courseName, startDate, weekDuration,new ArrayList<>());
        this.courses.add(newCourse);
        return newCourse;
    }

    @Override
    public Course findById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    @Override
    public Collection<Course> findByNameContains(String name)
    {
        Collection<Course> foundCourses = new HashSet<>();

        for (Course course : courses) {
            if (course.getCourseName().contains(name)) {
                foundCourses.add(course);
            }
        }

        return foundCourses;
    }
    @Override
    public Collection<Course> findByDateBefore(LocalDate end) {
        Collection<Course> foundCourses = new HashSet<>();

        for (Course course : courses) {
            if (course.getStartDate().isBefore(end)) {
                foundCourses.add(course);
            }
        }

        return foundCourses;
    }
    @Override
    public Collection<Course> findByDateAfter(LocalDate start) {
        Collection<Course> foundCourses = new HashSet<>();

        for (Course course : courses) {
            if (course.getStartDate().isAfter(start)) {
                foundCourses.add(course);
            }
        }

        return foundCourses;

    }

    @Override
    public Collection<Course> findAll() {
        return courses;
    }
    @Override
    public Collection<Course> findByStudentId(int studentId) {
        Collection<Course> foundCourses = new HashSet<>();

        for (Course course : courses) {
            if (course.hasStudent(studentId)) {
                foundCourses.add(course);
            }
        }

        return foundCourses;
    }
    @Override
    public boolean removeCourse(Course course) {
        return courses.remove(course);
    }

    @Override
    public void clear() {
        this.courses = new HashSet<>();
        courses.clear();
    }
}
