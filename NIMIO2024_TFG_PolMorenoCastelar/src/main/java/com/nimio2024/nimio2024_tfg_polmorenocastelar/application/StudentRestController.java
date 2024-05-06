package com.nimio2024.nimio2024_tfg_polmorenocastelar.application;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.StudentDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.CourseDoNotExistException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.PersonNotExistsException;
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

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable Long studentId) throws StudentNotExistsException {
        return studentController.getStudentById(studentId);
    }

    @GetMapping("/auth/{studentId}/{personId}")
    public boolean getAuth(@PathVariable Long personId, @PathVariable Long studentId) throws PersonNotExistsException, StudentNotExistsException {
        return studentController.checkAuth(personId, studentId);
    }

    @GetMapping("/authByDni/{studentDNI}/{personDNI}")
    public boolean getAuthByDni(@PathVariable String personDNI, @PathVariable String studentDNI) throws PersonNotExistsException, StudentNotExistsException {
        return studentController.checkAuthByDni(personDNI, studentDNI);
    }



    @PutMapping("/deleteAuth/{studentId}/{personId}")
    public void deleteAuth(@PathVariable Long personId, @PathVariable Long studentId) {
        studentController.deleteAuth(personId, studentId);
    }


    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentController.deleteStudent(studentId);
    }




}
