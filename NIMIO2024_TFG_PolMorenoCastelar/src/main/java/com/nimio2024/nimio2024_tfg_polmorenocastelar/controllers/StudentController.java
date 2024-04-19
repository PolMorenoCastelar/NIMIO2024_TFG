package com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.StudentDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Course;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Student;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.persistence.CourseRepository;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.service.CourseService;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.service.StudentService;
import org.springframework.stereotype.Controller;

@Controller
public class StudentController {
    StudentService studentService;
    CourseService courseService;

    public StudentController(StudentService studentService, CourseService courseService) {

        this.studentService = studentService;
        this.courseService = courseService;
    }

    public Student createStudent(StudentDTO studentDTO, Long courseId) {
        Student student = new Student(studentDTO);
        studentService.saveStudent(student);
        Course course = courseService.getCourseById(courseId);
        course.addStudent(student);
        courseService.saveCourse(course);
        return studentService.saveStudent(student);
    }
}
