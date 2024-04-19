package com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.CourseDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Course;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.School;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Student;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.service.CourseService;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.service.SchoolService;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.service.StudentService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CourseController {
    CourseService courseService;

    SchoolService schoolService;

    StudentService studentService;

    public CourseController(CourseService courseService, SchoolService schoolService, StudentService studentService) {
        this.courseService = courseService;
        this.schoolService = schoolService;
        this.studentService = studentService;
    }

    public Course createCourse(CourseDTO courseDTO, Long schoolId) {
        School school = schoolService.getSchoolById(schoolId);
        return courseService.createCourse(courseDTO, school);

    }

    public Course updateCourseName(Long courseId, CourseDTO courseDTO) {
        Course course = courseService.getCourseById(courseId);
        course.setCourseName(courseDTO.getCourseName());
        return courseService.saveCourse(course);
    }

    public Course addStudentToCourse(Long courseId, Long studentId) {
        Course course = courseService.getCourseById(courseId);
        Student student = studentService.getStudentById(studentId);
        if(student!=null && course!=null){
            student.setCourse(course);
            course.addStudent(student);
            courseService.saveCourse(course);
        }
        return courseService.saveCourse(course);
    }

    public Course getCourseById(Long courseId) {
        return courseService.getCourseById(courseId);
    }

    public void deleteCourse(Long courseId) {
        Course course = courseService.getCourseById(courseId);
        List<Student> students = course.getStudents();
        for(Student student: students){
            student.setCourse(null);
            studentService.saveStudent(student);
        }
        courseService.deleteCourse(course);
    }
}
