package com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.TeacherDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Course;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Teacher;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.service.TeacherService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TeacherController {

    TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
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
}
