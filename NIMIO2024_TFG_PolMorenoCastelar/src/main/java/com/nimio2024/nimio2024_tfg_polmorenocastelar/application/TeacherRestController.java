package com.nimio2024.nimio2024_tfg_polmorenocastelar.application;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.TeacherDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.CourseDoNotExistException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.TeacherAlreadyExistsException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.TeacherDoNotExistException;
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
    public Teacher createTeacher(@RequestBody TeacherDTO teacherDTO) throws TeacherAlreadyExistsException {
        return teacherController.createTeacher(teacherDTO);
    }

    @PutMapping("/{teacherId}")
    public Teacher updateTeacher(@PathVariable Long teacherId, @RequestBody TeacherDTO teacherDTO) throws TeacherDoNotExistException {
        return teacherController.updateTeacher(teacherId, teacherDTO);
    }

    @GetMapping("/{teacherId}")
    public Teacher getTeacherById(@PathVariable Long teacherId) throws TeacherDoNotExistException {
        return teacherController.getTeacherById(teacherId);
    }

    @GetMapping ("/courses/{teacherId}")
    public List<Course> getTeacherCourses(@PathVariable Long teacherId) throws TeacherDoNotExistException {
        return teacherController.getTeacherCourses(teacherId);
    }

    @GetMapping("")
    public List<Teacher> getAllTeachers(){
        return teacherController.getAllTeachers();
    }

    @PutMapping("/{teacherId}/addCourse/{courseId}")
    public Teacher addCourseToTeacher(@PathVariable Long teacherId, @PathVariable Long courseId) throws CourseDoNotExistException, TeacherDoNotExistException {
        return teacherController.addCourseToTeacher(teacherId, courseId);
    }

    @PutMapping("/{teacherIdOld}/replace/{teacherIdNew}")
    public Teacher replaceTeacher(@PathVariable Long teacherIdOld, @PathVariable Long teacherIdNew) throws TeacherDoNotExistException {
        return teacherController.replaceTeacher(teacherIdOld, teacherIdNew);
    }

    @DeleteMapping("/{teacherId}")
    public void deleteTeacher(@PathVariable Long teacherId){
        teacherController.deleteTeacher(teacherId);
    }



}
