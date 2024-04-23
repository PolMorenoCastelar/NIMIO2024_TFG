package com.nimio2024.nimio2024_tfg_polmorenocastelar.application;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.TeacherDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers.TeacherController;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Course;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Teacher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherRestController {

    TeacherController teacherController;

    public TeacherRestController(TeacherController teacherController) {
        this.teacherController = teacherController;
    }

    @PostMapping("")
    public Teacher createTeacher(@RequestBody TeacherDTO teacherDTO){
        return teacherController.createTeacher(teacherDTO);
    }

    @PutMapping("/{teacherId}")
    public Teacher updateTeacher(@PathVariable Long teacherId, @RequestBody TeacherDTO teacherDTO){
        return teacherController.updateTeacher(teacherId, teacherDTO);
    }

    @GetMapping("/{teacherId}")
    public Teacher getTeacherById(@PathVariable Long teacherId){
        return teacherController.getTeacherById(teacherId);
    }

    @GetMapping ("/courses/{teacherId}")
    public List<Course> getTeacherCourses(@PathVariable Long teacherId){
        return teacherController.getTeacherCourses(teacherId);
    }

    @PutMapping("/{teacherId}/addCourse/{courseId}")
    public Teacher addCourseToTeacher(@PathVariable Long teacherId, @PathVariable Long courseId){
        return teacherController.addCourseToTeacher(teacherId, courseId);
    }



}
