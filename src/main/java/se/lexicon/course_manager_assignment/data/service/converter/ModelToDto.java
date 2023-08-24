package se.lexicon.course_manager_assignment.data.service.converter;

import org.springframework.stereotype.Component;
import se.lexicon.course_manager_assignment.dto.views.CourseView;
import se.lexicon.course_manager_assignment.dto.views.StudentView;
import se.lexicon.course_manager_assignment.model.Course;
import se.lexicon.course_manager_assignment.model.Student;


import java.util.Collection;
import java.util.List;

@Component
public class ModelToDto implements Converters {
    @Override
    public StudentView studentToStudentView(Student student)
    {
        StudentView studentView = new Student(int id, String name, String email, String address);
        studentView.getId();
        studentView.getName();
        studentView.getAddress();
        studentView.getEmail();
        return studentView;
    }

    @Override
    public CourseView courseToCourseView(Course course)
    {
        return null;
    }

    @Override
    public List<CourseView> coursesToCourseViews(Collection<Course> courses) {
        return null;
    }

    @Override
    public List<StudentView> studentsToStudentViews(Collection<Student> students) {
        return null;
    }
}
