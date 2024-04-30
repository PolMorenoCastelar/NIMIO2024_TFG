package com.nimio2024.nimio2024_tfg_polmorenocastelar.application;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.StudentDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.CourseDoNotExistException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.StudentAlreadyExistsException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.StudentNotExistsException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers.StudentController;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Course;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentRestController {
    StudentController studentController;

    public StudentRestController(StudentController studentController) {
        this.studentController = studentController;
    }

    @PostMapping("{courseId}")
    public Student createStudent(@RequestBody StudentDTO studentDTO, @PathVariable Long courseId) throws StudentAlreadyExistsException, CourseDoNotExistException {
        return studentController.createStudent(studentDTO, courseId);
    }

    @PostMapping("")
    public Student createStudent(@RequestBody StudentDTO studentDTO) throws StudentAlreadyExistsException {
        return studentController.createStudent(studentDTO);
    }

    @GetMapping("")
    public List<Student> getAllStudents() {
        return studentController.getAllStudents();
    }

    @PutMapping("/{studentId}")
    public Student updateStudent(@PathVariable Long studentId, @RequestBody StudentDTO studentDTO) throws StudentNotExistsException {
        return studentController.updateStudent(studentId, studentDTO);
    }

    @GetMapping("/course/{courseId}")
    public List<Student> getStudentsByCourseId(@PathVariable Long courseId) throws CourseDoNotExistException {
        return studentController.getStudentByCourseId(courseId);
    }



}
