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

    @PostMapping("{courseId}") // ST38F
    public Student createStudent(@RequestBody StudentDTO studentDTO, @PathVariable Long courseId) throws StudentAlreadyExistsException, CourseDoNotExistException {
        return studentController.createStudent(studentDTO, courseId);
    }

    @PostMapping("") // ST46F
    public Student createStudent(@RequestBody StudentDTO studentDTO) throws StudentAlreadyExistsException {
        return studentController.createStudent(studentDTO);
    }

    @PutMapping("/deleteAuth/{studentId}/{personId}") // ST41F
    public void deleteAuth(@PathVariable Long personId, @PathVariable Long studentId) {
        studentController.deleteAuth(personId, studentId);
    }

    @PutMapping("/{studentId}") // ST39F
    public Student updateStudent(@PathVariable Long studentId, @RequestBody StudentDTO studentDTO) throws StudentNotExistsException {
        return studentController.updateStudent(studentId, studentDTO);
    }

    @GetMapping("")
    public List<Student> getAllStudents() {
        return studentController.getAllStudents();
    }


    @GetMapping("/course/{courseId}") // CO16F & ST42F
    public List<Student> getStudentsByCourseId(@PathVariable Long courseId) throws CourseDoNotExistException {
        return studentController.getStudentByCourseId(courseId);
    }

    @GetMapping("/{studentId}") // ST43F
    public Student getStudentById(@PathVariable Long studentId) throws StudentNotExistsException {
        return studentController.getStudentById(studentId);
    }

    @GetMapping("/auth/{studentId}/{personId}") // CO29F & ST44F
    public boolean getAuth(@PathVariable Long personId, @PathVariable Long studentId) throws PersonNotExistsException, StudentNotExistsException {
        return studentController.checkAuth(personId, studentId);
    }

    @GetMapping("/authByDni/{studentDNI}/{personDNI}") // EX55F
    public boolean getAuthByDni(@PathVariable String personDNI, @PathVariable String studentDNI) throws PersonNotExistsException, StudentNotExistsException {
        return studentController.checkAuthByDni(personDNI, studentDNI);
    }

    @DeleteMapping("/{studentId}") // ST45F
    public void deleteStudent(@PathVariable Long studentId) {
        studentController.deleteStudent(studentId);
    }
}
