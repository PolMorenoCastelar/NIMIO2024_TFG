package com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.TeacherDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Course;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Teacher;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.service.CourseService;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.service.TeacherService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TeacherController {

    TeacherService teacherService;
    CourseService courseService;

    public TeacherController(TeacherService teacherService, CourseService courseService) {
        this.teacherService = teacherService;
        this.courseService = courseService;
    }

    public Teacher createTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher(teacherDTO);
        return teacherService.createTeacher(teacher);
    }

    public Teacher updateTeacher(Long teacherId, TeacherDTO teacherDTO) {
        Teacher teacher = teacherService.getTeacherById(teacherId);
        teacher.setTeacherName(teacherDTO.getTeacherName());
        teacher.setTeacherSurname(teacherDTO.getTeacherSurname());
        List<Course> coursesList = teacherDTO.getCourses();
        teacher.setTeacherCourses(coursesList);
        return teacherService.saveTeacher(teacher);
    }

    public Teacher getTeacherById(Long teacherId) {
        return teacherService.getTeacherById(teacherId);
    }

    public List<Course> getTeacherCourses(Long teacherId) {
        Teacher teacher = teacherService.getTeacherById(teacherId);
        return teacher.getTeacherCourses();
    }

    public Teacher addCourseToTeacher(Long teacherId, Long courseId) {
        Teacher teacher = teacherService.getTeacherById(teacherId);
        Course course = courseService.getCourseById(courseId);
        if(course == null || teacher == null){
            System.err.println("Course or teacher not found");
            return null;
        }
        teacher.addCourse(course);
        course.setTeacher(teacher);

        return teacherService.saveTeacher(teacher);
    }

    public void deleteTeacher(Long teacherId) {
        teacherService.deleteTeacher(teacherId);
    }

    public Teacher replaceTeacher(Long teacherIdOld, Long teacherIdNew) {
        Teacher tOld = teacherService.getTeacherById(teacherIdOld);
        Teacher tNew = teacherService.getTeacherById(teacherIdNew);
        if(tOld == null || tNew == null){
            System.err.println("Teacher not found");
            return null;
        }
        List<Course> courses = tOld.getTeacherCourses();
        tNew.setTeacherCourses(courses);
        for(Course c : courses){
            c.setTeacher(tNew);
            //courseService.saveCourse(c);
        }
        return tNew;



    }

    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }
}
