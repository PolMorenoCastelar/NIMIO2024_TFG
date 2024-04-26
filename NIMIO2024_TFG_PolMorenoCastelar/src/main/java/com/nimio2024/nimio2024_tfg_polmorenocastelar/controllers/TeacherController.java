package com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.TeacherDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.CourseDoNotExistException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.TeacherAlreadyExistsException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.TeacherDoNotExistException;
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

    public Teacher createTeacher(TeacherDTO teacherDTO) throws TeacherAlreadyExistsException {
        if(teacherService.findTeacherByDNI(teacherDTO.getTeacher_DNI())!= null){
            throw new TeacherAlreadyExistsException("Teacher with DNI: " + teacherDTO.getTeacher_DNI() + " already exists");
        }
        Teacher teacher = new Teacher(teacherDTO);
        return teacherService.createTeacher(teacher);
    }

    public Teacher updateTeacher(Long teacherId, TeacherDTO teacherDTO) throws TeacherDoNotExistException {
        Teacher teacher = teacherService.getTeacherById(teacherId);
        if(teacher == null){
            throw new TeacherDoNotExistException("Teacher with id: " + teacherId + " does not exist");
        }
        teacher.setTeacherName(teacherDTO.getTeacherName());
        teacher.setTeacherSurname(teacherDTO.getTeacherSurname());
        List<Course> coursesList = teacher.getCourses();
        teacher.setTeacherCourses(coursesList);
        return teacherService.saveTeacher(teacher);
    }

    public Teacher getTeacherById(Long teacherId) throws TeacherDoNotExistException {
        Teacher teacher = teacherService.getTeacherById(teacherId);
        if(teacher == null){
            throw new TeacherDoNotExistException("Teacher with id: " + teacherId + " does not exist");
        }
        return teacher;
    }

    public List<Course> getTeacherCourses(Long teacherId) throws TeacherDoNotExistException {
        Teacher teacher = teacherService.getTeacherById(teacherId);
        if(teacher == null){
            throw new TeacherDoNotExistException("Teacher with id: " + teacherId + " does not exist");
        }
        return teacher.getTeacherCourses();
    }

    public Teacher addCourseToTeacher(Long teacherId, Long courseId) throws TeacherDoNotExistException, CourseDoNotExistException {
        Teacher teacher = teacherService.getTeacherById(teacherId);
        if(teacher == null){
            throw new TeacherDoNotExistException("Teacher with id: " + teacherId + " does not exist");
        }
        Course course = courseService.getCourseById(courseId);
        if(course == null){
            throw new CourseDoNotExistException("Course with id: " + courseId + " does not exist");
        }
        teacher.addCourse(course);
        course.setTeacher(teacher);

        return teacherService.saveTeacher(teacher);
    }

    public void deleteTeacher(Long teacherId) {
        teacherService.deleteTeacher(teacherId);
    }

    public Teacher replaceTeacher(Long teacherIdOld, Long teacherIdNew) throws TeacherDoNotExistException {
        Teacher tOld = teacherService.getTeacherById(teacherIdOld);
        if(tOld == null){
            throw new TeacherDoNotExistException("Teacher with id: " + teacherIdOld + " does not exist");
        }
        Teacher tNew = teacherService.getTeacherById(teacherIdNew);
        if(tNew == null){
            throw new TeacherDoNotExistException("Teacher with id: " + teacherIdNew + " does not exist");
        }
        List<Course> courses = tOld.getTeacherCourses();
        tNew.setTeacherCourses(courses);
        for(Course c : courses){
            c.setTeacher(tNew);
        }
        return tNew;



    }

    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }
}
